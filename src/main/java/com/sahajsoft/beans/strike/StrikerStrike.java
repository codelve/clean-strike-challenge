package com.sahajsoft.beans.strike;

import com.sahajsoft.beans.Player;

public class StrikerStrike implements iStrike {

	public boolean isStrikePossible() {
		return true;
	}

	public void doStrike(Player currentPlayer) {
		if(isStrikePossible()) {
			currentPlayer.decrementPointCount(1);	
			currentPlayer.updateFoulCount();
			currentPlayer.updateSuccessiveNoPocketCount();
		}		
	}

	public iStrike createStrike() {
		return new StrikerStrike();
	}

}
