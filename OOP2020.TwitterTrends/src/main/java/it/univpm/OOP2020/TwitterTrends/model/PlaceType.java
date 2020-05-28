package it.univpm.OOP2020.TwitterTrends.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Andrea Camilloni
 *
 */

public class PlaceType {


	@JsonProperty("code")
	private Integer placeTypeCode;
	@JsonProperty("name")
	private String placeTypeName;
	/**
	 * 
	 */
	public PlaceType() {
		super();
		// TODO Auto-generated constructor stub
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
