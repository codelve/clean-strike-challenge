package com.sahajsoft.strike;

import com.sahajsoft.beans.CarromBoard;
import com.sahajsoft.beans.Player;
import com.sahajsoft.constants.StrikePointConstant;
import com.sahajsoft.exception.InvalidStrikeException;
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
		return board.getBlackCoins() >= 2;
	}

	public void doStrike(Player currentPlayer) throws InvalidStrikeException {
		if (isStrikePossible()) {
			board.reduceBlackCoins(2);
			currentPlayer.setSuccessiveNoPocketCount(0);
			currentPlayer.incrementPointCount(StrikePointConstant.MULTISTRIKEPOINT.getPoint());
		} else {
			throw new InvalidStrikeException(String.format("Invalid Strike By %s", currentPlayer.getPlayerName()));
		}

	}

}
