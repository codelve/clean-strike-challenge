package com.sahajsoft.strike;

import com.sahajsoft.beans.Player;
import com.sahajsoft.exception.InvalidStrikeException;

public interface iStrike {

	iStrike createStrike();

	public boolean isStrikePossible();

	public void doStrike(Player player) throws InvalidStrikeException;

}
