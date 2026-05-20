package com.copMafia.model.exceptions;

import com.copMafia.util.messages.ExceptionMessages;

public class InsufficientBalanceException extends CustomException {

	public InsufficientBalanceException(){
		super(ExceptionMessages.InsufficientBalanceException);
	}

}
