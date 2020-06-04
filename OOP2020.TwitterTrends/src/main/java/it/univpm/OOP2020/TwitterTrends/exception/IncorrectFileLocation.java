package it.univpm.OOP2020.TwitterTrends.exception;

/**
 * This exception is called by a method not implemented.
 * It describes exception in input file such as:
 * -Wrong data
 * -Too many input for line
 * @author Andrea Camilloni
 *
 */

public class IncorrectFileLocation extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IncorrectFileLocation(String data) {
		super("location.txt is not correct! This value:" 
	           + data
	           + " is not correct for coordinates."
	           + "Try a value between -180 and 180");
	}

	public IncorrectFileLocation() {
		super("location.txt is not correct: number of input may be 2 for line -> lat,long");
	}

}
