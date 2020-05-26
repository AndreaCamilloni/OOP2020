package it.univpm.OOP2020.TwitterTrends.dbConnection;

import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.univpm.OOP2020.TwitterTrends.model.Metadata;
import it.univpm.OOP2020.TwitterTrends.model.TrendModel;

public class TrendsDownload {
	// private String url;
	private static List<TrendModel> trendsAvailable;
	private static List<TrendModel> trendsClosest;
	private static List<Metadata> metadata=new JSONArray() ;
	//private static TrendModel trends ;
	

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

	public List<TrendModel> getTrendsAvailable() {
		JSONParser parser = new JSONParser();
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

			trendsAvailable = new ObjectMapper().readValue(jsonList.toString(), new TypeReference<List<TrendModel>>() {
			});

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return trendsAvailable;

	}

	public static List<Metadata> getMetadata() {
		metadata.add(new Metadata("name", "name", "String"));
		metadata.add(new Metadata("PlaceType", "placeType", "Object"));
		metadata.add(new Metadata("url", "url", "String"));
		metadata.add(new Metadata("parentid", "parentid", "Integer"));
		metadata.add(new Metadata("country", "country", "String"));
		metadata.add(new Metadata("woeid", "woeid", "Integer"));
		metadata.add(new Metadata("countryCode", "countryCode", "String"));

		return metadata;
	}

	public static List<TrendModel> getTrendsClosest(double latTrend,double longTrend) {
		JSONParser parser = new JSONParser();
		
		try {
			// URLConnection urlConnection = new
			// URL("https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/api/1.1/trends/closest.json?lat=43.508321&long=13.376535").openConnection();
			@SuppressWarnings("resource")
			String jsonString = new Scanner(
					new URL("https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/api/1.1/trends/closest.json?lat="+
			latTrend + "&long="+longTrend).openStream(),"UTF-8").useDelimiter("\\A").next();

			JSONArray jsonTrends = (JSONArray) parser.parse(jsonString);
			// System.out.print(jsonOB);

			trendsClosest =  new ObjectMapper().readValue(jsonTrends.toString(), new TypeReference<List<TrendModel>>() {
			});

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return trendsClosest;

	}
}
