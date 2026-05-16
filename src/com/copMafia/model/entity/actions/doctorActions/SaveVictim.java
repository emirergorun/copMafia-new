package com.copMafia.model.entity.actions.doctorActions;

import com.copMafia.model.entity.Player;
import com.copMafia.model.entity.actions.IntegratedAction;
import com.copMafia.util.enums.SaveVictimStatus;

public class SaveVictim extends IntegratedAction{
	
	private SaveVictimStatus status;

	private final String saveVictimActionMessage = "Bu gece kimin hayatını kurtarmak istiyorsun?";

	private final Integer actionPrice = 0;

	private final Integer actionPrize = 10;

	public SaveVictim(Player doctor, Player patient, Integer nightCount){
		super(doctor, patient, nightCount);
		this.setActionMessage(saveVictimActionMessage);
		this.setDecidable(false);
		this.setActionPrice(actionPrice);
		this.setActionPrize(actionPrize);
	}

	public SaveVictimStatus getStatus(){
		return this.status;
	}

	public void setStatus(SaveVictimStatus status){
		this.status = status;
	}

}
