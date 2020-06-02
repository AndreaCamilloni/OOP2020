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
		// TODO Auto-generated constructor stub
	}
	
	public Location(Location l) {
		this.name=l.getName();
		//this.placeType=new PlaceType(l.getPlaceType().getPlaceTypeCode(),l.getPlaceType().getPlaceTypeName());
		this.url=l.getUrl();
		this.parentid=l.getParentid();
		this.country=l.getCountry();
		this.woeid=l.getWoeid();
		this.countryCode=l.getCountryCode();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the placeType
	 */
	public PlaceType getPlaceType() {
		return placeType;
	}
	/**
	 * @param placeType the placeType to set
	 */
	public void setPlaceType(PlaceType placeType) {
		this.placeType = placeType;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the parentid
	 */
	public Integer getParentid() {
		return parentid;
	}
	/**
	 * @param parentid the parentid to set
	 */
	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the woeid
	 */
	public Integer getWoeid() {
		return woeid;
	}
	/**
	 * @param woeid the woeid to set
	 */
	public void setWoeid(Integer woeid) {
		this.woeid = woeid;
	}
	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}
	/**
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
