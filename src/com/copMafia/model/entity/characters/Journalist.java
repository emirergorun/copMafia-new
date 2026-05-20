package com.copMafia.model.entity.characters;

public class Journalist extends Character{

	private final Integer actionCount = 1;
	
	public Journalist(){
		setIsBribable(true);
		setIsEvil(false);
		setIsJudge(false);
		setAvailableActionCount(actionCount);
	}

}
