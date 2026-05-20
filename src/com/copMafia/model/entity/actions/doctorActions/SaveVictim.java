package com.copMafia.model.entity.actions.doctorActions;

import java.util.List;

import com.copMafia.model.entity.Player;
import com.copMafia.model.entity.actions.IntegratedAction;
import com.copMafia.model.entity.actions.NightAction;
import com.copMafia.model.factory.ActionFactory;
import com.copMafia.model.service.ListService;
import com.copMafia.util.enums.SaveVictimStatus;

public class SaveVictim extends IntegratedAction{
	
	private SaveVictimStatus status;

	private final String saveVictimActionMessage = "Bu gece kimin hayatını kurtarmak istiyorsun?";

	private final Integer actionPrice = 0;

	private final Integer actionPrize = 10;

	private final Integer actionHonour = 1;

	public SaveVictim(Player doctor, Player patient, Integer nightCount){
		super(doctor, patient, nightCount);
		this.setActionMessage(saveVictimActionMessage);
		this.setDecidable(false);
		this.setActionPrice(actionPrice);
		this.setActionPrize(actionPrize);
		this.setActionHonour(actionHonour);
	}

	public SaveVictim(){}

	public SaveVictimStatus getStatus(){
		return this.status;
	}

	public void setStatus(SaveVictimStatus status){
		this.status = status;
	}

	@Override
	public NightAction execute(Player doctor, Player opponent, ActionFactory actionFactory) {
		return actionFactory.createSaveVictim(doctor, opponent);
	}

	@Override
	public List<Player> getActionOpponents(Player doctor, ListService listService) {
		return listService.doctorSaveList(doctor);
	}

}
