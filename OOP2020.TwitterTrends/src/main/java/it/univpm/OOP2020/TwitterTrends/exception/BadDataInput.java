package it.univpm.OOP2020.TwitterTrends.exception;

/**
 * Exception for wrong file "locatio.txt" or input
 * @author Andrea Camilloni
 *
 */
public class BadDataInput extends Exception {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of BadDataInput
	 * @param message to show
	 */
	public BadDataInput(String message) {
		super(message);
		System.out.print("Bad Data Input");
	}

}
