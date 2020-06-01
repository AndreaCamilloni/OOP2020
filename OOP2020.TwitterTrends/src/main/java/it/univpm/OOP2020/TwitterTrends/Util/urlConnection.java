package it.univpm.OOP2020.TwitterTrends.Util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * This class allows to create a new connection and get a JSON string
 * @author Andrea Camilloni
 *
 */

public class urlConnection  {
	/**
	 * URL
	 */
	private String url;

	/**
	 * Constructor with url parameter
	 * @param url
	 */
	public urlConnection(String url) {
		super();
		this.url = url;
	}
	/**
	 * Method that establishes the connection to a url and returns a json string
	 * @return
	 */
	@SuppressWarnings("resource")
	public String getJSON(){
		String jSONString=null; 
		try {
			jSONString= new Scanner(new URL(url).openStream(),
					"UTF-8").useDelimiter("\\A").next();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jSONString;
		
	}
	
}
