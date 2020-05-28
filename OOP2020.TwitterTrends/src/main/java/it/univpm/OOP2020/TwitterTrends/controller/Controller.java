package it.univpm.OOP2020.TwitterTrends.controller;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import it.univpm.OOP2020.TwitterTrends.dbConnection.TrendsDownload;
import it.univpm.OOP2020.TwitterTrends.model.Location;
import it.univpm.OOP2020.TwitterTrends.model.Metadata;
import it.univpm.OOP2020.TwitterTrends.service.Service;
import it.univpm.OOP2020.TwitterTrends.service.ServiceImplementation;



@RestController
public class Controller {
	private Service db=new ServiceImplementation();
	
	@GetMapping("/Metadata")
	public List<Metadata> getMeta(){
		return db.MetadataList(); 
	}
	@GetMapping("/GetData")
	public List<Location> getData(){
		return db.DataList(); 
	}

	/*@GetMapping("/GetData")
	public List<Location> getData(@RequestParam(required = false,name = "lat", defaultValue = "13") double latTrend,
			@RequestParam(required = false,name = "long",defaultValue = "43")  double longTrend){
		return db.DataList(latTrend,longTrend); 
	}
*/
	
	//Metodi aggiuntivi utili per lo studio generale dei TwitterTrends
	/**
	 * GET /TrendsAvailable 
	 * @return list of Twitter trends available for location
	 */
	@GetMapping("/TrendsAvailable")
	public List<Location> TrendsAvailable(){
		//utilizzo tale metodo per scaricare una lista completa delle location 
		//per cui twitter dispone di trend per fini prossimi allo studio che vado 
		//a fare poi con TrendClosest(obiettivo del progetto)
		return new TrendsDownload().getTrendsAvailable(); 
	}
	/*
	@GetMapping("/TrendsAvailableWithCoordinates")
	public List<Location> TrendsAvailableWithCoordinates(){

		return new TrendsDownload().getTrendsAvailableWithCoordinates(); 
	}*/
}
