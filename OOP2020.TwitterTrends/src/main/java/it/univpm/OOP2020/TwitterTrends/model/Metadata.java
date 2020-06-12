package it.univpm.OOP2020.TwitterTrends.model;

/**
 * Class that describes a single Metadata
 * @author Andrea Camilloni
 *
 */

public class Metadata {
	/**
	 * alias of Metadata
	 */
	private String alias;
	/**
	 * sourceField of Metadata
	 */
	private String sourceField;
	/**
	 * type of Metadata
	 */
	private String type;
	/**
	 * Constructor
	 * @param alias the alias of Metadata
	 * @param sourceField the sourcefield of Metadata
	 * @param type the type of Metadata
	 */
	public Metadata(String alias, String sourceField, String type) {
		super();
		this.alias = alias;
		this.sourceField = sourceField;
		this.type = type;
	}
	/**
	 * Returns the alias
	 * @return the alias
	 */
	public String getAlias() {
		return alias;
	}
	/**
	 * Set the alias
	 * @param alias the alias to set
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}
	/**
	 * Returns the sourcefield
	 * @return the sourceField
	 */
	public String getSourceField() {
		return sourceField;
	}
	/**
	 * Set the sourcefield
	 * @param sourceField the sourceField to set
	 */
	public void setSourceField(String sourceField) {
		this.sourceField = sourceField;
	}
	/**
	 * Returns the type
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * Set the type
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	
	
	
}
