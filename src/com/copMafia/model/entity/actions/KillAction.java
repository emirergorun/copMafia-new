package com.copMafia.model.entity.actions;

import java.util.List;

import com.copMafia.model.entity.Player;
import com.copMafia.model.service.ListService;
import com.copMafia.util.enums.KillStatus;
import com.copMafia.util.enums.KillerRole;

public abstract class KillAction extends IntegratedAction{
	
	private KillStatus status;

	private KillerRole killerRole;

	private final String killActionMessage = "Bu gece birini öldüreceksin.";

	private final Integer actionPrice = 0;

	private final Integer actionPrize = 10;

	private final Integer actionHonour = 1;

	public KillAction(Player killer, Player victim, Integer nightNumber){
		super(killer, victim, nightNumber);
		this.setActionMessage(killActionMessage);
		this.setDecidable(false);
		this.setActionPrice(actionPrice);
		this.setActionPrize(actionPrize);
		this.setActionHonour(actionHonour);
	}

	public KillAction(){}

	public KillStatus getStatus(){
		return this.status;
	}

	public void setStatus(KillStatus status){
		this.status = status;
	}

	public KillerRole getKillerRole(){
		return this.killerRole;
	}

	public void setKillerRole(KillerRole killerRole){
		this.killerRole = killerRole;
	}

	@Override
	public List<Player> getActionOpponents(Player player, ListService listService){
		return listService.mafiaSerialKillList(player);
	}

}
