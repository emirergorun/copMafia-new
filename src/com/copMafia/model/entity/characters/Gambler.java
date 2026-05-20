package com.copMafia.model.entity.characters;

public class Gambler extends Character{

	private final Integer actionCount = 1;

	public Gambler(){
		setIsBribable(true);
		setIsEvil(false);
		setIsJudge(false);
		setAvailableActionCount(actionCount);
	}
	
}
