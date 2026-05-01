package com.copMafia.model.service;

import java.util.ArrayList;

import com.copMafia.model.entity.Player;
import com.copMafia.model.repository.PlayerRepository;

public class ListService {
	
	private final PlayerRepository repo;

	public ListService(PlayerRepository repo){
		this.repo = repo;
	}

	public ArrayList<Player> getOpponents(Player player){
		ArrayList<Player> opponentList = new ArrayList<>();

		for (Player opponent : repo.getMasterList()){
			if(opponent != player && !opponent.getCharacter().getIsJudge()){
				opponentList.add(opponent);
			}
		}
		return opponentList;
	}

	public ArrayList<Player> getPrisonList(){
		ArrayList<Player> prisonList = new ArrayList<>();

		for (Player player : repo.getMasterList()){
			if(player.getInPrison()){
				prisonList.add(player);
			}
		}
		return prisonList;
	}

	public ArrayList<Player> getCourtList(){
		ArrayList<Player> courtList = new ArrayList<>();

		for (Player player : repo.getMasterList()){
			if(player.getInCourt()){
				courtList.add(player);
			}
		}
		return courtList;
	}

	public ArrayList<Player> getCurrentPlayers(){
		ArrayList<Player> currentPlayers = new ArrayList<>();

		for (Player player : repo.getMasterList()){
			if(!player.getInCourt() && !player.getInPrison() && !player.isAlive()){
				currentPlayers.add(player);
			}
		}
		return currentPlayers;
	}

	public ArrayList<Player> getDeadPlayers(){
		ArrayList<Player> deadPlayers = new ArrayList<>();

		for (Player player : repo.getMasterList()){
			if(!player.isAlive()){
				deadPlayers.add(player);
			}
		}
		return deadPlayers;
	}

}
