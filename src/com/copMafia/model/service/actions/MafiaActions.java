package com.copMafia.model.service.actions;

import java.util.ArrayList;
import java.util.List;

import com.copMafia.controller.GameController;
import com.copMafia.model.entity.Player;
import com.copMafia.model.entity.actions.Action;
import com.copMafia.model.entity.actions.KillAction;
import com.copMafia.model.entity.actions.mafiaActions.Bribe;
import com.copMafia.model.entity.characters.Mafia;
import com.copMafia.model.exceptions.NullActionException;
import com.copMafia.model.exceptions.WrongNightExecuteException;
import com.copMafia.model.factory.ActionFactory;
import com.copMafia.model.service.ListService;
import com.copMafia.util.InputValidation;
import com.copMafia.util.messages.CommonMessages;
import com.copMafia.util.messages.MafiaMessages;
import com.copMafia.view.ConsolePrinter;
import com.copMafia.view.UserInput;

public class MafiaActions implements NightAction{

	private final UserInput userInput;
	private final ConsolePrinter consolePrinter;
	private final GameController gameController;
	private final ListService listService;
	private final ActionFactory actionFactory;
	

	public MafiaActions(UserInput userInput, ConsolePrinter consolePrinter, GameController gameController, ListService listService, ActionFactory actionFactory){
		this.userInput = userInput;
		this.consolePrinter = consolePrinter;
		this.gameController = gameController;
		this.listService = listService;
		this.actionFactory = actionFactory;
	}

	public KillAction kill(Player mafia, Player opponent){
		return actionFactory.createKillAction(mafia, opponent);
	}

	public Bribe bribe(Player mafia, Player victim){
		consolePrinter.output(MafiaMessages.bribeOpponentMessage);
		String message = userInput.getInput();
		return actionFactory.createBribe(mafia, victim, message);
	}

	@Override
	public Action executeNightAction(Player mafia, Action action, Player victim) {
		try {
			if(action instanceof KillAction)
				return kill(mafia, victim);
			else if(action instanceof Bribe)
				return bribe(mafia, victim);
			else
				throw new NullActionException(mafia.getCharacter().getClass().getSimpleName());
		} catch (NullActionException e) {
			System.out.println(e.getLocation() + " - " + e.getMessage());
		}
		return null; // buraya hiç gelmemesi gerekiyor
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
