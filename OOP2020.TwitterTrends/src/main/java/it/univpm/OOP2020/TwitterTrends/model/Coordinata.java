/**
 * 
 */
package it.univpm.OOP2020.TwitterTrends.model;

/**
 * @author Andrea Camilloni
 *
 */
public class Coordinata {
	private String lat;
	private String lon;
	
	public Coordinata() {
		
	}


	/**
	 * @return the lat
	 */
	public String getLat() {
		return lat;
	}


	/**
	 * @param lat the lat to set
	 */
	public void setLat(String lat) {
		this.lat = lat;
	}


	/**
	 * @return the lon
	 */
	public String getLon() {
		return lon;
	}


	/**
	 * @param lon the lon to set
	 */
	public void setLon(String lon) {
		this.lon = lon;
	}


	


	@Override
	public String toString() {
		return "Coordinata [lat=" + lat + ", lon=" + lon + "]";
	}

}
