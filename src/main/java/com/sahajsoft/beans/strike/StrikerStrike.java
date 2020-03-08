package com.sahajsoft.beans.strike;

import com.sahajsoft.beans.Player;
import com.sahajsoft.constants.StrikePointConstant;

public class StrikerStrike implements iStrike {

	public boolean isStrikePossible() {
		return true;
	}

	public void doStrike(Player currentPlayer) {
		if(isStrikePossible()) {
			currentPlayer.decrementPointCount(StrikePointConstant.STRIKERSTRIKEPOINT.getPoint());	
			currentPlayer.updateFoulCount();
			currentPlayer.updateSuccessiveNoPocketCount();
		}		
	}

	public iStrike createStrike() {
		return new StrikerStrike();
	}

}
