package com.copMafia.model.entity.actions.gamblerActions;

import com.copMafia.model.entity.Player;
import com.copMafia.model.entity.actions.NightAction;
import com.copMafia.model.factory.ActionFactory;
import com.copMafia.util.enums.GambleType;

public class GambleArrest extends Gamble{

	public GambleArrest(){}

	public GambleArrest(Player gambler, Player opponent, Integer nightCount, Integer playerCount){
		super(gambler, opponent, nightCount, playerCount);
		this.setGambleType(GambleType.ARREST);
	}

	@Override
	public NightAction execute(Player player, Player opponent, ActionFactory actionFactory) {
		return actionFactory.creataGambleArrest(player, opponent);
	}
	
}
