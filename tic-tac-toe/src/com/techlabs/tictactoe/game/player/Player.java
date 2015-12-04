package com.techlabs.tictactoe.game.player;

public class Player {

	private String name;
	private PlayerSignType playerSign;
	private int winCount;

	public Player() {

		winCount = 0;
	}
	public int getWinCount() {
		return winCount;
	}

	public void setWinCount(int winCount) {
		this.winCount = winCount;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPlayerSign(PlayerSignType playerSign) {
		this.playerSign = playerSign;
	}

	public String getName() {
		return name;
	}

	public PlayerSignType getPlayerSign() {
		return playerSign;
	}

}
