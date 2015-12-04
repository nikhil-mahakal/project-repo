package com.techlabs.tictactoe.test;

import java.io.IOException;

import com.techlabs.tictactoe.game.GameRunner;

public class TicTacToeGameSimulation {
	public static void main(String[] args) throws IOException {

		GameRunner gameRunner = new GameRunner();
		gameRunner.startGame();
	}
}
