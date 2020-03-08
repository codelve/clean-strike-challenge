package com.sahajsoft.strike;

import com.sahajsoft.beans.Player;
import com.sahajsoft.constants.StrikePointConstant;
import com.sahajsoft.exception.InvalidStrikeException;

public class StrikerStrike implements iStrike {

	public boolean isStrikePossible() {
		return true;
	}

	public void doStrike(Player currentPlayer) throws InvalidStrikeException {
		if(isStrikePossible()) {
			currentPlayer.decrementPointCount(StrikePointConstant.STRIKERSTRIKEPOINT.getPoint());	
			currentPlayer.updateFoulCount();
			currentPlayer.updateSuccessiveNoPocketCount();
		} else {
			throw new InvalidStrikeException("Invalid  Strike");
		}
	}

	public iStrike createStrike() {
		return new StrikerStrike();
	}

}
