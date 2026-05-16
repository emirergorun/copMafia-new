package com.copMafia.model.exceptions;

public class CustomException extends RuntimeException {

	private final String location;
	
	public CustomException(String message, String location){
		super(message);
		this.location = location;
	}

	public String getLocation(){
		return this.location;
	}

}
