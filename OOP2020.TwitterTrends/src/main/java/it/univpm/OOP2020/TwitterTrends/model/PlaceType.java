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
	private Integer placeTypeCode;
	/**
	 * Place name
	 */
	@JsonProperty("name")
	private String placeTypeName;

	/**
	 * 
	 */
	public PlaceType() {
		super();
	}

	public PlaceType(Integer placeTypeCode2, String placeTypeName2) {
		// TODO Auto-generated constructor stub
		this.placeTypeCode=placeTypeCode2;
		this.placeTypeName=placeTypeName2;
	}

	/**
	 * @return the placeTypeCode
	 */
	@JsonProperty("code")
	public Integer getPlaceTypeCode() {
		return placeTypeCode;
	}

	/**
	 * @param placeTypeCode the placeTypeCode to set
	 */
	@JsonProperty("code")
	public void setPlaceTypeCode(Integer placeTypeCode) {
		this.placeTypeCode = placeTypeCode;
	}

	/**
	 * @return the placeTypeName
	 */
	@JsonProperty("name")
	public String getPlaceTypeName() {
		return placeTypeName;
	}

	/**
	 * @param placeTypeName the placeTypeName to set
	 */
	@JsonProperty("name")
	public void setPlaceTypeName(String placeTypeName) {
		this.placeTypeName = placeTypeName;
	}

	@Override
	public String toString() {
		return "PlaceType [code=" + placeTypeCode + ", name=" + placeTypeName + "]";
	}

}
