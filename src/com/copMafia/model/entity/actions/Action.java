package com.copMafia.model.entity.actions;

import com.copMafia.model.entity.Player;

public abstract class Action{

	private Player player;

	private Integer nightCount;

	public Action(Player player, Integer nightCount){
		this.player = player;
		this.nightCount = nightCount;
	}

	public Player getPlayer(){
		return this.player;
	}

	public Integer getNightCount(){
		return this.nightCount;
	}
	
}
