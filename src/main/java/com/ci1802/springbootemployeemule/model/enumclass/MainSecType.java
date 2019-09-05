package com.ci1802.springbootemployeemule.model.enumclass;

public enum MainSecType {
	MAIN("M"), SECONDARY("S");
	private String value;
	private MainSecType(String value) {
		this.value = value;
	}
	public String getValue() {
		return value;
	}
}
