package it.univpm.OOP2020.TwitterTrends.model;

/**
 * This class describe a single Location returned by a request to the database(Twitter)
 * @author Andrea Camilloni
 *
 */

public class Location {

	/**
	 * Name of the Location
	 */
	private String name;
	/**
	 * Type of Location
	 */
	private PlaceType placeType;
	/**
	 *  url to yahooapis.com of Location(nowadays is deprecated)
	 */
	private String url;
	/**
	 * id of Location's country
	 */
	private Integer parentid;
	/**
	 *  Country' name
	 */
	private String country;
	/**
	 * id Where On Earth!(nowadays is deprecated)
	 */
	private Integer woeid;
	/**
	 * Country code
	 */
	private String countryCode;
	
	/**
	 * constructor
	 */
	public Location() {
		super();
	}
	/**
	 * Constructor 
	 * @param l location
	 */
	public Location(Location l) {
		this.name=l.getName();
		this.placeType=l.getPlaceType();
		this.url=l.getUrl();
		this.parentid=l.getParentid();
		this.country=l.getCountry();
		this.woeid=l.getWoeid();
		this.countryCode=l.getCountryCode();
	}

	/**
	 * Returns the name
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Set the name
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Returns the placetype
	 * @return the placeType
	 */
	public PlaceType getPlaceType() {
		return placeType;
	}
	/**
	 * Set the placetype
	 * @param placeType the placeType to set
	 */
	public void setPlaceType(PlaceType placeType) {
		this.placeType = placeType;
	}
	/**
	 * Returns the url
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * Set the url
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * Returns the parentid
	 * @return the parentid
	 */
	public Integer getParentid() {
		return parentid;
	}
	/**
	 * Set the parentif
	 * @param parentid the parentid to set
	 */
	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}
	/**
	 * Returns the country name
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * Set the country name
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * Returns the WhereOnEarthID
	 * @return the woeid
	 */
	public Integer getWoeid() {
		return woeid;
	}
	/**
	 * Set the WhereOnEarthID
	 * @param woeid the woeid to set
	 */
	public void setWoeid(Integer woeid) {
		this.woeid = woeid;
	}
	/**
	 * Returns the country code
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}
	/**
	 * Set the country code
	 * @param countryCode the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	@Override
	public String toString() {
		return "Location [name=" + name + ", placeType=" + placeType + ", url=" + url + ", parentid=" + parentid
				+ ", country=" + country + ", woeid=" + woeid + ", countryCode=" + countryCode + "]";
	}
	
}
