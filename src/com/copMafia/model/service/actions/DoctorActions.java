package com.copMafia.model.service.actions;

import java.util.ArrayList;
import java.util.List;

import com.copMafia.model.entity.Player;
import com.copMafia.model.entity.actions.Action;
import com.copMafia.model.entity.actions.doctorActions.SaveVictim;
import com.copMafia.model.factory.ActionFactory;
import com.copMafia.model.service.ListService;
import com.copMafia.util.InputValidation;
import com.copMafia.util.messages.CommonMessages;
import com.copMafia.util.messages.DoctorMessages;
import com.copMafia.view.ConsolePrinter;

public class DoctorActions implements NightAction{

	private final ConsolePrinter consolePrinter;
	private final InputValidation inputValidation;
	private final ListService listService;
	private final ActionFactory actionFactory;

	public DoctorActions(ConsolePrinter consolePrinter, InputValidation inputValidation, ListService listService, ActionFactory actionFactory){
		this.consolePrinter = consolePrinter;
		this.inputValidation = inputValidation;
		this.listService = listService;
		this.actionFactory = actionFactory;
	}
	
	public SaveVictim saveVictim(Player doctor){
		consolePrinter.output(DoctorMessages.saveMessage);
		consolePrinter.output(DoctorMessages.saveWarningMessage);
		consolePrinter.printOpponents(doctor);
		consolePrinter.output(CommonMessages.choosePlayerMessage);
		Integer input = inputValidation.validInput(doctor, 1, listService.getDoctorChoicePlayers(doctor).size());
		Player victim = listService.getSaveLifeVictim(doctor, input);
		return actionFactory.createSaveVictim(doctor, victim);
	}

	@Override
	public List<Action> executeNightAction(Player player) {
		List<Action> actionList = new ArrayList<>();
		SaveVictim saveVictim = saveVictim(player);
		actionList.add(saveVictim);
		return actionList;
	}

}
