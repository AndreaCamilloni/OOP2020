/**
 * 
 */
package it.univpm.OOP2020.TwitterTrends.model;



/**
 * This class
 * @author Andrea Camilloni
 *
 */
public class Stats extends Location  {

	/**
	 * trend count by country
	 */
	private int count;
	/**
	 * location
	 */
	private Location loc;

	/**
	 * Constructor
	 */
	public Stats(Location loc,int c) {
		this.loc=loc;
		this.count=c;
	}
	/**
	 * It sets the count of Trend for country
	 * @param i
	 */
	public void setCount(int i) {
		// TODO Auto-generated method stub
		this.count=i;
	}
	/**
	 * It returs the count of Trend for country
	 * @return the count of Trend for country
	 */
	public int getCount() {
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public String toString() {
		return "Stats [count=" + count + ", loc=" + loc + "]";
	}
	/**
	 * 
	 * @return
	 */
	public Location getLoc() {
		// TODO Auto-generated method stub
		return loc;
	}

	
}
