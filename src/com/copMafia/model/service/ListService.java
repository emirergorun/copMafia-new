package com.copMafia.model.service;

import java.util.ArrayList;
import java.util.List;

import com.copMafia.model.entity.Player;
import com.copMafia.model.repository.PlayerRepository;

public class ListService {
	
	private final PlayerRepository repo;

	public ListService(PlayerRepository repo){
		this.repo = repo;
	}

	public List<Player> getCurrentNonJudgeOpponents(Player player){
		List<Player> opponentList = new ArrayList<>();

		for (Player opponent : repo.getMasterList()){
			if(opponent != player && !opponent.getCharacter().getIsJudge() && player.isAlive()){
				opponentList.add(opponent);
			}
		}
		return opponentList;
	}

	public List<Player> getCurrentNonJudgePlayers(){
		List<Player> playerList = new ArrayList<>();

		for (Player player : repo.getMasterList()){
			if(!player.getCharacter().getIsJudge() && player.isAlive()){
				playerList.add(player);
			}
		}
		return playerList;
	}

	public List<Player> getDoctorChoicePlayers(Player doctor){
		List<Player> doctorList = new ArrayList<>();

		for (Player player : getCurrentNonJudgePlayers()){
			if(!player.isSavedLastRound()){
				doctorList.add(player);
			}
		}
		return doctorList;
	}

	public Player getChosenOpponent(Player player, Integer input){
		List<Player> opponentList = getCurrentNonJudgeOpponents(player);
		return opponentList.get(input - 1);
	}

	public Player getSaveLifeVictim(Player doctor, Integer input){
		List<Player> doctorList = getDoctorChoicePlayers(doctor);
		return doctorList.get(input - 1);
	}

	public List<Player> getPrisonList(){
		List<Player> prisonList = new ArrayList<>();

		for (Player player : repo.getMasterList()){
			if(player.getInPrison()){
				prisonList.add(player);
			}
		}
		return prisonList;
	}

	public List<Player> getCourtList(){
		List<Player> courtList = new ArrayList<>();

		for (Player player : repo.getMasterList()){
			if(player.getInCourt()){
				courtList.add(player);
			}
		}
		return courtList;
	}

	public List<Player> getCurrentPlayers(){
		List<Player> currentPlayers = new ArrayList<>();

		for (Player player : repo.getMasterList()){
			if(!player.getInCourt() && !player.getInPrison() && !player.isAlive()){
				currentPlayers.add(player);
			}
		}
		return currentPlayers;
	}

	public List<Player> getDeadPlayers(){
		List<Player> deadPlayers = new ArrayList<>();

		for (Player player : repo.getMasterList()){
			if(!player.isAlive()){
				deadPlayers.add(player);
			}
		}
		return deadPlayers;
	}

}
