package it.univpm.OOP2020.TwitterTrends.model;

public class LocationWithDistance extends Location {
	private Coordinata place;
	private double distance;

	/**
	 * 
	 */
	public LocationWithDistance(Location l) {
		super(l);
		place.setPlaceName(l.getName());
	}
	public LocationWithDistance() {
		
	}

	/**
	 * @return the place
	 */
	public Coordinata getPlace() {
		return place;
	}

	/**
	 * @param place the place to set
	 */
	public void setPlace(Coordinata place) {
		this.place = place;
	}

	/**
	 * @return the distance
	 */
	public double getDistance() {
		return distance;
	}

	/**
	 * @param distance the distance to set
	 */
	public void setDistance(double distance) {
		this.distance = distance;
	}
	

}
