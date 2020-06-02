package it.univpm.OOP2020.TwitterTrends.service;

import java.util.List;

import it.univpm.OOP2020.TwitterTrends.exception.BadDataInput;

/**
 * Service for implementation of main requests
 * @author Andrea Camilloni 
 *
 */


import it.univpm.OOP2020.TwitterTrends.model.Location;
import it.univpm.OOP2020.TwitterTrends.model.LocationWithDistance;
import it.univpm.OOP2020.TwitterTrends.model.Metadata;
import it.univpm.OOP2020.TwitterTrends.model.Stats;

@org.springframework.stereotype.Service
public interface Service {
	/**
	 * MedadataList() returns a list of Metadata which describes 
	 * attributes and types of Location
	 * @return List of Metadata
	 */
	public abstract List<Metadata> MetadataList();

	/**
	 * DataList() return a List of all the Location
	 * that Twitter has trending topic information for,
	 * closest to a specified locations, entered by input file.
	 * @return List of Location 
	 */
	public abstract List<Location> DataList();
	public abstract List<LocationWithDistance> DataList(String placeName) throws BadDataInput;
	public abstract List<Location> DataList(String latData, String longData);
	

	/**
	 * TrendsAvailable() return a List of all the Location
	 * that Twitter has trending topic information for.
	 * @return List of Location 
	 */
	public abstract List<Location> TrendsAvailable();
	/**
	 * Stats() a sorted list by CountryCode, of TOP rankings countries 
	 * with multiple locations with trends.
	 * @return List of Stats 
	 */
	public abstract List<Stats> Stats();
	

}
