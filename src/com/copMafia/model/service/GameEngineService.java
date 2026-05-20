package com.copMafia.model.service;

import java.util.ArrayList;
import java.util.List;

import com.copMafia.model.entity.Player;
import com.copMafia.model.entity.actions.NightAction;
import com.copMafia.model.exceptions.InsufficientBalanceException;
import com.copMafia.model.factory.ActionFactory;
import com.copMafia.model.entity.actions.IntegratedAction;
import com.copMafia.util.GameUtils;
import com.copMafia.util.InputValidation;
import com.copMafia.util.messages.CommonMessages;
import com.copMafia.util.messages.ErrorMessages;
import com.copMafia.util.messages.ExceptionMessages;
import com.copMafia.view.ConsolePrinter;
import com.copMafia.view.UserInput;

public class GameEngineService {

	private final UserInput userInput;
	private final ConsolePrinter consolePrinter;
	private final InputValidation inputValidation;
	private final GameUtils gameUtils;
	private final ListService listService;
	private final ActionFactory actionFactory;

	public GameEngineService(UserInput userInput, ConsolePrinter consolePrinter, InputValidation inputValidation, 
		GameUtils gameUtils, ListService listService, ActionFactory actionFactory){
		this.userInput = userInput;
		this.consolePrinter = consolePrinter;
		this.inputValidation = inputValidation;
		this.gameUtils = gameUtils;
		this.listService = listService;
		this.actionFactory = actionFactory;
	}


	public boolean copOneOrTwo(Player player){
		while(true){
			String input = userInput.getInput();
			Integer random = gameUtils.randomOneOrTwo();
			try {
				Integer integerInput = inputValidation.parseInteger(input);
				if(inputValidation.checkInterval(1, 2, integerInput)){  //checkInterval metodu, sayının istenen aralıkta olup olmamasını kontrol ediyor
					return random.equals(integerInput);
				}else{
					consolePrinter.errorOutput(ErrorMessages.invalidIntervalError);
				}
			} catch (NumberFormatException e) {
				consolePrinter.errorOutput(ErrorMessages.nonNumberInputError); //try-catch, sayı olup olmamasını kontrol ediyor
			}
		}
	}
	
	public boolean checkBudget(Player player, NightAction action){
		return player.getBudget() >= action.getActionPrice();
	}

	public void playerNightAction(Player player){
		int executedActionCount = 0;
		Player opponent = null;
		boolean yesNoFlag = true;
		NightAction nightAction = null;
		List<Player> opponentList = new ArrayList<Player>();
		for (NightAction action : player.getCharacter().getPossibleActions()){
			nightAction = action;
			opponentList = nightAction.getActionOpponents(player, listService);
			consolePrinter.output(action.getActionMessage());
			if(action.getDecidable())
				yesNoFlag = userInput.yesOrNo(player);
			if(yesNoFlag){
				try {
					checkActionBudget(player, nightAction);
					if(opponentList.size() != 0){
						consolePrinter.output(CommonMessages.choosePlayerMessage); // lütfen listeden birisini seç
						consolePrinter.printList(opponentList);
						opponent = opponentList.get(inputValidation.validPlayerListInput(player, 1, opponentList.size()) - 1);
					}
					nightAction.execute(player, opponent, actionFactory);
					listService.getActionRepo().getExecutedTempList().add(nightAction);
					executedActionCount++;
					if(executedActionCount >= player.getCharacter().getAvailableActionCount()){
						break;
					}
				} catch (InsufficientBalanceException e) {
					consolePrinter.errorOutput(ExceptionMessages.InsufficientBalanceException);
				}
			}
			else{
				consolePrinter.output(action.getNegativeDecisionMessage());
				continue;
			}

		}
	}

	public void checkActionBudget(Player player, NightAction action){
		if(player.getBudget() < action.getActionPrice()){
			throw new InsufficientBalanceException();
		}
	}
}
