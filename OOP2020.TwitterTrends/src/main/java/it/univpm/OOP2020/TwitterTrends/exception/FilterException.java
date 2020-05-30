package it.univpm.OOP2020.TwitterTrends.exception;


/**
 * @author Andrea Camilloni
 *
 */


public class FilterException extends Exception{
	public FilterException(String e) {
		super(": " + e);
		//new ResponseStatusException(HttpStatus.BAD_REQUEST, "Filtro scritto male");
	}

}
