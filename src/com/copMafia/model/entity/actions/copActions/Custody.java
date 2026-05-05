package com.copMafia.model.entity.actions.copActions;

import com.copMafia.model.entity.Player;
import com.copMafia.model.entity.actions.Action;
import com.copMafia.util.enums.CustodyResult;
import com.copMafia.util.enums.CustodyStatus;

public class Custody extends Action{

	private Player criminal;

	private CustodyResult result;

	private CustodyStatus status;

	public Custody(Player player, Player criminal, Integer nightCount) {
		super(player, nightCount);
		this.criminal = criminal;
	}

	public Player getCriminal(){
		return this.criminal;
	}

	public CustodyResult getCustodyResult(){
		return this.result;
	}

	public void setCustodyResult(CustodyResult result){
		this.result = result;
	}

	public CustodyStatus getStatus(){
		return this.status;
	}

	public void setCustodyStatus(CustodyStatus status){
		this.status = status;
	}
	



}
