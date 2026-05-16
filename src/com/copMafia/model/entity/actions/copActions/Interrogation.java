package com.copMafia.model.entity.actions.copActions;

import com.copMafia.model.entity.Player;
import com.copMafia.model.entity.actions.IntegratedAction;
import com.copMafia.util.enums.InterrogationResult;

public class Interrogation extends IntegratedAction{

	private InterrogationResult result;

	private final Integer actionPrice = 10;

	private final Integer actionPrize = 0;
	
	public Interrogation(Player cop, Player suspect, Integer nightCount) {
		super(cop, suspect, nightCount);
		this.setActionPrice(actionPrice);
		this.setActionPrize(actionPrize);
	}

	public InterrogationResult getResult(){
		return this.result;
	}

	public void setResult(InterrogationResult result){
		this.result = result;
	}

}
