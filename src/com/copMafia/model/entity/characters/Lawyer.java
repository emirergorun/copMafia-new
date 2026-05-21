package com.copMafia.model.entity.characters;

import com.copMafia.model.entity.actions.lawyerActions.Bail;

public class Lawyer extends Character{

	private final Integer actionCount = 1;

	Bail bail = new Bail();

	public Lawyer(){
		setIsBribable(true);
		setIsEvil(false);
		setIsJudge(false);
		setAvailableActionCount(actionCount);
		getPossibleActions().add(bail);
		setAvailableActionCount(actionCount);
	}
	
}
