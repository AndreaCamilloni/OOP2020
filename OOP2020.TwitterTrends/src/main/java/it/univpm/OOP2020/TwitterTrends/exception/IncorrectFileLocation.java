package it.univpm.OOP2020.TwitterTrends.exception;

/**
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
