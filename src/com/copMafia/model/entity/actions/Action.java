package com.copMafia.model.entity.actions;

import com.copMafia.model.entity.Player;

public abstract class Action implements ActionInterface{

	private Player player;

	private Integer nightCount;

	private String actionMessage;

	private String decisionMessage;

	private String negativeDecisionMessage;

	private Boolean isDecidable;

	private Integer actionPrice;

	private Integer actionPrize;

	public Action(Player player, Integer nightCount){
		this.player = player;
		this.nightCount = nightCount;
	}

	public Action(){

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

	
	
}
