package com.copMafia.model.service.actions;

import java.util.ArrayList;
import java.util.List;

import com.copMafia.model.entity.Player;
import com.copMafia.model.entity.actions.Action;
import com.copMafia.model.entity.actions.doctorActions.SaveVictim;
import com.copMafia.model.exceptions.NullActionException;
import com.copMafia.model.exceptions.WrongNightExecuteException;
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
	
	public SaveVictim saveVictim(Player doctor, Player victim){
		return actionFactory.createSaveVictim(doctor, victim);
	}
	
	@Override
	public Action executeNightAction(Player doctor, Action action, Player oppponent) {
		try {
			if(action instanceof SaveVictim)
				return saveVictim(doctor, oppponent);
			else
				throw new NullActionException(doctor.getCharacter().getClass().getSimpleName());
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
