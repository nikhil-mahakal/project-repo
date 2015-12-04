package com.techlabs.tictactoe.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.techlabs.tictactoe.game.board.Board;
import com.techlabs.tictactoe.game.player.Player;
import com.techlabs.tictactoe.game.player.PlayerSignType;

public class GameRunner {

	private Player player1;
	private Player player2;
	private Board board;
	private static BufferedReader reader;

	boolean winner;
	Player currentPlayer;

	public GameRunner() {
		player1 = new Player();
		player2 = new Player();
		board = new Board();
		reader = new BufferedReader(new InputStreamReader(System.in));
	}

	private void setPlayersInfo() throws IOException {
		System.out.print("Enter player 1 name : ");
		player1.setName(reader.readLine());
		player1.setPlayerSign(PlayerSignType.X);

		System.out.print("Enter player 2 name : ");
		player2.setName(reader.readLine());
		player2.setPlayerSign(PlayerSignType.O);

	}

	public void startGame() throws IOException {
		setPlayersInfo();

		String wantToContinue = "Y";
		int noOfTurns;

		while (wantToContinue.equalsIgnoreCase("Y")) {

			board.initializeBlankBoard();
			winner = false;
			noOfTurns = 0;

			while (noOfTurns < 9 && !winner) {

				if (noOfTurns % 2 == 0) {
					currentPlayer = player1;
				} else {
					currentPlayer = player2;
				}

				System.out.println("\n" + currentPlayer.getName() + "'s turn");
				System.out
						.print("Please enter location to be marked in 'row-column' format : ");

				try {
					String[] tokens = (reader.readLine()).split("-");

					if (!board.setPlayerSignAtLocation(
							Integer.parseInt(tokens[0]),
							Integer.parseInt(tokens[1]),
							currentPlayer.getPlayerSign())) {
						System.out.println("This location is already marked.");
						System.out.println("Play again.");
					} else {
						noOfTurns++;
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out
							.println("please enter location in 'row-column' format/enter valid 'row-column' value");
					System.out.println("Play again.");
				} catch (NumberFormatException e) {
					System.out.println("please Enter Integer.");
					System.out.println("Play again.");
				} catch (Exception e) {
					System.out.println(e);
					System.out.println("Play again.");
				}

				if (board.checkWinForPlayerSign(currentPlayer.getPlayerSign())) {
					winner = true;
				}
				board.displayBoard();
			}

			displayWinOrDraw();

			System.out.println("Do you want to play again ? (Y/N)");
			wantToContinue = reader.readLine();
		}

		System.out.println("Thank You for Playing");
	}

	private void displayWinOrDraw() {

		System.out.println("------------------------------------------------");
		if (winner) {
			System.out.println(currentPlayer.getName() + " is Winner !!!");
			currentPlayer.setWinCount(currentPlayer.getWinCount() + 1);
		} else {
			System.out.println("out of moves. Draw !!!");
		}
		System.out.println("------------------------------------------------");
		System.out.println("!!! Score Board !!!");
		System.out.println(player1.getName() + "\t: " + player1.getWinCount()
				+ "\n" + player2.getName() + "\t: " + player2.getWinCount());
		System.out.println("------------------------------------------------");
	}

}
