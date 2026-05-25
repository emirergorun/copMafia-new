package com.copMafia.model.entity.characters;

import com.copMafia.model.entity.actions.gamblerActions.Gamble;
import com.copMafia.model.entity.actions.gamblerActions.GambleArrest;
import com.copMafia.model.entity.actions.gamblerActions.GambleDeath;

public class Gambler extends Character{

	private final Integer actionCount = 1;

	private Boolean usedAbility;

	GambleArrest gambleArrest = new GambleArrest();
	GambleDeath gambleDeath = new GambleDeath();

	public Gambler(){
		setIsBribable(true);
		setIsEvil(false);
		setIsJudge(false);
		setAvailableActionCount(actionCount);
		setUsedAbility(false);
		getPossibleActions().add(gambleArrest);
		getPossibleActions().add(gambleDeath);
	}

	public Boolean getUsedAbility(){
		return this.usedAbility;
	}

	public void setUsedAbility(Boolean used){
		this.usedAbility = used;
	}
	
}
