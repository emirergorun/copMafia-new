package com.copMafia.model.entity.actions.bodyguardActions;

import java.util.List;

import com.copMafia.model.entity.Player;
import com.copMafia.model.entity.actions.IntegratedAction;
import com.copMafia.model.entity.actions.NightAction;
import com.copMafia.model.factory.ActionFactory;
import com.copMafia.model.service.ListService;

public class Protect extends IntegratedAction{

	private final Integer actionPrize = 10;
	private final Integer actionPrice = 0;
	private final Integer actionHonour = 2;

	public Protect(){}

	public Protect(Player bodyguard, Player opponent, Integer nightCount){
		super(bodyguard, opponent, nightCount);
		this.setActionPrize(actionPrize);
		this.setActionPrice(actionPrice);
		this.setActionHonour(actionHonour);
		this.setDecidable(false);
	}

	@Override
	public NightAction execute(Player player, Player opponent, ActionFactory actionFactory) {
		return actionFactory.createProtect(player, opponent);
	}

	@Override
	public List<Player> getActionOpponents(Player player, ListService listService) {
		return listService.getCurrentNonJudgeOpponents(player);
	}
	
}
