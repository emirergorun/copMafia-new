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


	public boolean checkInterval(Integer first, Integer last, Integer input){
		return (input <= last && input >= first);
	}

	public Integer parseInteger(String input){
		return Integer.parseInt(input);
	}

	public boolean quitCondition(String input){
		return input.equalsIgnoreCase("q");
	}

	public Integer validInput(Player player, Integer first, Integer last){
		while(true){
			String input = userInput.getInput();
			if(quitCondition(input)){
				return -1;
			}
			try {
				Integer integerInput = parseInteger(input);
				if(checkInterval(first, last, integerInput)){  //checkInterval metodu, sayının istenen aralıkta olup olmamasını kontrol ediyor
					return integerInput;
				}else{
					consolePrinter.errorOutput(ErrorMessages.invalidIntervalError);
				}
			} catch (NumberFormatException e) {
				consolePrinter.errorOutput(ErrorMessages.nonNumberInputError); //try-catch, sayı olup olmamasını kontrol ediyor
			}
		}
	}
	
}
