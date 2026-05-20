package com.copMafia.model.entity.actions.copActions;

import java.util.List;

import com.copMafia.model.entity.Player;
import com.copMafia.model.entity.actions.IntegratedAction;
import com.copMafia.model.entity.actions.NightAction;
import com.copMafia.model.factory.ActionFactory;
import com.copMafia.model.service.ListService;
import com.copMafia.util.enums.CustodyResult;
import com.copMafia.util.enums.CustodyStatus;

public class Custody extends IntegratedAction{

	private CustodyResult result;

	private CustodyStatus status;

	private final Integer actionPrice = 0;

	private final Integer actionPrize = 10;

	private final Integer honour = 1;

	public Custody(Player cop, Player criminal, Integer nightCount) {
		super(cop, criminal, nightCount);
		this.setActionPrice(actionPrice);
		this.setActionPrize(actionPrize);
		this.setActionHonour(honour);
	}

	public Custody(){}

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

	@Override
	public NightAction execute(Player player, Player opponent, ActionFactory actionFactory) {
		return actionFactory.createCustody(player, opponent);
	}

	@Override
	public List<Player> getActionOpponents(Player player, ListService listService){
		return listService.copCustodyList(player);
	}

}
