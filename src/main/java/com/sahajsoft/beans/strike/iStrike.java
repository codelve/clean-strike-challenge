package com.sahajsoft.beans.strike;

import com.sahajsoft.beans.Player;

public interface iStrike {
	
	iStrike createStrike();
	
	public boolean isStrikePossible();
	
	public void doStrike(Player player);
	
}
