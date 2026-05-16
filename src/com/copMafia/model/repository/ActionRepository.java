package com.copMafia.model.repository;

import java.util.List;

import com.copMafia.model.entity.actions.Action;

public class ActionRepository {
	
	private List<Action> MasterActionList;

	private List<Action> executedActionList;

	private List<Action> executedTempList;

	public List<Action> getMasterActionList(){
		return this.MasterActionList;
	}

	public List<Action> getExecutedActionList(){
		return this.executedActionList;
	}

	public List<Action> getExecutedTempList(){
		return this.executedTempList;
	}

}
