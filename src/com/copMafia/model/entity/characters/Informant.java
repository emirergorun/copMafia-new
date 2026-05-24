package com.copMafia.model.entity.characters;

import com.copMafia.model.entity.actions.informantActions.Inform;

public class Informant extends Character{

	private final Integer actionCount = 1;

	private Boolean usedAbility;

	Inform inform = new Inform();

	public Informant(){
		setIsBribable(true);
		setIsEvil(false);
		setIsJudge(false);
		setAvailableActionCount(actionCount);
		setUsedAbility(false);
		getPossibleActions().add(inform);
	}

	public Boolean getUsedAbility(){
		return this.usedAbility;
	}

	public void setUsedAbility(Boolean used){
		this.usedAbility = used;
	}
	
}
