/**
 * 
 */
package it.univpm.OOP2020.TwitterTrends.service;

import java.util.List;

import it.univpm.OOP2020.TwitterTrends.dbConnection.TrendsDownload;
import it.univpm.OOP2020.TwitterTrends.exception.BadDataInput;
import it.univpm.OOP2020.TwitterTrends.model.Location;
import it.univpm.OOP2020.TwitterTrends.model.LocationWithDistance;
import it.univpm.OOP2020.TwitterTrends.model.Metadata;
import it.univpm.OOP2020.TwitterTrends.model.Stats;

/**
 * Service for implementation of main requests
 * @author Andrea Camilloni
 *
 */
@org.springframework.stereotype.Service
public class ServiceImplementation implements Service {

	/**
	 * initialization of Database Connection
	 */
	private TrendsDownload db = new TrendsDownload();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Metadata> MetadataList() {

		return db.getMetadata();
	}
	
	/**
	 *{@inheritDoc}
	 */
	@Override
	public List<Location> DataList() {

		return db.getTrendsClosest();
	}

	/**
	 *{@inheritDoc}
	 */
	@Override
	public List<Location> TrendsAvailable() {

		return db.getTrendsAvailable();
	}


	/**
	 *{@inheritDoc}
	 * @throws BadDataInput show an error for wrong input
	 */
	@Override
	public List<LocationWithDistance> DataList(String placeName) throws BadDataInput {
		return db.getTrendsClosestWithDistance(placeName);
	}

	/**
	 *{@inheritDoc}
	 */
	@Override
	public List<Stats> Stats() {
		// TODO Auto-generated method stub
		return db.getStats();
	}

}
