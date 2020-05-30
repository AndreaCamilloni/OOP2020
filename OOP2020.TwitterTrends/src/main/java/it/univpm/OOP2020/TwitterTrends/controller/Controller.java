package it.univpm.OOP2020.TwitterTrends.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import it.univpm.OOP2020.TwitterTrends.service.Service;
import it.univpm.OOP2020.TwitterTrends.service.ServiceImplementation;



/**
 * @author Andrea Camilloni
 *
 */
@RestController
public class Controller {
	/**
	 * 
	 */
	@Autowired
	private Service data=new ServiceImplementation();
	

	/**
	 * @return
	 */
	@GetMapping("/Metadata")
	public ResponseEntity<Object> getMeta(){
		return new ResponseEntity<>(data.MetadataList(),HttpStatus.OK); 
	}
	
	
	/**
	 * @return
	 */
	@GetMapping("/Data")
	public ResponseEntity<Object> getData(){
		return new ResponseEntity<>(data.DataList(),HttpStatus.OK); 
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

	
	//Metodi aggiuntivi utili per lo studio generale dei TwitterTrends
	/**
	 * GET /TrendsAvailable 
	 * @return list of Twitter trends available for location
	 */
	@GetMapping("/TrendsAvailable")
	public  ResponseEntity<Object> TrendsAvailable(){
		//utilizzo tale metodo per scaricare una lista completa delle location 
		//per cui twitter dispone di trend per fini prossimi allo studio che vado 
		//a fare poi con TrendClosest(obiettivo del progetto)
		return new ResponseEntity<>(data.TrendsAvailable(),HttpStatus.OK); 
	}
	/**
	 * GET /TrendsAvailableSorted 
	 * @return list of Twitter trends available for location
	 */
	@GetMapping("/SortedTrendsAvailable")
	public  ResponseEntity<Object> SortedTrendsAvailable(){

		return new ResponseEntity<>(data.SortedTrendsAvailable(),HttpStatus.OK); 
	}
	
}
