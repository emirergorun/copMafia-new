package com.copMafia.model.entity.actions.informantActions;

import java.util.List;

import com.copMafia.model.entity.Player;
import com.copMafia.model.entity.actions.NightAction;
import com.copMafia.model.entity.actions.SoloAction;
import com.copMafia.model.factory.ActionFactory;
import com.copMafia.model.service.ListService;

public class Inform extends SoloAction{

	private final Integer actionPrize = 0;

	private final Integer actionPrice = 30;

	private final Integer actionHonour = 0;


	public Inform(Player player, Integer nightNumber){
		super(player, nightNumber);
		this.setActionPrice(actionPrice);
		this.setActionPrize(actionPrize);
		this.setActionHonour(actionHonour);
		this.setDecidable(true);
		this.setActionMessage(getActionMessage()); // burası ayarlanacak
	}

	public Inform(){}

	@Override
	public NightAction execute(Player player, Player opponent, ActionFactory actionFactory){
		return actionFactory.createInform(player);
	}

	@Override
	public List<Player> getActionOpponents(Player informant, ListService listService) {
		return listService.informantList(informant);
	}

}
