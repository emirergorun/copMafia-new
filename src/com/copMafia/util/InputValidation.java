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

	public Integer validPlayerListInput(Player player, Integer first, Integer last){
		String input = userInput.getInput();
		if(quitCondition(input)){
			return -1; // sayı seçilmeyecek olması
		}
		try {
			Integer integerInput = parseInteger(input);
			if(checkInterval(first, last, integerInput)){  //checkInterval metodu, sayının istenen aralıkta olup olmamasını kontrol ediyor
				return integerInput - 1;
			}else{
				return -2; // sayının yanlış aralıkta olması
			}
		} catch (NumberFormatException e) {
			return -3; // sayı olup olmaması
		}	
	}

	public Integer oneOrTwo(Player player){
		String input = userInput.getInput();
		Integer random = randomOneOrTwo();
		try {
			Integer integerInput = parseInteger(input);
			if(checkInterval(1, 2, integerInput)){  //checkInterval metodu, sayının istenen aralıkta olup olmamasını kontrol ediyor
				if(integerInput == random){
					return 1;
				}else{
					return 0;
				}
			}else{
				return -2; // 1 ya da 2'den başka bir sayı girildiyse
			}
		} catch (NumberFormatException e) {
			return -3; // sayı olup olmaması
		}
	}

	public Integer randomOneOrTwo(){
		Integer random = (int)(Math.random() * 2) + 1;
		return random;
	}
	
}
