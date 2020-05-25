package it.univpm.OOP2020.TwitterTrends.dbConnection;

import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.univpm.OOP2020.TwitterTrends.model.Metadata;
import it.univpm.OOP2020.TwitterTrends.model.TrendModel;

public class TrendsDownload {
	//private String url;
	List<TrendModel> trendsAvailable;
	
	public TrendsDownload() {

	}


	/*public String[] TrendsCloset() {
		JSONParser parser = new JSONParser();
		try {
			// URLConnection urlConnection = new
			// URL("https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/api/1.1/trends/closest.json?lat=43.508321&long=13.376535").openConnection();
			String jsonString = new Scanner(new URL(
					"https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/api/1.1/trends/closest.json?lat=43.508321&long=13.376535")
							.openStream(),
					"UTF-8").useDelimiter("\\A").next();

			JSONArray jsonOB = (JSONArray) parser.parse(jsonString);
			System.out.print(jsonOB);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}*/

	public List<TrendModel> getTrendsAvailable() {
		JSONParser parser = new JSONParser();
		try {
			// URLConnection urlConnection = new
			// URL("https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/api/1.1/trends/closest.json?lat=43.508321&long=13.376535").openConnection();
			String jsonString = new Scanner(
					new URL("https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/api/1.1/trends/available.json")
							.openStream(),
					"UTF-8").useDelimiter("\\A").next();

			JSONArray jsonList = (JSONArray) parser.parse(jsonString);
			// System.out.print(jsonOB);

			ObjectMapper mapper = new ObjectMapper();
			trendsAvailable = new ObjectMapper().readValue(jsonList.toString(),
					new TypeReference<List<TrendModel>>() {
					});
			for (TrendModel trends : trendsAvailable) {
				System.out.println(trends);

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return trendsAvailable;

	}

}