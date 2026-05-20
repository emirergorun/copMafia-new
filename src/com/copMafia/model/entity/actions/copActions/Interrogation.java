package com.copMafia.model.entity.actions.copActions;

import java.util.List;

import com.copMafia.model.entity.Player;
import com.copMafia.model.entity.actions.IntegratedAction;
import com.copMafia.model.entity.actions.NightAction;
import com.copMafia.model.factory.ActionFactory;
import com.copMafia.model.service.ListService;
import com.copMafia.util.enums.InterrogationResult;

public class Interrogation extends IntegratedAction{

	private InterrogationResult result;

	private final Integer actionPrice = 30;

	private final Integer actionPrize = 0;

	private final Integer honour = 0;
	
	public Interrogation(Player cop, Player suspect, Integer nightCount) {
		super(cop, suspect, nightCount);
		this.setActionPrice(actionPrice);
		this.setActionPrize(actionPrize);
		this.setActionHonour(honour);
	}

	public Interrogation(){}

	public InterrogationResult getResult(){
		return this.result;
	}

	public void setResult(InterrogationResult result){
		this.result = result;
	}

	@Override
	public NightAction execute(Player player, Player opponent, ActionFactory actionFactory) {
		return actionFactory.createInterrogation(player, opponent);
	}

	@Override
	public List<Player> getActionOpponents(Player player, ListService listService){
		return listService.copInterrogationList(player);
	}

}
