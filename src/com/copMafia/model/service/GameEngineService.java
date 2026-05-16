package com.copMafia.model.service;

import java.util.ArrayList;
import java.util.List;

import com.copMafia.model.entity.Player;
import com.copMafia.model.entity.actions.Action;
import com.copMafia.model.entity.actions.IntegratedAction;
import com.copMafia.model.service.actions.NightAction;
import com.copMafia.util.GameUtils;
import com.copMafia.util.InputValidation;
import com.copMafia.util.messages.CommonMessages;
import com.copMafia.util.messages.ErrorMessages;
import com.copMafia.view.ConsolePrinter;
import com.copMafia.view.UserInput;

public class GameEngineService {

	private final UserInput userInput;
	private final ConsolePrinter consolePrinter;
	private final InputValidation inputValidation;
	private final GameUtils gameUtils;
	private final ListService listService;
	private final NightAction nightAction;

	public GameEngineService(UserInput userInput, ConsolePrinter consolePrinter, InputValidation inputValidation, 
		GameUtils gameUtils, ListService listService, NightAction nightAction){
		this.userInput = userInput;
		this.consolePrinter = consolePrinter;
		this.inputValidation = inputValidation;
		this.gameUtils = gameUtils;
		this.listService = listService;
		this.nightAction = nightAction;
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

	public void playerNightAction(Player player){
		List<Player> opponentList = new ArrayList<>();
		for (Action action : player.getCharacter().getPossibleActions()){
			opponentList = action.getActionOpponents(player, listService);
			Player opponent = null;
			consolePrinter.output(action.getActionMessage()); // bu gece birini öldüreceksin
			if(action.getDecidable()){
				boolean yesNoFlag = userInput.yesOrNo(player);
				boolean budgetFlag = checkBudget(player, action);
				if(yesNoFlag){
					if(budgetFlag){
						if(action instanceof IntegratedAction){
						consolePrinter.output(CommonMessages.choosePlayerMessage); // lütfen listeden birisini seç
						consolePrinter.printList(opponentList);
						opponent = opponentList.get(inputValidation.validPlayerListInput(player, 1, opponentList.size()) - 1);
						listService.getActionRepo().getExecutedTempList().add(nightAction.executeNightAction(player, action, opponent));
					}
					else
						listService.getActionRepo().getExecutedTempList().add(nightAction.executeNightAction(player, action));
					}else{
						consolePrinter.errorOutput(ErrorMessages.insufficientBalanceError);
						continue;
					}
				}else
					consolePrinter.output(action.getNegativeDecisionMessage());
			}else{
				if(action instanceof IntegratedAction){
					consolePrinter.output(CommonMessages.choosePlayerMessage); // lütfen listeden birisini seç
					consolePrinter.printList(opponentList);
					listService.getActionRepo().getExecutedTempList().add(nightAction.executeNightAction(player, action, opponent));
				}
				else
					listService.getActionRepo().getExecutedTempList().add(nightAction.executeNightAction(player, action));
			}
		}
	}

	public boolean checkBudget(Player player, Action action){
		return player.getBudget() >= action.getActionPrice();
	}
	
}
