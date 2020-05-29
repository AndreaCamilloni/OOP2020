package it.univpm.OOP2020.TwitterTrends.service;

import java.util.List;

import it.univpm.OOP2020.TwitterTrends.Util.supportList;
import it.univpm.OOP2020.TwitterTrends.exception.FilterException;
import it.univpm.OOP2020.TwitterTrends.model.Location;
import it.univpm.OOP2020.TwitterTrends.model.Metadata;

@org.springframework.stereotype.Service
public interface Service {
	/**
	 * Description of the method MetadataList.
	 */
	public abstract List<Metadata> MetadataList();

	/**
	 * Description of the method DataList.
	 */
	public abstract List<Location> DataList();
	public abstract List<Location> DataList(String latData, String longData);
	public abstract List<Location> DataList(String filterToRecognize)throws FilterException;


	/**
	 * Description of the method TrendsAvailable.
	 */
	public abstract List<Location> TrendsAvailable();
	public abstract List<supportList> SortedTrendsAvailable();
	

}
