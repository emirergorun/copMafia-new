package com.copMafia.model.entity.characters;

public class Citizen extends Character{

	private final Integer actionCount = 0;

	public Citizen(){
		setIsBribable(true);
		setIsEvil(false);
		setIsJudge(false);
		setPossibleActions(null);
		setAvailableActionCount(actionCount);
	}
}
