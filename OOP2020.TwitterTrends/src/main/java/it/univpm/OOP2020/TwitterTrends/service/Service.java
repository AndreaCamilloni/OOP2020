package it.univpm.OOP2020.TwitterTrends.service;

import java.util.List;


import it.univpm.OOP2020.TwitterTrends.model.Location;
import it.univpm.OOP2020.TwitterTrends.model.Metadata;
import it.univpm.OOP2020.TwitterTrends.model.Stats;

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
	

	/**
	 * Description of the method TrendsAvailable.
	 */
	public abstract List<Location> TrendsAvailable();
	public abstract List<Stats> Stats();
	

}
