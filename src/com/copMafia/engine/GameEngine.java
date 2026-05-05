package com.copMafia.engine;

public class GameEngine {

	private Integer nightCount;

	private Integer morningCount;

	public GameEngine(Integer nightCount, Integer morningCount){
		this.nightCount = nightCount;
		this.morningCount = morningCount;
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


	
}
