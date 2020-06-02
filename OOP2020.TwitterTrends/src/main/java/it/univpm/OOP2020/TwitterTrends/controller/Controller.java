package it.univpm.OOP2020.TwitterTrends.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.OOP2020.TwitterTrends.exception.BadDataInput;
import it.univpm.OOP2020.TwitterTrends.service.Service;
import it.univpm.OOP2020.TwitterTrends.service.ServiceImplementation;



/**
 * Controller class manages all separate routes through REST GET API request
 * @author Andrea Camilloni
 *
 */
@RestController
public class Controller {
	/**
	 *  Web service initialization
	 */
	@Autowired
	private Service data=new ServiceImplementation();
	

	/**
	 * This route return a list of Metadata of Closest Trends
	 * @return list of Metadata
	 */
	@GetMapping("/Metadata")
	public ResponseEntity<Object> getMeta(){
		return new ResponseEntity<>(data.MetadataList(),HttpStatus.OK); 
	}
	
	
	/**
	 * This route returns the locations that Twitter has trending topic information for, 
	 * closest to a specified locations, entered by input file.
	 * @return list of Data
	 * @throws BadDataInput 
	 */
	@GetMapping("/Data")
	public ResponseEntity<Object> getData(){
		return new ResponseEntity<>(data.DataList(),HttpStatus.OK); 
	}

	@GetMapping("/Dataa")
	public ResponseEntity<Object> getData(@RequestParam(required = false, name= "place") String placeName) throws BadDataInput{
		return new ResponseEntity<>(data.DataList(placeName),HttpStatus.OK); 
	}

	/**
	 * @param latTrend
	 * @param longTrend
	 * @return
	 */
	@GetMapping("/DataFromInput")
	public  ResponseEntity<Object> getData(@RequestParam(required = true,name = "lat") String latTrend,
			@RequestParam(required = true,name = "long")  String longTrend){
		return new ResponseEntity<>(data.DataList(latTrend,longTrend),HttpStatus.OK); 

	}

	

	/**
	 * This route returns the locations that Twitter has trending topic information for.
	 * @return list of Twitter trends available for location
	 */
	@GetMapping("/TrendsAvailable")
	public  ResponseEntity<Object> TrendsAvailable(){

		return new ResponseEntity<>(data.TrendsAvailable(),HttpStatus.OK); 
	}
	/**
	 * This route returns a sorted list by CountryCode, of TOP rankings countries 
	 * with multiple locations with trends.
	 * @return list of Stats
	 */
	@GetMapping("/Stats")
	public  ResponseEntity<Object> Stats(){

		return new ResponseEntity<>(data.Stats(),HttpStatus.OK); 
	}
	
}
