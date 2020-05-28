package it.univpm.OOP2020.TwitterTrends.exception;



public class FilterException extends Exception{
	public FilterException(String e) {
		super(": " + e);
		//new ResponseStatusException(HttpStatus.BAD_REQUEST, "Filtro scritto male");
	}

}
