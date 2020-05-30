package it.univpm.OOP2020.TwitterTrends.dbConnection;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.univpm.OOP2020.TwitterTrends.Util.urlConnection;
import it.univpm.OOP2020.TwitterTrends.exception.IncorrectFileLocation;
import it.univpm.OOP2020.TwitterTrends.model.Coordinata;
import it.univpm.OOP2020.TwitterTrends.model.Location;
import it.univpm.OOP2020.TwitterTrends.model.Metadata;
import it.univpm.OOP2020.TwitterTrends.model.Stats;

/**
 * @author Andrea Camilloni
 *
 */
public class TrendsDownload {
	// private String url;
	private static List<Location> trendsAvailable;
	private static List<Location> trendsClosest;
	//private static JSONParser parser = new JSONParser();
	private String url;
	private static List<Metadata> metadata;
	
	public TrendsDownload() {

	}

	
	public List<Location> getTrendsAvailable() {
		url = "https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/api/1.1/trends/available.json";
		try {
			JSONArray jsonList = (JSONArray) JSONValue.parseWithException(new urlConnection(url).getJSON());
		
			trendsAvailable = new ObjectMapper().readValue(jsonList.toString(), new TypeReference<List<Location>>() {
			});

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return trendsAvailable;

	}

	public static List<Coordinata> getCoord() throws IncorrectFileLocation{
		BufferedReader reader;
		String line = null;
		Scanner scanner = null;
		List<Coordinata> listCoordinate = new ArrayList<>();
		int index = 0;
		try {
			reader = new BufferedReader(
					new FileReader(new File("location.txt")));
			
			while ((line = reader.readLine()) != null) {
				Coordinata coord = new Coordinata();
				scanner = new Scanner(line);
				scanner.useDelimiter(",");
				while (scanner.hasNext()) {
					String data = scanner.next();
					if (index == 0)
						coord.setLat(Double.valueOf(data));
					else if (index == 1)
						coord.setLon(Double.valueOf(data));
					else
						System.out.println("invalid data::" + data);
					index++;
				}
				index = 0;
				listCoordinate.add(coord);
			}

			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("File location.txt non trovato!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("");
			e.printStackTrace();
		}

		return listCoordinate;

	}
	
	public List<Location> getTrendsClosest() {
		String urlResponse;
		JSONObject obj;
		//JSONValue obj; 
		String listaAppoggio="[";
		try {
			for (Coordinata coordinata : TrendsDownload.getCoord()) {
				url="https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/api/1.1/trends/closest.json?lat="
						+ coordinata.getLat() + "&long=" + coordinata.getLon();
				urlResponse = new urlConnection(url).getJSON();
				obj = (JSONObject) JSONValue.parseWithException(urlResponse.substring(1,(urlResponse.length()-1))); 
				listaAppoggio+=obj+",";				
				
			}
			listaAppoggio=listaAppoggio.substring(0,listaAppoggio.length()-1)+"]";
			//Creo il JSONArray che vado poi a passare nella lista che andrò a visualizzare con GET /Data
			JSONArray jsonTrends = (JSONArray) JSONValue.parseWithException(listaAppoggio);
			trendsClosest=new ObjectMapper().readValue(jsonTrends.toString(), new TypeReference<List<Location>>() {});
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return trendsClosest;

	}

	
	@SuppressWarnings("unchecked")
	public List<Metadata> getMetadata() {
		metadata = new JSONArray();
		metadata.add(new Metadata("name", "name", "String"));
		metadata.add(new Metadata("PlaceType", "placeType", "Object"));
		metadata.add(new Metadata("placeTypeCode", "code", "Integer"));
		metadata.add(new Metadata("placeTypeName", "name", "String"));
		metadata.add(new Metadata("url", "url", "String"));
		metadata.add(new Metadata("parentid", "parentid", "Integer"));
		metadata.add(new Metadata("country", "country", "String"));
		metadata.add(new Metadata("woeid", "woeid", "Integer"));
		metadata.add(new Metadata("countryCode", "countryCode", "String"));

		return metadata;
	}
	public List<Stats> getProva(){
		getTrendsAvailable();
		Iterator<Location> it = trendsAvailable.iterator();
		List<Stats> CountryAvailable = new ArrayList<Stats>();
		
		int i = 0;
		
		while (it.hasNext()) {
			Location tmpLoc = it.next();
			if (tmpLoc.getPlaceType().getPlaceTypeName().equals("Country")) {
				//System.out.println(tmpLoc.getCountryCode());
				Stats stats=new Stats(tmpLoc,i);
				//stats.setCount(i);
				CountryAvailable.add(stats);
			}
		}
		//System.out.println(CountryAvailable);
		for (Stats tmpCountry : CountryAvailable) {
			i = 0;
			for (Location trend : trendsAvailable) {
				//System.out.println(trend.getCountryCode());
				if (trend.getCountryCode()!=null)
					if (trend.getCountryCode().equals(tmpCountry.getLoc().getCountryCode()))
					{	i++; tmpCountry.setCount(i);}
					
			}
			System.out.println("Per: " + tmpCountry.getLoc().getCountryCode() + " si hanno: " + tmpCountry.getCount() + "trend");

		}
		Collections.sort(CountryAvailable,new Comparator<Stats>() {

			public int compare(Stats o1, Stats o2) {
				// TODO Auto-generated method stub
				return o1.getCount() > o2.getCount() ? -1 : (o1.getCount() < o2.getCount() ) ? 1 : 0;
				 
			}
		});
		//System.out.println(CountryAvailable);
		return CountryAvailable;
		
		
	}
	
}
