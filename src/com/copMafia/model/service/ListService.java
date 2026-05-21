package com.copMafia.model.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.copMafia.model.entity.Player;
import com.copMafia.model.entity.actions.NightAction;
import com.copMafia.model.entity.characters.Mafia;
import com.copMafia.model.repository.ActionRepository;
import com.copMafia.model.repository.PlayerRepository;

public class ListService {
	
	private final PlayerRepository playerRepo;
	private final ActionRepository actionRepo;

	public ListService(PlayerRepository playerRepo, ActionRepository actionRepo){
		this.playerRepo = playerRepo;
		this.actionRepo = actionRepo;
	}

	public ActionRepository getActionRepo(){
		return this.actionRepo;
	}

	public List<Player> getCurrentNonJudgeOpponents(Player player){
		List<Player> opponentList = new ArrayList<>();

		for (Player opponent : playerRepo.getMasterPlayerList()){
			if(opponent != player && !opponent.getCharacter().getIsJudge() && player.isAlive()){
				opponentList.add(opponent);
			}
		}
		return opponentList;
	}

	public List<Player> getCurrentNonJudgePlayers(){
		List<Player> playerList = new ArrayList<>();

		for (Player player : playerRepo.getMasterPlayerList()){
			if(!player.getCharacter().getIsJudge() && player.isAlive()){
				playerList.add(player);
			}
		}
		return playerList;
	}

	public Player getChosenOpponent(Player player, Integer input){
		List<Player> opponentList = getCurrentNonJudgeOpponents(player);
		return opponentList.get(input - 1);
	}

	public Player getSaveLifeVictim(Player doctor, Integer input){
		List<Player> doctorList = doctorSaveList(doctor);
		return doctorList.get(input - 1);
	}

	public List<Player> getPrisonList(){
		List<Player> prisonList = new ArrayList<>();

		for (Player player : playerRepo.getMasterPlayerList()){
			if(player.getInPrison()){
				prisonList.add(player);
			}
		}
		return prisonList;
	}

	public List<Player> getCourtList(){
		List<Player> courtList = new ArrayList<>();

		for (Player player : playerRepo.getMasterPlayerList()){
			if(player.getInCourt()){
				courtList.add(player);
			}
		}
		return courtList;
	}

	public List<Player> getCurrentPlayers(){
		List<Player> currentPlayers = new ArrayList<>();

		for (Player player : playerRepo.getMasterPlayerList()){
			if(!player.getInCourt() && !player.getInPrison() && !player.isAlive()){
				currentPlayers.add(player);
			}
		}
		return currentPlayers;
	}

	public List<Player> getDeadPlayers(){
		List<Player> deadPlayers = new ArrayList<>();

		for (Player player : playerRepo.getMasterPlayerList()){
			if(!player.isAlive()){
				deadPlayers.add(player);
			}
		}
		return deadPlayers;
	}

	public List<NightAction> getActionList(Player person){
		List<NightAction> actionList = new ArrayList<>();
		for (NightAction action : actionRepo.getMasterActionList()) {
			if(action.getPlayer().getCharacter().equals(person.getCharacter()))
				actionList.add(action);
		}
		return actionList;
	}

	public List<Player> mafiaSerialKillList(Player killer){ // mafya ve seri katilin öldürebileceği rakiplerin listesi
		return getCurrentNonJudgeOpponents(killer);
	}

	public List<Player> mafiaBribeList(Player mafia){
		List<Player> bribeList = new ArrayList<>();
		for (Player opponent : getCurrentNonJudgeOpponents(mafia)){
			if(!opponent.isTakenBribe())
				bribeList.add(opponent);
		}
		return bribeList;
	}

	public List<Player> doctorSaveList(Player doctor){
		List<Player> doctorList = new ArrayList<>();

		for (Player player : getCurrentNonJudgePlayers()){
			if(!player.isSavedLastRound()){
				doctorList.add(player);
			}
		}
		return doctorList;
	}

	public List<Player> copCustodyList(Player cop){
		return getCurrentNonJudgeOpponents(cop);
	}

	public List<Player> copInterrogationList(Player cop){
		return getCurrentNonJudgeOpponents(cop);
	}

	public List<Player> getMafiaPlayers(){
		List<Player> mafiaList = new ArrayList<>();
		for (Player player : getCurrentNonJudgePlayers()){
			if(player.getCharacter() instanceof Mafia){
				mafiaList.add(player);
			}
		}
		Collections.shuffle(mafiaList); // mafya listesini karıştırıp döndürüyoruz.
		return mafiaList;
	}

	public List<Player> informantList(Player informant){
		List<Player> informantList = new ArrayList<>();
		Player definiteMafia = getMafiaPlayers().get(0);
		informantList.add(definiteMafia);
		List<Player> tempList = getCurrentNonJudgeOpponents(informant);
		Collections.shuffle(tempList);
		int count = 0;
		while(count < 2){
			if(tempList.get(count) != definiteMafia){
				informantList.add(tempList.get(count));
				count++;
			}
		}
		return informantList;
	}

}
