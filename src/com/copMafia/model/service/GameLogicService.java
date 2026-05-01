package com.copMafia.model.service;

import java.util.ArrayList;

import com.copMafia.model.entity.Player;
import com.copMafia.util.InputValidation;
import com.copMafia.util.messages.Messages;
import com.copMafia.view.ConsolePrinter;

public class GameLogicService {
	
	private final InputValidation inputValidation;
	private final ListService listService;
	private final ConsolePrinter consolePrinter;

	public GameLogicService(InputValidation inputValidation, ListService listService, ConsolePrinter consolePrinter){
		this.inputValidation = inputValidation;
		this.listService = listService;
		this.consolePrinter = consolePrinter;
	}

}
