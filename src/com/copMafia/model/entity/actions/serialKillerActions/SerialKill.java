package com.copMafia.model.entity.actions.serialKillerActions;

import com.copMafia.model.entity.Player;
import com.copMafia.model.entity.actions.KillAction;
import com.copMafia.util.enums.KillerRole;

public class SerialKill extends KillAction {

	public SerialKill(Player serialKiller, Player victim, Integer nightCount){
		super(serialKiller, victim, nightCount);
		this.setKillerRole(KillerRole.SERIAL_KILLER);
	}
	
}
