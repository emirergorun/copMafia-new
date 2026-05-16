package com.copMafia.model.exceptions;

import com.copMafia.util.messages.ExceptionMessages;

public class NullActionException extends CustomException{

	public NullActionException(String location){
		super(location, ExceptionMessages.NullActionException);
	}
	
}
