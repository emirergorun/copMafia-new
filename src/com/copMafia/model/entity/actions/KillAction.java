package com.copMafia.model.entity.actions;

import com.copMafia.model.entity.Player;
import com.copMafia.util.enums.KillStatus;
import com.copMafia.util.enums.KillerRole;

public class KillAction extends Action{
	
	private Player victim;

	private KillStatus status;

	private KillerRole killerRole;

	public KillAction(Player killer, Player victim, Integer nightNumber){
		super(killer, nightNumber);
		this.victim = victim;
	}

	public Player getVictim(){
		return this.victim;
	}

	public KillStatus getStatus(){
		return this.status;
	}

	public void setStatus(KillStatus status){
		this.status = status;
	}

	public KillerRole getKillerRole(){
		return this.killerRole;
	}

	public void setKillerRole(KillerRole killerRole){
		this.killerRole = killerRole;
	}

}
