package it.univpm.OOP2020.TwitterTrends.model;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * This class describe a single Location returned by a request to the database(Twitter) with distance from a specified place
 * @author Andrea Camilloni
 *
 */
public class LocationWithDistance extends Location {
	/**
	 * Coordinate
	 */
	@JsonProperty("Coordinates")
	private Coordinata place;
	/**
	 * Distance from a place
	 */
	@JsonProperty("Distance[Km]")
	private double distance;

	/**
	 * Constructor 
	 * @param l location
	 */
	public LocationWithDistance(Location l) {
		super(l);
		place=new Coordinata();
		place.setPlaceName(l.getName());
	}

	/**
	 * Returns Coordinate
	 * @return the place
	 */
	@JsonProperty("Coordinates")
	public Coordinata getPlace() {
		return place;
	}

	/**
	 * Set coordinate
	 * @param place the place to set
	 */
	@JsonProperty("Coordinates")
	public void setPlace(Coordinata place) {
		this.place = place;
	}

	/**
	 * Returns the distance from a place
	 * @return the distance
	 */
	@JsonProperty("Distance[Km]")
	public double getDistance() {
		return distance;
	}

	/**
	 * Set the distance
	 * @param distance the distance to set
	 */
	@JsonProperty("Distance[Km]")
	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	

}
