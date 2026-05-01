package com.copMafia.util;

import java.util.List;

import com.copMafia.model.entity.Player;
import com.copMafia.model.service.ListService;
import com.copMafia.util.messages.ErrorMessages;
import com.copMafia.view.ConsolePrinter;
import com.copMafia.view.UserInput;

public class InputValidation {

	private final UserInput userInput;
	private final ConsolePrinter consolePrinter;
	private final ListService listService;

	public InputValidation(UserInput userInput, ConsolePrinter consolePrinter, ListService listService){
		this.userInput = userInput;
		this.consolePrinter = consolePrinter;
		this.listService = listService;
	}


	public boolean checkInteger(String input){
		try {
			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public boolean checkInterval(Integer first, Integer last, Integer input){
		return (input <= last && input >= first);
	}
	
}
