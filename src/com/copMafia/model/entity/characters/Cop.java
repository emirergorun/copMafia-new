package com.copMafia.model.entity.characters;

import com.copMafia.model.entity.actions.copActions.Custody;

public class Cop extends Character{

	private final Integer actionCount = 1;

	Custody custody = new Custody(null, null, null);

	public Cop(){
		setIsBribable(true);
		setIsEvil(false);
		setIsJudge(false);
		setAvailableActionCount(actionCount);
	}
	
}
