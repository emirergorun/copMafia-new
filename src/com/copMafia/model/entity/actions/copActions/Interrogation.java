package com.copMafia.model.entity.actions.copActions;

import com.copMafia.model.entity.Player;
import com.copMafia.model.entity.actions.Action;
import com.copMafia.util.enums.InterrogationResult;

public class Interrogation extends Action{

	private Player criminal;

	private InterrogationResult result;
	
	public Interrogation(Player player, Player criminal, Integer nightCount) {
		super(player, nightCount);
		this.criminal = criminal;
	}

	public Player getCriminal(){
		return this.criminal;
	}

	public InterrogationResult getResult(){
		return this.result;
	}

	public void setResult(InterrogationResult result){
		this.result = result;
	}

}
