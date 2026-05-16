package com.copMafia.model.factory;

import com.copMafia.engine.GameEngine;
import com.copMafia.model.entity.Player;
import com.copMafia.model.entity.actions.Action;
import com.copMafia.model.entity.actions.KillAction;
import com.copMafia.model.entity.actions.copActions.Custody;
import com.copMafia.model.entity.actions.copActions.Interrogation;
import com.copMafia.model.entity.actions.doctorActions.SaveVictim;
import com.copMafia.model.entity.actions.mafiaActions.Bribe;
import com.copMafia.model.entity.actions.mafiaActions.MafiaKill;
import com.copMafia.model.entity.actions.serialKillerActions.SerialKill;
import com.copMafia.model.entity.characters.Mafia;
import com.copMafia.util.enums.InterrogationResult;

public class ActionFactory {

	private final GameEngine gameEngine;

	public ActionFactory(GameEngine gameEngine){
		this.gameEngine = gameEngine;
	}

	public KillAction createKillAction(Player killer, Player victim){
		if(killer.getCharacter() instanceof Mafia){
			return new MafiaKill(killer, victim, gameEngine.getNightCount());
		}else{
			return new SerialKill(killer, victim, gameEngine.getNightCount());
		}
	}

	public Bribe createBribe(Player mafia, Player opponent, String message){
		return new Bribe(mafia, opponent, message, gameEngine.getNightCount());
	}

	public SaveVictim createSaveVictim(Player doctor, Player victim){
		return new SaveVictim(doctor, victim, gameEngine.getNightCount());
	}

	public Custody createCustody(Player cop, Player suspect){
		return new Custody(cop, suspect, gameEngine.getNightCount());
	}

	public Interrogation createInterrogation(Player cop, Player criminal){
		Interrogation interrogation = new Interrogation(cop, criminal, gameEngine.getNightCount());
		if(criminal.getCharacter().getIsEvil()){
			interrogation.setResult(InterrogationResult.EVIL);
		}else{
			interrogation.setResult(InterrogationResult.GOOD);
		}
		return interrogation;
	}
	
}
