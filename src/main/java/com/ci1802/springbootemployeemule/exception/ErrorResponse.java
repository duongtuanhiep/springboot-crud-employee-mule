
package com.ci1802.springbootemployeemule.exception;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class ErrorResponse implements Serializable {

	// plain data
	private final String status;

	// encrypted data
	private final List<String> encryptedInformation;

	public ErrorResponse(String status, List<String> encryptedInformation) {
		this.status = status;
		this.encryptedInformation = encryptedInformation;
	}

	public List<String> getEncryptedInformation() {
		return encryptedInformation;
	}

	public String getStatus() {
		return status;
	}

}
