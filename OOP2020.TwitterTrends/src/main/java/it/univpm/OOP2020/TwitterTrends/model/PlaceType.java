package it.univpm.OOP2020.TwitterTrends.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class belongs to a Location returns by a db request
 * 
 * @author Andrea Camilloni
 *
 */

public class PlaceType {

	/**
	 * Place Code
	 */
	@JsonProperty("code")
	private int placeTypeCode;
	/**
	 * Place name
	 */
	@JsonProperty("name")
	private String placeTypeName;

	/**
	 * Constructor
	 */
	public PlaceType() {
		super();
	}
	
	/**
	 * @param code the code of a location
	 * @param name the name type of a location
	 */
	public PlaceType(int code, String name) {
		// TODO Auto-generated constructor stub
		this.placeTypeCode=code;
		this.placeTypeName=name;
	}

	/**
	 * Returns the code
	 * @return the placeTypeCode
	 */
	@JsonProperty("code")
	public Integer getPlaceTypeCode() {
		return placeTypeCode;
	}

	/**
	 * Set the code
	 * @param placeTypeCode the placeTypeCode to set
	 */
	@JsonProperty("code")
	public void setPlaceTypeCode(Integer placeTypeCode) {
		this.placeTypeCode = placeTypeCode;
	}

	/**
	 * Returns the name
	 * @return the placeTypeName
	 */
	@JsonProperty("name")
	public String getPlaceTypeName() {
		return placeTypeName;
	}

	/**
	 * Set the name
	 * @param placeTypeName the placeTypeName to set
	 */
	@JsonProperty("name")
	public void setPlaceTypeName(String placeTypeName) {
		this.placeTypeName = placeTypeName;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "PlaceType [code=" + placeTypeCode + ", name=" + placeTypeName + "]";
	}

}
