package com.copMafia.model.entity.characters;

public class Bodyguard extends Character{

	private final Integer actionCount = 1;

	public Bodyguard(){
		setIsBribable(true);
		setIsEvil(false);
		setIsJudge(false);
		setAvailableActionCount(actionCount);
	}
	
}
