package com.sahajsoft.beans.strike;

import com.sahajsoft.beans.Player;

public class NoStrike implements iStrike{
	
	public boolean isStrikePossible() {
		return true;
	}

	public void doStrike(Player player) {
		player.updateSuccessiveNoPocketCount();		
	}

	public iStrike createStrike() {
		return new NoStrike();
	}

}
