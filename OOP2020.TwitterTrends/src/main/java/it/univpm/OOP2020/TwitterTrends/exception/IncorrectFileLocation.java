package it.univpm.OOP2020.TwitterTrends.exception;

/**
 * @author Andrea Camilloni
 *
 */

public class IncorrectFileLocation extends Exception {
	public IncorrectFileLocation() {
		System.out.println("location.txt is not correct");
	}

}
