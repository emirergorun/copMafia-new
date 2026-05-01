package com.copMafia.model.entity.roles;

import com.copMafia.model.entity.Player;

public interface Role {
	
	Player performNightAction(Player player);

	void performMorningAction(Player player);

	Player morningVoting(Player player);

	String getRoleDescription(Player player);

	String getStats(Player player);

}
