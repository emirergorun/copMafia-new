package com.copMafia.model.entity.characters;

import com.copMafia.model.entity.actions.serialKillerActions.SerialKill;

public class SerialKiller extends Character{

	private final Integer actionCount = 1;

	SerialKill kill = new SerialKill();

	public SerialKiller(){
		setIsBribable(true);
		setIsEvil(true);
		setIsJudge(false);
		setAvailableActionCount(actionCount);
		getPossibleActions().add(kill);
		setAvailableActionCount(actionCount);
	}
	

}
