package com.copMafia.model.entity.actions.copActions;

import com.copMafia.model.entity.Player;
import com.copMafia.model.entity.actions.IntegratedAction;
import com.copMafia.util.enums.CustodyResult;
import com.copMafia.util.enums.CustodyStatus;

public class Custody extends IntegratedAction{

	private CustodyResult result;

	private CustodyStatus status;

	private final Integer actionPrice = 0;

	private final Integer actionPrize = 10;

	public Custody(Player cop, Player criminal, Integer nightCount) {
		super(cop, criminal, nightCount);
		this.setActionPrice(actionPrice);
		this.setActionPrize(actionPrize);
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
