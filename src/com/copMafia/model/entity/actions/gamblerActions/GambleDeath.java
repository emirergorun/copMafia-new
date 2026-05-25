package com.copMafia.model.entity.actions.gamblerActions;

import com.copMafia.model.entity.Player;
import com.copMafia.model.entity.actions.NightAction;
import com.copMafia.model.factory.ActionFactory;
import com.copMafia.util.enums.GambleType;

public class GambleDeath extends Gamble{
	
	public GambleDeath(){}

	public GambleDeath(Player gambler, Player opponent, Integer nightCount, Integer playerCount){
		super(gambler, opponent, nightCount, playerCount);
		this.setGambleType(GambleType.DEATH);
	}

	@Override
	public NightAction execute(Player player, Player opponent, ActionFactory actionFactory) {
		return actionFactory.creataGambleDeath(player, opponent);
	}

}
