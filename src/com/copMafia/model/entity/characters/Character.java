package com.copMafia.model.entity.characters;

import java.util.List;

import com.copMafia.model.entity.actions.NightAction;

public abstract class Character {

	private final Integer startingBudget = 20;
	private final Integer bribePrice = 20;
	private final Integer startingHonour = 2;

	private boolean isJudge;
	private boolean isBribable;
	private boolean isEvil;
	private List<NightAction> possibleActions;
	private Integer availableActionCount;

	public Character() {
		
	}

	public Integer getStartingBudget() {
		return startingBudget;
	}

	public Integer getBribePrice() {
		return bribePrice;
	}

	public Integer getStartingHonour(){
		return this.startingHonour;
	}

	public boolean getIsBribable() {
		return isBribable;
	}

	public void setIsBribable(boolean isBribable) {
		this.isBribable = isBribable;
	}

	public boolean getIsEvil() {
		return isEvil;
	}

	public void setIsEvil(boolean isEvil) {
		this.isEvil = isEvil;
	}

	public boolean getIsJudge(){
		return this.isJudge;
	}

	public void setIsJudge(boolean isJudge){
		this.isJudge = isJudge;
	}

	public List<NightAction> getPossibleActions(){
		return this.possibleActions;
	}

	public void setPossibleActions(List<NightAction> possibleActions){
		this.possibleActions = possibleActions;
	}

	public Integer getAvailableActionCount(){
		return this.availableActionCount;
	}

	public void setAvailableActionCount(Integer count){
		this.availableActionCount = count;
	}

}
