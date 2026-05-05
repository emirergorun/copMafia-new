package com.copMafia.model.service.actions;

import java.util.List;

import com.copMafia.model.entity.Player;
import com.copMafia.model.entity.actions.Action;

public interface NightAction {

	List<Action> executeNightAction(Player player);
	
}
