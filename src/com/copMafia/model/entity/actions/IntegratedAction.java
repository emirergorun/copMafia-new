package com.copMafia.model.entity.actions;

import java.util.List;

import com.copMafia.model.entity.Player;
import com.copMafia.model.service.ListService;

public abstract class IntegratedAction extends NightAction{

	private Player opponent;

	public IntegratedAction(Player player, Player opponent, Integer nightCount) {
		super(player, nightCount);
		this.opponent = opponent;
	}

	public IntegratedAction(){
		
	}

	public Player getOpponent(){
		return this.opponent;
	}
	
}
