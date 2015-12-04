package com.techlabs.tictactoe.game.board;

import com.techlabs.tictactoe.game.player.PlayerSignType;

public class BoardPrinter {

	public void print(PlayerSignType[][] board) {

		int columnCount;
		
		System.out.println();
        for(PlayerSignType[] rows : board){
        columnCount=0;
            for(PlayerSignType cell : rows){
                
                if(cell==PlayerSignType.X){
                    System.out.print(" X ");
                }
                if(cell==PlayerSignType.O){
                    System.out.print(" O ");
                }
                if(cell==PlayerSignType.BLANK){
                    System.out.print("   ");
                }
                
                if(columnCount==0 || columnCount==1)
                    System.out.print("|");
                
                columnCount++;
            }
            System.out.println();
        }
	}

}
