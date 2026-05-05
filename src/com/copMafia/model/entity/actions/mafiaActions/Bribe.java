package com.copMafia.model.entity.actions.mafiaActions;

import com.copMafia.model.entity.Player;
import com.copMafia.model.entity.actions.Action;

public class Bribe extends Action{
	
	private Player victim;

	public Bribe(Player mafia, Player victim, Integer nightNumber){
		super(mafia, nightNumber);
		this.victim = victim;
	}

	public Player getVictim(){
		return this.victim;
	}

}
