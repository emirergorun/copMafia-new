package com.copMafia.model.exceptions;

public class CustomException extends RuntimeException {

	private String location;
	
	public CustomException(String message, String location){
		super(message);
		this.location = location;
	}

	public CustomException(String message){
		super(message);
	}

	public String getLocation(){
		return this.location;
	}

}
