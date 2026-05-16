package com.copMafia.view;

import com.copMafia.model.entity.Player;
import com.copMafia.util.InputUtil;
import com.copMafia.util.InputValidation;

public class UserInput {

	private final ConsolePrinter consolePrinter;
	private final InputValidation inputValidation;

	public UserInput(ConsolePrinter consolePrinter, InputValidation inputValidation){
		this.consolePrinter = consolePrinter;
		this.inputValidation = inputValidation;
	}

	public String getInput(){
		return InputUtil.scanner.nextLine();
	}

	public boolean yesOrNo(Player player){
		return inputValidation.validPlayerListInput(player, 1, 2) == 1;
	}

}
