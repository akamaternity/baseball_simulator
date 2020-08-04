package com.akamaternity.xlsx;

import java.util.List;

import net.java.amateras.xlsbeans.annotation.HorizontalRecords;
import net.java.amateras.xlsbeans.annotation.Sheet;

@Sheet(name = "選手一覧")
public class Players {
	private List<Player> players;

	@HorizontalRecords(tableLabel = "選手一覧", recordClass = Player.class)
	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public List<Player> getPlayers() {
		return players;
	}
}
