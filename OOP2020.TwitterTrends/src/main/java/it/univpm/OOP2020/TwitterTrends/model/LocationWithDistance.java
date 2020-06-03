package it.univpm.OOP2020.TwitterTrends.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LocationWithDistance extends Location {
	/**
	 * 
	 */
	@JsonProperty("Coordinates")
	private Coordinata place;
	/**
	 * 
	 */
	@JsonProperty("Distance[Km]")
	private double distance;

	/**
	 * Constructor 
	 * @param l
	 */
	public LocationWithDistance(Location l) {
		super(l);
		place=new Coordinata();
		place.setPlaceName(l.getName());
	}
	/**
	 * Constructor 
	 */
	public LocationWithDistance() {
		
	}

	/**
	 * @return the place
	 */
	@JsonProperty("Coordinates")
	public Coordinata getPlace() {
		return place;
	}

	/**
	 * @param place the place to set
	 */
	@JsonProperty("Coordinates")
	public void setPlace(Coordinata place) {
		this.place = place;
	}

	/**
	 * @return the distance
	 */
	@JsonProperty("Distance[Km]")
	public double getDistance() {
		return distance;
	}

	/**
	 * @param distance the distance to set
	 */
	@JsonProperty("Distance[Km]")
	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	

}
