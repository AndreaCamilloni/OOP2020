/**
 * 
 */
package it.univpm.OOP2020.TwitterTrends.model;



/**
 * This class describes a single Stat for a Country 
 *  
 * @author Andrea Camilloni
 *
 */
public class Stats extends Location  {

	/**
	 * trend count by country
	 */
	private int count;
	
	/**
	 * Town of the relative country, with trend 
	 */
	private String[] town;
	
	/**
	 * Constructor
	 * @param loc to pass to superclass
	 * @param c count of trend for country
	 */
	public Stats(Location loc,int c) {
		super(loc);
		this.count=c;
	}
	/**
	 * It sets the count of Trend for country
	 * @param i count
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
	/**
	 * Returns array of available town with trends
	 * @return the town
	 */
	public String[] getTown() {
		return town;
	}
	/**
	 * Set an array of available town with trends
	 * @param town the town to set
	 */
	public void setTown(String[] town) {
		this.town = town;
	}

	@Override
	public String toString() {
		return "Stats [count=" + count + ", getName()=" + getName() + ", getPlaceType()=" + getPlaceType()
				+ ", getUrl()=" + getUrl() + ", getParentid()=" + getParentid() + ", getCountry()=" + getCountry()
				+ ", getWoeid()=" + getWoeid() + ", getCountryCode()=" + getCountryCode() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

	
}
