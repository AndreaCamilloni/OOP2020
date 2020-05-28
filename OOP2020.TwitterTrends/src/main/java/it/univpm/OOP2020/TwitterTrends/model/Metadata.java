package it.univpm.OOP2020.TwitterTrends.model;

/**
 * @author Andrea Camilloni
 *
 */

public class Metadata {
	
	private String alias;
	private String sourceField;
	private String type;
	/**
	 * @param alias
	 * @param sourceField
	 * @param type
	 */
	public Metadata(String alias, String sourceField, String type) {
		super();
		this.alias = alias;
		this.sourceField = sourceField;
		this.type = type;
	}
	/**
	 * @return the alias
	 */
	public String getAlias() {
		return alias;
	}
	/**
	 * @param alias the alias to set
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}
	/**
	 * @return the sourceField
	 */
	public String getSourceField() {
		return sourceField;
	}
	/**
	 * @param sourceField the sourceField to set
	 */
	public void setSourceField(String sourceField) {
		this.sourceField = sourceField;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	
	
	
}
