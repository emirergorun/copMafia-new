package com.copMafia.model.entity.actions.gamblerActions;

import java.util.List;

import com.copMafia.model.entity.Player;
import com.copMafia.model.entity.actions.IntegratedAction;
import com.copMafia.model.entity.actions.NightAction;
import com.copMafia.model.factory.ActionFactory;
import com.copMafia.model.service.ListService;
import com.copMafia.util.enums.GambleType;

public abstract class Gamble extends IntegratedAction{

	//kumarbaz'ın ödülü, oyuncu sayısı'nın 5 katına eşittir.
	private Integer multiplier; // oyuncu sayısına eşittir.
	private final Integer actionPrize = 5;
	private final Integer actionPrice = 10;
	private final Integer actionHonour = 0;

	private GambleType gambleType;

	public Gamble(){}

	public Gamble(Player gambler, Player opponent, Integer nightCount, Integer playerCount){
		super(gambler, opponent, nightCount);
		this.setActionHonour(actionHonour);
		// action message ayarlanacak
		this.setMultiplier(playerCount);
		this.setActionPrice(actionPrice);
		this.setActionPrize(actionPrize * multiplier);
		this.setDecidable(true);
		// decision message ayarlanacak
		// negative decision message ayarlanacak
	}

	public void setMultiplier(Integer multiplier){
		this.multiplier = multiplier;
	}

	public GambleType getGambleType(){
		return this.gambleType;
	}

	public void setGambleType(GambleType type){
		this.gambleType = type;
	}

	@Override
	public List<Player> getActionOpponents(Player gambler, ListService listService) {
		return listService.getCurrentNonJudgeOpponents(gambler);
	}
	
}
