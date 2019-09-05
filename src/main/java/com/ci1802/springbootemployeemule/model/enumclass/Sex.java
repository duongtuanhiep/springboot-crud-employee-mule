package com.ci1802.springbootemployeemule.model.enumclass;

public enum Sex {
	MALE("M"), FEMALE("F");
	private String value;

	/* @see https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html
	 *
	 * Instantiates a new sex.
	 *
	 * @param value
	 *            the value
	 */
	private Sex(String value) {
		this.value = value;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
}
