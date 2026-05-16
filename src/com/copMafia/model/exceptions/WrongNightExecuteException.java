package com.copMafia.model.exceptions;

import com.copMafia.util.messages.ExceptionMessages;

public class WrongNightExecuteException extends CustomException{

	public WrongNightExecuteException(String location){
		super(location, ExceptionMessages.WrongNightActionFunction);
	}
	
}
