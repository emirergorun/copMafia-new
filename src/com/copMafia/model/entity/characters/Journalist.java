package com.copMafia.model.entity.characters;

import com.copMafia.model.entity.actions.journalistActions.Research;

public class Journalist extends Character{

	private final Integer actionCount = 1;

	Research research = new Research();
	
	public Journalist(){
		setIsBribable(true);
		setIsEvil(false);
		setIsJudge(false);
		setAvailableActionCount(actionCount);
		getPossibleActions().add(research);
	}

}
