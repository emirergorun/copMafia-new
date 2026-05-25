package com.copMafia.model.entity.characters;

import com.copMafia.model.entity.actions.bodyguardActions.Protect;

public class Bodyguard extends Character{

	private final Integer actionCount = 1;

	Protect protect = new Protect();

	public Bodyguard(){
		setIsBribable(true);
		setIsEvil(false);
		setIsJudge(false);
		setAvailableActionCount(actionCount);
		getPossibleActions().add(protect);
	}
	
}
