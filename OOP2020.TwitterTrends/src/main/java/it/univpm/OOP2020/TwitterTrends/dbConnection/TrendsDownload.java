package it.univpm.OOP2020.TwitterTrends.dbConnection;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.univpm.OOP2020.TwitterTrends.exception.IncorrectFileLocation;
import it.univpm.OOP2020.TwitterTrends.model.Coordinata;
import it.univpm.OOP2020.TwitterTrends.model.Location;
import it.univpm.OOP2020.TwitterTrends.model.Metadata;

public class TrendsDownload {
	// private String url;
	private static List<Location> trendsAvailable;
	private static List<Location> trendsClosest;
	//private static List<Coordinata> listCoordinate;
	private static List<Metadata> metadata = new JSONArray();
	static JSONParser parser = new JSONParser();
	// private static TrendModel trends ;
	 String urlResponse;
	 private static List<JSONObject> listaJson;
	public TrendsDownload() {

	}

	/*
	 * public String[] TrendsCloset() { JSONParser parser = new JSONParser(); try {
	 * // URLConnection urlConnection = new // URL(
	 * "https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/api/1.1/trends/closest.json?lat=43.508321&long=13.376535"
	 * ).openConnection(); String jsonString = new Scanner(new URL(
	 * "https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/api/1.1/trends/closest.json?lat=43.508321&long=13.376535")
	 * .openStream(), "UTF-8").useDelimiter("\\A").next();
	 * 
	 * JSONArray jsonOB = (JSONArray) parser.parse(jsonString);
	 * System.out.print(jsonOB); } catch (Exception e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); }
	 * 
	 * }
	 */

	public List<Location> getTrendsAvailable() {
		// JSONParser parser = new JSONParser();
		try {
			// URLConnection urlConnection = new
			// URL("https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/api/1.1/trends/closest.json?lat=43.508321&long=13.376535").openConnection();
			@SuppressWarnings("resource")
			String jsonString = new Scanner(
					new URL("https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/api/1.1/trends/available.json")
							.openStream(),
					"UTF-8").useDelimiter("\\A").next();

			JSONArray jsonList = (JSONArray) parser.parse(jsonString);
			// System.out.print(jsonOB);

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
			
			//List<Coordinata> empList = new ArrayList<>();

			while ((line = reader.readLine()) != null) {
				Coordinata coord = new Coordinata();
				scanner = new Scanner(line);
				scanner.useDelimiter(",");
				while (scanner.hasNext()) {
					String data = scanner.next();
					if (index == 0)
						coord.setLat(data);
					else if (index == 1)
						coord.setLon(data);
					else
						System.out.println("invalid data::" + data);
					index++;
				}
				index = 0;
				listCoordinate.add(coord);
				//System.out.println("entra");
			}

			// close reader
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

		return listCoordinate;

	}

	public List<Location> getTrendsClosest() {

		String url;
		JSONObject obj;
		String lista="[";
		try {
			for (Coordinata coordinata : TrendsDownload.getCoord()) {
				url="https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/api/1.1/trends/closest.json?lat="
						+ coordinata.getLat().toString() + "&long=" + coordinata.getLon().toString();
				@SuppressWarnings("resource")
				String urlResponse = new Scanner(new URL(url).openStream(),
						"UTF-8").useDelimiter("\\A").next();
				
				obj = (JSONObject) parser.parse(urlResponse.substring(1,(urlResponse.length()-1))); //Non leggo 
				lista+=obj+",";				
			}
			lista=lista.substring(0,lista.length()-1)+"]";
			JSONArray jsonTrends = (JSONArray) parser.parse(lista);
			trendsClosest=new ObjectMapper().readValue(jsonTrends.toString(), new TypeReference<List<Location>>() {});
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return trendsClosest;

	}

	public List<Metadata> getMetadata() {
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
	/*
	 * public List<Location> getTrendsAvailableWithCoordinates() { // TODO
	 * Auto-generated method stub for (Location loc :
	 * TrendsDownload.getTrendsAvailable()) { String jsonString; try { jsonString =
	 * new Scanner( new
	 * URL("https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/geo/"+loc.
	 * getName()).openStream(),"UTF-8").useDelimiter("\\A").next(); JSONObject
	 * jsonCoord = (JSONObject) parser.parse(jsonString); jsonCoord } catch
	 * (Exception e) { // TODO Auto-generated catch block e.printStackTrace(); }
	 * 
	 * }
	 * 
	 * return null; }
	 */
}
