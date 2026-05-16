package com.copMafia.model.service.actions;

import java.util.List;

import com.copMafia.model.entity.Player;
import com.copMafia.model.entity.actions.Action;
import com.copMafia.model.entity.actions.copActions.Custody;
import com.copMafia.model.entity.actions.copActions.Interrogation;
import com.copMafia.model.entity.actions.judgeActions.Arrest;
import com.copMafia.model.entity.characters.Cop;
import com.copMafia.model.exceptions.NullActionException;
import com.copMafia.model.exceptions.WrongNightExecuteException;
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

	public Custody custody(Player cop, Player suspect){
		return actionFactory.createCustody(cop, suspect);
	}

	public Interrogation interrogate(Player cop, Player suspect){
		return actionFactory.createInterrogation(cop, suspect);
	}

	@Override
	public Action executeNightAction(Player cop, Action action, Player oppponent) {
		try {
			if(action instanceof Custody)
				return custody(cop, oppponent);
			else if(action instanceof Interrogation)
				return interrogate(cop, oppponent);
			else
				throw new NullActionException(cop.getCharacter().getClass().getSimpleName());
		} catch (NullActionException e) {
			System.out.println(e.getLocation() + " - " + e.getMessage());
		}
		return null;
	}

	@Override
	public Action executeNightAction(Player player, Action action) {
		try {
			throw new WrongNightExecuteException(player.getCharacter().getClass().getSimpleName());
		} catch (WrongNightExecuteException e) {
			System.out.println(e.getLocation() + " - " + e.getMessage());
		}
		// BU FONKSİYONUN HİÇ ÇALIŞMAMASI GEREKİYOR
		return null;
	}

}
