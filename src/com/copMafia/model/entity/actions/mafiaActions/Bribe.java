package com.copMafia.model.entity.actions.mafiaActions;

import java.util.List;

import com.copMafia.model.entity.Player;
import com.copMafia.model.entity.actions.IntegratedAction;
import com.copMafia.model.entity.actions.NightAction;
import com.copMafia.model.factory.ActionFactory;
import com.copMafia.model.service.ListService;

public class Bribe extends IntegratedAction {

	private final String bribeDecisionMessage = "Bu gece birisine rüşvet vermek istiyor musun?";
	private final String bribeActionMessage = "Lütfen kime rüşvet vermek istediğini seç.";
	private final String bribeNegativeDecisionMessage = "Bu gece kimseye rüşvet vermemeye karar verdin.";
	
	private String bribeOpponentMessage;

	private final Integer actionPrice = 20;

	private final Integer actionPrize = 0;

	private final Integer honour = -1;
	
	
	public Bribe(Player mafia, Player victim, String message, Integer nightNumber){
		super(mafia, victim, nightNumber);
		this.setActionMessage(bribeActionMessage);
		this.setDecidable(true);
		this.setActionMessage(bribeActionMessage);
		this.setDecisionMessage(bribeDecisionMessage); 
		this.setNegativeDecisionMessage(bribeNegativeDecisionMessage);
		this.setActionPrice(actionPrice);
		this.setActionPrize(actionPrize);
		this.setActionHonour(honour);
	}

	public Bribe(){
		
	}

	public String getBribeMessage(){
		return this.bribeOpponentMessage;
	}

	public void setBribeOppponentMessage(String message){
		this.bribeOpponentMessage = message;
	}

	public List<Player> getActionOpponents(Player player, ListService listService){
		return listService.getCurrentNonJudgeOpponents(player);
	}

	@Override
	public NightAction execute(Player player, Player opponent, ActionFactory actionFactory) {
		return actionFactory.createBribe(player, opponent, bribeActionMessage);
	}

	

}
