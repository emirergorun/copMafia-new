package com.copMafia.model.factory;

import com.copMafia.engine.GameEngine;
import com.copMafia.model.entity.Player;
import com.copMafia.model.entity.actions.NightAction;
import com.copMafia.model.entity.actions.bodyguardActions.Protect;
import com.copMafia.model.entity.actions.KillAction;
import com.copMafia.model.entity.actions.copActions.Custody;
import com.copMafia.model.entity.actions.copActions.Interrogation;
import com.copMafia.model.entity.actions.doctorActions.SaveVictim;
import com.copMafia.model.entity.actions.gamblerActions.Gamble;
import com.copMafia.model.entity.actions.informantActions.Inform;
import com.copMafia.model.entity.actions.journalistActions.Research;
import com.copMafia.model.entity.actions.lawyerActions.Bail;
import com.copMafia.model.entity.actions.mafiaActions.Bribe;
import com.copMafia.model.entity.actions.mafiaActions.MafiaKill;
import com.copMafia.model.entity.actions.serialKillerActions.SerialKill;
import com.copMafia.model.entity.characters.Mafia;
import com.copMafia.util.enums.InterrogationResult;
import com.copMafia.util.enums.ResearchResult;

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

	public Inform createInform(Player informant){
		return new Inform(informant, gameEngine.getNightCount());
	}

	public Bail createBail(Player lawyer, Player arrested){
		return new Bail(lawyer, arrested, gameEngine.getNightCount());
	}

	public Gamble createGamble(Player gambler, Player opponent){
		return new Gamble(gambler, opponent, gameEngine.getNightCount(), gameEngine.getPlayerCount());
	}

	public Protect createProtect(Player bodyguard, Player opponent){
		return new Protect(bodyguard, opponent, gameEngine.getNightCount());
	}

	public Research createResearch(Player journalist, Player opponent){
		Research research = new Research(journalist, opponent, gameEngine.getNightCount());
		if(opponent.getHonourLevel() < 2)
			research.setResearchResult(ResearchResult.LOW);
		else if(opponent.getHonourLevel() == 2)
			research.setResearchResult(ResearchResult.MEDIUM);
		else
			research.setResearchResult(ResearchResult.HIGH);

		return research;
	}
	
}
