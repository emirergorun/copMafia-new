package com.copMafia.util;

import com.copMafia.model.entity.Player;
import com.copMafia.util.messages.ErrorMessages;
import com.copMafia.view.ConsolePrinter;
import com.copMafia.view.UserInput;

public class GameUtils {

	public Integer randomOneOrTwo(){
		Integer random = (int)(Math.random() * 2) + 1;
		return random;
	}
	
}
