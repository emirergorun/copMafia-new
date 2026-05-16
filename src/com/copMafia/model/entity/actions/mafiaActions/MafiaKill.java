package com.copMafia.model.entity.actions.mafiaActions;

import com.copMafia.model.entity.Player;
import com.copMafia.model.entity.actions.KillAction;
import com.copMafia.util.enums.KillerRole;

public class MafiaKill extends KillAction{

	public MafiaKill(Player mafia, Player victim, Integer nightNumber){
		super(mafia, victim, nightNumber);
		this.setKillerRole(KillerRole.MAFIA);
	}

	public MafiaKill(){
		
	}
	
}
