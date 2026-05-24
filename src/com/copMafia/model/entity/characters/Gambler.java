package com.copMafia.model.entity.characters;

import com.copMafia.model.entity.actions.gamblerActions.Gamble;

public class Gambler extends Character{

	private final Integer actionCount = 1;

	private Boolean usedAbility;

	Gamble gamble = new Gamble();

	public Gambler(){
		setIsBribable(true);
		setIsEvil(false);
		setIsJudge(false);
		setAvailableActionCount(actionCount);
		setUsedAbility(false);
		getPossibleActions().add(gamble);
	}

	public Boolean getUsedAbility(){
		return this.usedAbility;
	}

	public void setUsedAbility(Boolean used){
		this.usedAbility = used;
	}
	
}
