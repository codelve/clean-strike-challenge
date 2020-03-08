package com.sahajsoft.beans.strike;

import com.sahajsoft.beans.CarromBoard;
import com.sahajsoft.beans.Player;
import com.sahajsoft.constants.StrikePointConstant;
import com.sahajsoft.game.CleanStrikeGame;

public class MultiStrike implements iStrike {
	static CarromBoard board;

	static {
		board = CleanStrikeGame.instance().getBoard();
	}

	public MultiStrike createStrike() {
		return new MultiStrike();
	}

	public boolean isStrikePossible() {
		return board.getBlackCoins()>=2;
	}

	public void doStrike(Player currentPlayer) {
		if(isStrikePossible()) {
			board.reduceBlackCoins(2);
			currentPlayer.setSuccessiveNoPocketCount(0);
			currentPlayer.incrementPointCount(StrikePointConstant.MULTISTRIKEPOINT.getPoint());
		}	

	}

}
