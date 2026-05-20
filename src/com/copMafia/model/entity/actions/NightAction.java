package com.copMafia.model.entity.actions;

import java.util.List;

import com.copMafia.model.entity.Player;
import com.copMafia.model.factory.ActionFactory;
import com.copMafia.model.service.ListService;

public abstract class NightAction{

	private Player player;

	private Integer nightCount;

	private String actionMessage;

	private String decisionMessage;

	private String negativeDecisionMessage;

	private Boolean isDecidable;

	private Integer actionPrice;

	private Integer actionPrize;

	private Integer actionHonour;

	public NightAction(Player player, Integer nightCount){
		this.player = player;
		this.nightCount = nightCount;
	}

	public NightAction(){
	}

	public Player getPlayer(){
		return this.player;
	}

	public Integer getNightCount(){
		return this.nightCount;
	}

	public String getActionMessage(){
		return this.actionMessage;
	}

	public void setActionMessage(String actionMessage){
		this.actionMessage = actionMessage;
	}

	public String getDecisionMessage(){
		if(!this.isDecidable)
			return null;
		return this.decisionMessage;
	}

	public void setDecisionMessage(String decisionMessage){
		if(!this.isDecidable){
			this.decisionMessage = null;
		}else{
			this.decisionMessage = decisionMessage;
		}
	}

	public String getNegativeDecisionMessage(){
		if(!this.isDecidable)
			return null;
		return this.negativeDecisionMessage;
	}

	public void setNegativeDecisionMessage(String negativeDecisionMessage){
		if(!this.isDecidable)
			this.negativeDecisionMessage = null;
		else
			this.negativeDecisionMessage = negativeDecisionMessage;
	}

	public Boolean getDecidable(){
		return this.isDecidable;
	}

	public void setDecidable(Boolean isDecidable){
		this.isDecidable = isDecidable;
	}

	public Integer getActionPrice(){
		return this.actionPrice;
	}

	public void setActionPrice(Integer actionPrice){
		this.actionPrice = actionPrice;
	}

	public Integer getActionPrize(){
		return this.actionPrize;
	}

	public void setActionPrize(Integer actionPrize){
		this.actionPrize = actionPrize;
	}

	public Integer getActionHonour(){
		return this.actionHonour;
	}

	public void setActionHonour(Integer actionHonour){
		this.actionHonour = actionHonour;
	}

	public abstract NightAction execute(Player player, Player opponent, ActionFactory actionFactory);

	public abstract List<Player> getActionOpponents(Player player, ListService listService);
	
}
