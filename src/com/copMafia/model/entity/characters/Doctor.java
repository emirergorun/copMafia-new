package com.copMafia.model.entity.characters;

import com.copMafia.model.entity.actions.doctorActions.SaveVictim;

public class Doctor extends Character{

	private final Integer actionCount = 1;
	private Integer errorCount;
	private final Integer maxErrors = 3;
	private final Integer failureHonour = 1;

	SaveVictim saveVictim = new SaveVictim();

	public Doctor(){
		setIsBribable(true);
		setIsEvil(false);
		setIsJudge(false);
		getPossibleActions().add(saveVictim);
		setAvailableActionCount(actionCount);
	}

	public Integer getErrorCount(){
		return this.errorCount;
	}

	public void setErrorCount(Integer errorCount){
		this.errorCount = errorCount;
	}

	public Integer getMaxErrors(){
		return this.maxErrors;
	}

	public Integer getFailureHonour(){
		return this.failureHonour;
	}
	
}
