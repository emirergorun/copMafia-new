package com.copMafia.model.entity.actions.journalistActions;

import java.util.List;

import com.copMafia.model.entity.Player;
import com.copMafia.model.entity.actions.IntegratedAction;
import com.copMafia.model.entity.actions.NightAction;
import com.copMafia.model.factory.ActionFactory;
import com.copMafia.model.service.ListService;
import com.copMafia.util.enums.ResearchResult;

public class Research extends IntegratedAction{

	private final Integer actionPrize = 0;

	private final Integer actionPrice = 15;

	private final Integer actionHonour = 0;

	private ResearchResult result;

	public Research(){}

	public Research(Player journalist, Player opponent, Integer nightCount){
		super(journalist, opponent, nightCount);
		this.setActionHonour(actionHonour);
		this.setActionPrice(actionPrice);
		this.setActionPrize(actionPrize);
		this.setDecidable(true);
	}

	@Override
	public NightAction execute(Player player, Player opponent, ActionFactory actionFactory) {
		return actionFactory.createResearch(player, opponent);
	}

	@Override
	public List<Player> getActionOpponents(Player player, ListService listService) {
		return listService.getCurrentNonJudgeOpponents(player);
	}

	public ResearchResult getResearchResult(){
		return this.result;
	}

	public void setResearchResult(ResearchResult result){
		this.result = result;
	}
	
}
