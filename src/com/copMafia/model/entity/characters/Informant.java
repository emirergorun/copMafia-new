package com.copMafia.model.entity.characters;

public class Informant extends Character{

	private final Integer actionCount = 1;

	private Boolean usedAbility;

	public Informant(){
		setIsBribable(true);
		setIsEvil(false);
		setIsJudge(false);
		setAvailableActionCount(actionCount);
		setUsedAbility(false);
	}

	public Boolean getUsedAbility(){
		return this.usedAbility;
	}

	public void setUsedAbility(Boolean used){
		this.usedAbility = used;
	}
	
}
