/**
 * 
 */
package it.univpm.OOP2020.TwitterTrends.model;

/**
 * @author Andrea Camilloni
 *
 */
public class Coordinata {
	private double lat;
	private double lon;
	
	public Coordinata() {
		
	}


	/**
	 * @return the lat
	 */
	public double getLat() {
		return lat;
	}


	/**
	 * @param lat the lat to set
	 */
	public void setLat(double lat) {
		this.lat = lat;
	}


	/**
	 * @return the lon
	 */
	public double getLon() {
		return lon;
	}


	/**
	 * @param lon the lon to set
	 */
	public void setLon(double lon) {
		this.lon = lon;
	}

	@Override
	public String toString() {
		return "Coordinata [lat=" + lat + ", lon=" + lon + "]";
	}

}
