package com.copMafia.model.service.actions;

import java.util.List;

import com.copMafia.model.entity.Player;
import com.copMafia.model.entity.actions.Action;
import com.copMafia.model.entity.actions.copActions.Custody;
import com.copMafia.model.entity.actions.copActions.Interrogation;
import com.copMafia.model.entity.actions.judgeActions.Arrest;
import com.copMafia.model.factory.ActionFactory;
import com.copMafia.model.service.ListService;
import com.copMafia.util.InputValidation;
import com.copMafia.util.messages.CommonMessages;
import com.copMafia.util.messages.CopMessages;
import com.copMafia.util.messages.MafiaMessages;
import com.copMafia.view.ConsolePrinter;
import com.copMafia.view.UserInput;

public class CopActions implements NightAction{
	
	private final UserInput userInput;
	private final ConsolePrinter consolePrinter;
	private final InputValidation inputValidation;
	private final ListService listService;
	private final ActionFactory actionFactory;

	public CopActions(UserInput userInput, ConsolePrinter consolePrinter, InputValidation inputValidation, ListService listService, ActionFactory actionFactory){
		this.userInput = userInput;
		this.consolePrinter = consolePrinter;
		this.inputValidation = inputValidation;
		this.listService = listService;
		this.actionFactory = actionFactory;
	}

	public Custody custody(Player cop){
		consolePrinter.output(CopMessages.custodyMessage);
		consolePrinter.printOpponents(mafia);
		consolePrinter.output(CommonMessages.choosePlayerMessage);
		Integer input = inputValidation.validInput(mafia, 1, listService.getCurrentNonJudgeOpponents(mafia).size());
		Player victim = listService.getChosenOpponent(mafia, input);
		return actionFactory.createKillAction(mafia, victim);
	}

	public Interrogation interrogate(Player cop){

	}







	@Override
	public List<Action> executeNightAction(Player player) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'executeNightAction'");
	}

}
