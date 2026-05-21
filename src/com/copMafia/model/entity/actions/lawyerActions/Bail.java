package com.copMafia.model.entity.actions.lawyerActions;

import java.util.List;

import com.copMafia.model.entity.Player;
import com.copMafia.model.entity.actions.IntegratedAction;
import com.copMafia.model.entity.actions.NightAction;
import com.copMafia.model.factory.ActionFactory;
import com.copMafia.model.service.ListService;

public class Bail extends IntegratedAction{

	private final Integer actionPrize = 0;
	private final Integer actionPrice = 0;
	private final Integer positiveHonour = 2;
	private final Integer negativeHonour = -5;

	public Bail(Player lawyer, Player arrested, Integer nightCount){
		super(lawyer, arrested, nightCount);
		this.setActionPrice(actionPrice);
		this.setActionPrize(actionPrize);
		this.setDecidable(true);
		if(arrested.getCharacter().getIsEvil())
			this.setActionHonour(negativeHonour);
		else
			this.setActionHonour(positiveHonour);
	}

	public Bail(){}

	@Override
	public NightAction execute(Player player, Player arrested, ActionFactory actionFactory) {
		return actionFactory.createBail(player, arrested);
	}

	@Override
	public List<Player> getActionOpponents(Player player, ListService listService) {
		return listService.getPrisonList();
	}
	
}
