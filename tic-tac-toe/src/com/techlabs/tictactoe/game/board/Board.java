package com.techlabs.tictactoe.game.board;

import com.techlabs.tictactoe.game.player.PlayerSignType;

public class Board {

	private PlayerSignType[][] board;
	private BoardPrinter boardPrinter;

	public Board() {
		boardPrinter = new BoardPrinter();
	}

	public void initializeBlankBoard() {
		// initialize board.
		board = new PlayerSignType[3][3];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j]=PlayerSignType.BLANK;
			}	
		}

	}

	public boolean setPlayerSignAtLocation(int x, int y, PlayerSignType signType) {
		if (board[x][y] == PlayerSignType.BLANK) {
			board[x][y] = signType;
			return true;
		}
		return false;
	}

	public boolean checkWinForPlayerSign(PlayerSignType signType) {
		if ((board[0][0] == signType && board[0][1] == signType && board[0][2] == signType)
				|| (board[1][0] == signType && board[1][1] == signType && board[1][2] == signType)
				|| (board[2][0] == signType && board[2][1] == signType && board[2][2] == signType)
				||

				(board[0][0] == signType && board[1][0] == signType && board[2][0] == signType)
				|| (board[0][1] == signType && board[1][1] == signType && board[2][1] == signType)
				|| (board[0][2] == signType && board[1][2] == signType && board[2][2] == signType)
				||

				(board[0][0] == signType && board[1][1] == signType && board[2][2] == signType)
				|| (board[0][2] == signType && board[1][1] == signType && board[2][0] == signType)) {
			return true;
		}
		return false;
	}

	public void displayBoard() {
		boardPrinter.print(board);
	}
}
