package it.univpm.OOP2020.TwitterTrends.Util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * @author Andrea Camilloni
 *
 */

public class urlConnection  {
	private String url;

	/**
	 * @param url
	 */
	public urlConnection(String url) {
		super();
		this.url = url;
	}
	@SuppressWarnings("resource")
	public String getJSON(){
		String jSOString=null; 
		try {
			jSOString= new Scanner(new URL(url).openStream(),
					"UTF-8").useDelimiter("\\A").next();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jSOString;
		
	}
	
}
