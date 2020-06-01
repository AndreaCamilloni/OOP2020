/**
 * 
 */
package it.univpm.OOP2020.TwitterTrends.model;

/**
 * This class describes the coordinates of a location that can be added by input
 * 
 * @author Andrea Camilloni
 *
 */
public class Coordinata {
	/**
	 * latitude
	 */
	private double lat;
	/**
	 * longitude
	 */
	private double lon;

	/**
	 * place name
	 */
	private String placeName;
	
	public Coordinata() {

	}

	
	/**
	 * @param placeName
	 */
	public Coordinata(String placeName) {
		super();
		this.placeName = placeName;
	}


	/**
	 * This method return the latitude
	 * 
	 * @return the lat
	 */
	public double getLat() {
		return lat;
	}

	/**
	 * This method is to set di latitude
	 * 
	 * @param lat the lat to set
	 */
	public void setLat(double lat) {
		this.lat = lat;
	}

	/**
	 * This method return the longitude
	 * 
	 * @return the lon
	 */
	public double getLon() {
		return lon;
	}

	/**
	 * This method is to set the longitude
	 * 
	 * @param lon the lon to set
	 */
	public void setLon(double lon) {
		this.lon = lon;
	}

	/**
	 * @return the placeName
	 */
	public String getPlaceName() {
		return placeName;
	}

	/**
	 * @param placeName the placeName to set
	 */
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	@Override
	public String toString() {
		return "Coordinata [latitude=" + lat + ", longitude=" + lon + ", place name=" + placeName + "]";
	}

	

}
