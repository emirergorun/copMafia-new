package com.copMafia.model.entity;

import com.copMafia.model.entity.characters.Character;

public class Player {

	private String name;

	private Character character;

	private Integer budget;

	private boolean savedLastRound;

	private boolean takenBribe;

	private boolean isAlive;

	private boolean inCourt;

	private boolean inPrison;

	private Integer honourLevel;

	public Player(String name, Character character){
		this.name = name;
		this.character = character;
		this.budget = character.getStartingBudget();
		this.savedLastRound = false;
		this.takenBribe = false;
		this.isAlive = true;
		this.inCourt = false;
		this.inPrison = false;
		this.honourLevel = character.getStartingHonour();
	}

	public String getName() {
    return name;
	}

	public Character getCharacter() {
		return character;
	}

	public Integer getBudget() {
		return budget;
	}

	public void setBudget(Integer budget) {
		this.budget = budget;
	}

	public boolean isSavedLastRound() {
		return savedLastRound;
	}

	public void setSavedLastRound(boolean savedLastRound) {
		this.savedLastRound = savedLastRound;
	}

	public boolean isTakenBribe() {
		return takenBribe;
	}

	public void setTakenBribe(boolean takenBribe) {
		this.takenBribe = takenBribe;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public boolean getInCourt(){
		return this.inCourt;
	}

	public void setInCourt(boolean inCourt){
		this.inCourt = inCourt;
	}

	public boolean getInPrison(){
		return this.inPrison;
	}

	public void setInPrison(boolean inPrison){
		this.inPrison = inPrison;
	}

	public Integer getHonourLevel(){
		return this.honourLevel;
	}

	public void setHonourLevel(Integer honourLevel){
		this.honourLevel = honourLevel;
	}
	
}
