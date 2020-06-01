package it.univpm.OOP2020.TwitterTrends.dbConnection;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.univpm.OOP2020.TwitterTrends.Util.getCoordinates;
import it.univpm.OOP2020.TwitterTrends.Util.urlConnection;
import it.univpm.OOP2020.TwitterTrends.model.Coordinata;
import it.univpm.OOP2020.TwitterTrends.model.Location;
import it.univpm.OOP2020.TwitterTrends.model.Metadata;
import it.univpm.OOP2020.TwitterTrends.model.Stats;

/**
 * This is the main class that allows to establish a connection with the db
 * @author Andrea Camilloni
 *
 */
public class TrendsDownload {
	/**
	 *  trendsAvailable
	 */
	private static List<Location> trendsAvailable;
	/**
	 * trendsClosest
	 */
	private static List<Location> trendsClosest;
	/**
	 * url
	 */
	private String url;
	/**
	 * metadata
	 */
	private static List<Metadata> metadata;

	public TrendsDownload() {

	}
	/**
	 * This method allows to ad get all the locations that Twitter has trending topic information for. 
	 * @return trendsAvailable
	 */
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


	/**
	 * This method returns the locations that Twitter has trending topic information for, 
	 * closest to a specified locations, entered by input file such coordinates
	 * 
	 * @return trendsClosest
	 */
	public List<Location> getTrendsClosest() {
		String urlResponse;
		JSONObject obj;
		String listaAppoggio = "[";
		getCoordinates coordinatesList= new getCoordinates("location.txt");
		try {
			for (Coordinata coordinata : coordinatesList.getCoordinatesRequest()) {
				url = "https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/api/1.1/trends/closest.json?lat="
						+ coordinata.getLat() + "&long=" + coordinata.getLon();
				urlResponse = new urlConnection(url).getJSON();
				obj = (JSONObject) JSONValue.parseWithException(urlResponse.substring(1, (urlResponse.length() - 1)));
				listaAppoggio += obj + ",";

			}
			listaAppoggio = listaAppoggio.substring(0, listaAppoggio.length() - 1) + "]";
			JSONArray jsonTrends = (JSONArray) JSONValue.parseWithException(listaAppoggio);
			trendsClosest = new ObjectMapper().readValue(jsonTrends.toString(), new TypeReference<List<Location>>() {
			});

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return trendsClosest;

	}
	/**
	 * Method that return a list of Metadata of Closest Trends
	 * @return metadata
	 */
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
	/**
	 * getStats() returns a sorted list by CountryCode, of TOP rankings countries 
	 * with multiple locations with trends.
	 * @return
	 */
	public List<Stats> getStats() {
		getTrendsAvailable();
		Iterator<Location> it = trendsAvailable.iterator();
		List<Stats> StatsList = new ArrayList<Stats>();

		int i = 0;

		while (it.hasNext()) {
			Location tmp = it.next();
			if (tmp.getPlaceType().getPlaceTypeName().equals("Country")) {
				Stats stats = new Stats(tmp, i);
				StatsList.add(stats);
			}
		}
		for (Stats var : StatsList) {
			i = 0;
			for (Location trend : trendsAvailable) {
				if (trend.getCountryCode() != null)
					if (trend.getCountryCode().equals(var.getLoc().getCountryCode())) {
						i++;
						var.setCount(i);
					}

			}
			
		}
		Collections.sort(StatsList, new Comparator<Stats>() {

			public int compare(Stats o1, Stats o2) {
				return o1.getCount() > o2.getCount() ? -1 : (o1.getCount() < o2.getCount()) ? 1 : 0;

			}
		});

		return StatsList;

	}

}
