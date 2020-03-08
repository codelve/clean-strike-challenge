package com.sahajsoft.beans.strike;

import com.sahajsoft.beans.CarromBoard;
import com.sahajsoft.beans.Player;
import com.sahajsoft.game.CleanStrikeGame;

public class DefunctCoinStrike implements iStrike {
	
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
			currentPlayer.decrementPointCount(2);
			currentPlayer.updateFoulCount();
			currentPlayer.updateSuccessiveNoPocketCount();
		}
	}

	public iStrike createStrike() {
		return new DefunctCoinStrike();
	}

}
