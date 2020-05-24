package model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Andrea Camilloni
 *
 */

public class TrendModel {

	private String name;
	private PlaceType placeType;
	private String url;
	private Integer parentid;
	private String country;
	private Integer woeid;
	private String countryCode;
	
	/**
	 * Costruttore
	 */
	public TrendModel() {
		super();
		// TODO Auto-generated constructor stub
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
	
	
}
