package com.copMafia.model.entity.actions;

import java.util.List;

import com.copMafia.model.entity.Player;
import com.copMafia.model.service.ListService;

public interface ActionInterface {

	public List<Player> getActionOpponents(Player player, ListService listService);

}