package com.ci1802.springbootemployeemule.model.enumclass;

public enum PhoneType {
	WORK("W"), WORK_MOBILE("WM"), HOME("H"), HOME_MOBILE("HM"), SKYPE("S");
	private String value;
	private PhoneType(String value) {
		this.value = value;
	}
	public String getValue() {
		return value;
	}
}
