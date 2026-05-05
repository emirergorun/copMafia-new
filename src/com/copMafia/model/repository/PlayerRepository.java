package com.copMafia.model.repository;

import java.util.ArrayList;

import com.copMafia.model.entity.Player;

public class PlayerRepository {

	private ArrayList<Player> MasterList;

	public ArrayList<Player> getMasterList(){
		return this.MasterList;
	}

}
