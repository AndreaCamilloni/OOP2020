package it.univpm.OOP2020.TwitterTrends.controller;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import it.univpm.OOP2020.TwitterTrends.dbConnection.TrendsDownload;
import it.univpm.OOP2020.TwitterTrends.model.Metadata;
import it.univpm.OOP2020.TwitterTrends.model.TrendModel;


@RestController
public class Controller {
	
	
	@GetMapping("/Metadata")
	public List<Metadata> getMetadata(){
		return TrendsDownload.getMetadata(); 
	}

	/**
	 * GET /TrendsAvailable 
	 * @return Lista delle Location per cui Twitter dispone dei Trend
	 */
	@GetMapping("/TrendsAvailable")
	public List<TrendModel> TrendsAvailable(){
		
		return new TrendsDownload().getTrendsAvailable(); 
	}
	
}
