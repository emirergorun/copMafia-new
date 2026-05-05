package com.copMafia.model.entity.actions.doctorActions;

import com.copMafia.model.entity.Player;
import com.copMafia.model.entity.actions.Action;
import com.copMafia.util.enums.SaveVictimStatus;

public class SaveVictim extends Action{
	
	private Player patient;

	private SaveVictimStatus status;

	public SaveVictim(Player doctor, Player patient, Integer nightCount){
		super(doctor, nightCount);
		this.patient = patient;
	}

	public Player getPatient(){
		return this.patient;
	}

	public SaveVictimStatus getStatus(){
		return this.status;
	}

	public void setStatus(SaveVictimStatus status){
		this.status = status;
	}

}
