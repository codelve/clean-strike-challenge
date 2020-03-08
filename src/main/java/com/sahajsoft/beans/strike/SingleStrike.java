package com.sahajsoft.beans.strike;

import com.sahajsoft.beans.CarromBoard;
import com.sahajsoft.beans.Player;
import com.sahajsoft.game.CleanStrikeGame;

public class SingleStrike implements iStrike {
	
	static CarromBoard board;
	
	static {
		board = CleanStrikeGame.instance().getBoard();
	}

	public boolean isStrikePossible() {
		return board.hasBlackCoins();
	}

	public void doStrike(Player currentPlayer) {
		if(isStrikePossible()) {
			board.reduceBlackCoins(1);
			currentPlayer.setSuccessiveNoPocketCount(0);
			currentPlayer.incrementPointCount(1);
		}
		
	}

	public iStrike createStrike() {
		return new SingleStrike();
	}

}