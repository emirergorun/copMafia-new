package com.copMafia.model.repository;

import java.util.ArrayList;

import com.copMafia.model.entity.Player;

public class PlayerRepository {

	private ArrayList<Player> MasterPlayerList;

	public ArrayList<Player> getMasterPlayerList(){
		return this.MasterPlayerList;
	}

}
