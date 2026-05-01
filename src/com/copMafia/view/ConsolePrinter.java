package com.copMafia.view;

import java.util.ArrayList;

import com.copMafia.model.entity.Player;
import com.copMafia.model.service.ListService;

public class ConsolePrinter {

	private final ListService listService;

	public ConsolePrinter(ListService listService){
		this.listService = listService;
	}
	
	public void printOpponents(Player player){
		ArrayList<Player> opponentList = listService.getOpponents(player);
		int i = 1;
		for (Player opponent : opponentList) {
			System.out.println(i + "- " + opponent.getName());
			i++;
		}
	}

	public void printList(ArrayList<Player> list){
		int i = 1;
		for (Player player : list) {
			System.out.println(i + "- " + player.getName());
			i++;
		}
	}

	public void output(String output){
		System.out.println(output);
	}

	public void errorOutput(String error){
		System.out.println(error);
	}

}
