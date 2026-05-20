package com.copMafia.model.repository;

import java.util.List;

import com.copMafia.model.entity.actions.NightAction;

public class ActionRepository {
	
	private List<NightAction> MasterActionList;

	private List<NightAction> executedActionList;

	private List<NightAction> executedTempList;

	public List<NightAction> getMasterActionList(){
		return this.MasterActionList;
	}

	public List<NightAction> getExecutedActionList(){
		return this.executedActionList;
	}

	public List<NightAction> getExecutedTempList(){
		return this.executedTempList;
	}

}
