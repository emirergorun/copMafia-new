package com.copMafia.model.entity.actions.serialKillerActions;

import com.copMafia.model.entity.Player;
import com.copMafia.model.entity.actions.KillAction;
import com.copMafia.model.entity.actions.NightAction;
import com.copMafia.model.factory.ActionFactory;
import com.copMafia.util.enums.KillerRole;

public class SerialKill extends KillAction {
	
	public SerialKill(Player serialKiller, Player victim, Integer nightCount){
		super(serialKiller, victim, nightCount);
		this.setKillerRole(KillerRole.SERIAL_KILLER);
	}

	public SerialKill(){}

	@Override
	public NightAction execute(Player player, Player opponent, ActionFactory actionFactory) {
		return actionFactory.createKillAction(player, opponent);
	}
	
}
