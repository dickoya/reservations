package com.reservations.reservations.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class GeneralException extends Exception {
	private String code;
	private String message;
	private String status;

	public void setCode(String code) {
		this.code = code;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public String getStatus() {
		return status;
	}

	public GeneralException(String message) {
		super(message);
		this.message = message;
	}

	public GeneralException(String code, String message, String status) {
		super(message);
		this.code = code;
		this.message = message;
		this.status = status;
	}

	public GeneralException(String code, String message) {
		super(message);
		this.code = code;
		this.message = message;
	}
}
