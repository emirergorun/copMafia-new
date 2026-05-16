package com.copMafia.model.service.actions;

import com.copMafia.model.entity.Player;
import com.copMafia.model.entity.actions.Action;

public interface NightAction {

	Action executeNightAction(Player player, Action action);
	Action executeNightAction(Player player, Action action, Player oppponent);
	
}
