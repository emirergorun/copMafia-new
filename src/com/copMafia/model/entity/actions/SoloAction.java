package com.copMafia.model.entity.actions;

import com.copMafia.model.entity.Player;
import com.copMafia.model.factory.ActionFactory;

public abstract class SoloAction extends NightAction{

	public SoloAction(Player player, Integer nightCount){
		super(player, nightCount);
	}

	public SoloAction(){}

	
	
}
