package com.siquira76.samplecrudapi.Services.exceptions;

public class ObjectNotFondException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ObjectNotFondException(String msg) {
		super(msg);
	}
	
	public ObjectNotFondException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
