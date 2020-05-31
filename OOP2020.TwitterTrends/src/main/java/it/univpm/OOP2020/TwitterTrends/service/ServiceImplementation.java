/**
 * 
 */
package it.univpm.OOP2020.TwitterTrends.service;

import java.util.List;

import it.univpm.OOP2020.TwitterTrends.dbConnection.TrendsDownload;
import it.univpm.OOP2020.TwitterTrends.model.Location;
import it.univpm.OOP2020.TwitterTrends.model.Metadata;
import it.univpm.OOP2020.TwitterTrends.model.Stats;

/**
 * @author Andrea Camilloni
 *
 */
@org.springframework.stereotype.Service
public class ServiceImplementation implements Service {

private TrendsDownload db=new TrendsDownload();
	
	@Override
	public List<Metadata> MetadataList() {
		
		return db.getMetadata();
	}
	@Override
	public List<Location> DataList() {
		
		return db.getTrendsClosest();
	}

	@Override
	
	public List<Location> TrendsAvailable() {
		
		return db.getTrendsAvailable();
	}
	@Override
	public List<Location> DataList(String latData, String longData) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Stats> Stats() {
		// TODO Auto-generated method stub
		return db.getStats();
	}
	

}
