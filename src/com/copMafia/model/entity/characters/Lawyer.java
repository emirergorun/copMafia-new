package com.copMafia.model.entity.characters;

public class Lawyer extends Character{

	private final Integer actionCount = 1;

	public Lawyer(){
		setIsBribable(true);
		setIsEvil(false);
		setIsJudge(false);
		setAvailableActionCount(actionCount);
	}
	
}
