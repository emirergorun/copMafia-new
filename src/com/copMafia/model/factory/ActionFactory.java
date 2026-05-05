package com.copMafia.model.factory;

import com.copMafia.engine.GameEngine;
import com.copMafia.model.entity.Player;
import com.copMafia.model.entity.actions.Action;
import com.copMafia.model.entity.actions.KillAction;
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
		Integer nightCount = 1;
		if(killer.getCharacter() instanceof Mafia){
			return new MafiaKill(killer, victim, nightCount);
		}else{
			return new SerialKill(killer, victim, nightCount);
		}
	}

	public Bribe createBribe(Player mafia, Player opponent){
		Bribe bribe = new Bribe(mafia, opponent, gameEngine.getNightCount());
		return bribe;
	}

	public SaveVictim createSaveVictim(Player doctor, Player victim){
		SaveVictim saveVictim = new SaveVictim(doctor, victim, gameEngine.getNightCount());
		return saveVictim;
	}

	public Interrogation createInterrogation(Player cop, Player criminal){
		Interrogation interrogation = new Interrogation(cop, criminal, gameEngine.getNightCount());
		if(criminal.getCharacter().getIsEvil()){
			interrogation.setResult(InterrogationResult.BAD);
		}else{
			interrogation.setResult(InterrogationResult.GOOD);
		}
		return interrogation;
	}
	
}
