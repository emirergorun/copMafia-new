package com.copMafia.engine;

import com.copMafia.model.entity.actions.NightAction;
import com.copMafia.model.service.ListService;

public class GameEngine {

	private Integer nightCount;

	private Integer morningCount;

	private final ListService listService;

	public GameEngine(Integer nightCount, Integer morningCount, ListService listService){
		this.nightCount = nightCount;
		this.morningCount = morningCount;
		this.listService = listService;
	}

	public Integer getNightCount(){
		return this.nightCount;
	}

	public void setNightCount(Integer nightCount){
		this.nightCount = nightCount;
	}

	public Integer getMorningCount(){
		return this.morningCount;
	}

	public void setMorningCount(Integer morningCount){
		this.morningCount = morningCount;
	}

	public Integer getPlayerCount(){
		return this.listService.getCurrentNonJudgePlayers().size();
	}
	
}
