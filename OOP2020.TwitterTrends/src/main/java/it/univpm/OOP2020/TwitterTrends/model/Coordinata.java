/**
 * 
 */
package it.univpm.OOP2020.TwitterTrends.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

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
	@JsonProperty("latitude")
	private double lat;
	/**
	 * longitude
	 */
	@JsonProperty("longitude")
	private double lon;

	/**
	 * place name
	 */
	@JsonIgnore
	private String placeName;
	/**
	 * Construct of coordinata
	 */
	public Coordinata() {

	}
	
	/**
	 * Construct of coordinata
	 * @param placeName name of place
	 */
	public Coordinata(String placeName) {
		super();
		this.placeName = placeName;
	}


	/**
	 * This method return the latitude
	 * 
	 * @return the latitude
	 */
	@JsonProperty("latitude")
	public double getLat() {
		return lat;
	}

	/**
	 * This method is to set latitude
	 * 
	 * @param lat the latitude to set
	 */
	@JsonProperty("latitude")
	public void setLat(double lat) {
		this.lat = lat;
	}

	/**
	 * This method return the longitude
	 * 
	 * @return the longitude
	 */
	@JsonProperty("longitude")
	public double getLon() {
		return lon;
	}

	/**
	 * This method is to set the longitude
	 * 
	 * @param lon the longitude to set
	 */
	@JsonProperty("longitude")
	public void setLon(double lon) {
		this.lon = lon;
	}

	/**
	 * Returns the place name
	 * @return the placeName
	 */
	@JsonIgnore
	public String getPlaceName() {
		return placeName;
	}

	/** Set the place name
	 * @param placeName the placeName to set
	 */
	@JsonIgnore
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	@Override
	public String toString() {
		return "Coordinata [latitude=" + lat + ", longitude=" + lon + ", place name=" + placeName + "]";
	}

	

}
