package com.ci1802.springbootemployeemule.model.enumclass;

public enum PoiType {
	POI("POI"),EXTERN("EXT"),INTERN("INT");
	private String value;
	
	/**
	 * Instantiates a new enum object called PoiType.
	 *
	 * Constructor is automatically called. 
	 * Call directly to this class to get the value
	 * 
	 * @see https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html
	 */
	private PoiType(String value) {
		this.value = value;
	}
	public String getValue() {
		return value;
	}
}
