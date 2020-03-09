package com.sahajsoft.strike;

import com.sahajsoft.beans.CarromBoard;
import com.sahajsoft.beans.Player;
import com.sahajsoft.constants.StrikePointConstant;
import com.sahajsoft.exception.InvalidStrikeException;
import com.sahajsoft.game.CleanStrikeGame;

public class DefunctCoinStrike implements iStrike {
	
	static CarromBoard board;
	
	static {
		board = CleanStrikeGame.instance().getBoard();
	}

	public boolean isStrikePossible() {
		return board.hasBlackCoins();
	}

	public void doStrike(Player currentPlayer) throws InvalidStrikeException {
		if(isStrikePossible()) {
			board.reduceBlackCoins(1);
			currentPlayer.decrementPointCount(StrikePointConstant.DEFUNCTCOINSTRIKEFOULPOINT.getPoint());
			currentPlayer.updateFoulCount();
			currentPlayer.updateSuccessiveNoPocketCount();
		} else {
			throw new InvalidStrikeException(String.format("Invalid Strike By %s", currentPlayer.getPlayerName()));
		}
	}

	public iStrike createStrike() {
		return new DefunctCoinStrike();
	}

}
