package com.copMafia.model.entity.actions;

import java.util.List;

import com.copMafia.model.entity.Player;
import com.copMafia.model.service.ListService;

public class IntegratedAction extends Action{

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

	@Override
	public List<Player> getActionOpponents(Player player, ListService listService) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getActionOpponents'");
	}
	
}
