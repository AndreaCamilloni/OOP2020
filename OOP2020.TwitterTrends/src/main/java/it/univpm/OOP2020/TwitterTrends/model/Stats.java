/**
 * 
 */
package it.univpm.OOP2020.TwitterTrends.model;



/**
 * @author Andrea Camilloni
 *
 */
public class Stats  {

	private int count;
	private Location loc;

	/**
	 * 
	 */
	public Stats(Location loc,int c) {
		super();
		this.loc=loc;
		this.count=c;
		// TODO Auto-generated constructor stub
	}

	public void setCount(int i) {
		// TODO Auto-generated method stub
		this.count=i;
	}
	
	public int getCount() {
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public String toString() {
		return "Stats [count=" + count + ", loc=" + loc + "]";
	}

	public Location getLoc() {
		// TODO Auto-generated method stub
		return loc;
	}

	
}
