package com.copMafia.model.entity.characters;

import com.copMafia.model.entity.actions.mafiaActions.Bribe;
import com.copMafia.model.entity.actions.mafiaActions.MafiaKill;

public class Mafia extends Character{

	private final Integer actionCount = 2;

	MafiaKill kill = new MafiaKill();
	Bribe bribe = new Bribe();

	public Mafia(){
		setIsBribable(false);
		setIsEvil(true);
		setIsJudge(false);
		getPossibleActions().add(kill);
		getPossibleActions().add(bribe);
		setAvailableActionCount(actionCount);
	}

}
