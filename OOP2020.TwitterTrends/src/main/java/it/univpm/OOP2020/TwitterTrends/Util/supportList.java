package it.univpm.OOP2020.TwitterTrends.Util;

public class supportList {
	private String countryCode;
	private int count;
	/**
	 * @param countryCode
	 * @param count
	 */
	public supportList(String countryCode, int count) {
		super();
		this.countryCode = countryCode;
		this.count = count;
	}
	
	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}
	/**
	 * @param countryCode the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "listaAppoggio [countryCode=" + countryCode + ", count=" + count + "]";
	}
}
