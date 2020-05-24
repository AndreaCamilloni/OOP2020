package dbConnection;

import java.net.URL;
import java.net.URLConnection;

public class TrendsDownload {
	private String url;

	public TrendsDownload() {

	}

	public String[] TrendsCloset() {
		url = "https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/api/1.1/trends/closest.json?lat=43.508321&long=13.376535";
		try {
			URLConnection urlConnection = new URL(url).openConnection();
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public String[] TrendsAvailable() {
		

	}

}
