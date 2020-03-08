package com.sahajsoft.beans.strike;

import com.sahajsoft.beans.CarromBoard;
import com.sahajsoft.beans.Player;
import com.sahajsoft.game.CleanStrikeGame;

public class RedStrike implements iStrike {
	
	static CarromBoard board;
	
	static {
		board = CleanStrikeGame.instance().getBoard();
	}

	public boolean isStrikePossible() {
		return board.hasRedCoins();
	}

	public void doStrike(Player currentPlayer) {
		if(isStrikePossible()) {
			board.reduceRedCoins(1);
			currentPlayer.setSuccessiveNoPocketCount(0);
			currentPlayer.incrementPointCount(3);
		}		
	}

	public iStrike createStrike() {
		return new RedStrike();
	}

}