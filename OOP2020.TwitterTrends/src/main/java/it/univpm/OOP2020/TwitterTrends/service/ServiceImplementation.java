/**
 * 
 */
package it.univpm.OOP2020.TwitterTrends.service;

import java.util.List;

import it.univpm.OOP2020.TwitterTrends.Util.supportList;
import it.univpm.OOP2020.TwitterTrends.dbConnection.TrendsDownload;
import it.univpm.OOP2020.TwitterTrends.exception.FilterException;
import it.univpm.OOP2020.TwitterTrends.model.Location;
import it.univpm.OOP2020.TwitterTrends.model.Metadata;

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
	public List<Location> DataList(String filterToRecognize) throws FilterException {
		return null;
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
	public List<supportList> SortedTrendsAvailable() {
		// TODO Auto-generated method stub
		return db.getProva();
	}
	

}
