package com.copMafia.controller;

import java.util.List;

import com.copMafia.model.entity.Player;
import com.copMafia.model.entity.actions.NightAction;
import com.copMafia.model.service.ListService;
import com.copMafia.util.InputValidation;
import com.copMafia.util.messages.ErrorMessages;
import com.copMafia.view.ConsolePrinter;
import com.copMafia.view.UserInput;

public class GameController {

	private final UserInput userInput;
	private final InputValidation inputValidation;
	private final ConsolePrinter consolePrinter;
	private final ListService listService;
	
	public GameController(UserInput userInput, InputValidation inputValidation, ConsolePrinter consolePrinter, ListService listService){
		this.userInput = userInput;
		this.inputValidation = inputValidation;
		this.consolePrinter = consolePrinter;
		this.listService = listService;
	}

	public Integer inputController(Player player, Integer first, Integer last){
		Integer input = 0;
		do{
			input = inputValidation.validPlayerListInput(player, first, last);
			if(input == -2){
				consolePrinter.errorOutput(ErrorMessages.invalidIntervalError);
			}else if(input == -3){
				consolePrinter.errorOutput(ErrorMessages.nonNumberInputError);
			}
		}while(input < -1);
		return input;
	}

	public Boolean oneOrTwoController(Player player){
		Integer input = null;
		do{
			input = inputValidation.oneOrTwo(player);
			if(input == 0)
				return false;
			else if(input == -2)
				consolePrinter.errorOutput(ErrorMessages.invalidIntervalError);
			else if(input == -3)
				consolePrinter.errorOutput(ErrorMessages.nonNumberInputError);
			else
				return true;
		}while(input < -1);
		return null; // kodun buraya hiç gelmemesi gerekiyor
	}

	public List<Player> actionController(Player person){
		List<NightAction> actionList = listService.getActionList(person);
	}

	/*public List<Acti getActionList(Player person){
		for (Action action : actionRepo.getMasterActionList()) {
			if(action.getPlayer().getCharacter().equals(person.getCharacter()))
				return action;
		}
		return null;
	}*/

}
