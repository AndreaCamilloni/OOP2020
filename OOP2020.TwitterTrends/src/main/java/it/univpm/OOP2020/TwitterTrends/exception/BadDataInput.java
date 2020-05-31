package it.univpm.OOP2020.TwitterTrends.exception;

/**
 * @author Andrea Camilloni
 *
 */
public class BadDataInput extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BadDataInput() {
	}

	public BadDataInput(String message) {
		super(message);
		System.out.print("Bad Data Input");
	}

}
