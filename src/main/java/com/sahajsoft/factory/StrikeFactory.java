package com.sahajsoft.factory;

import java.util.HashMap;

import com.sahajsoft.strike.DefunctCoinStrike;
import com.sahajsoft.strike.MultiStrike;
import com.sahajsoft.strike.NoStrike;
import com.sahajsoft.strike.RedStrike;
import com.sahajsoft.strike.SingleStrike;
import com.sahajsoft.strike.StrikerStrike;
import com.sahajsoft.strike.iStrike;

public class StrikeFactory {
	private static final HashMap<String, iStrike> m_RegisteredStrikes = new HashMap<String, iStrike>();

	static {
		m_RegisteredStrikes.put("Defunct coin", new DefunctCoinStrike());
		m_RegisteredStrikes.put("Multistrike", new MultiStrike());
		m_RegisteredStrikes.put("None", new NoStrike());
		m_RegisteredStrikes.put("Red strike", new RedStrike());
		m_RegisteredStrikes.put("Strike", new SingleStrike());
		m_RegisteredStrikes.put("Striker strike", new StrikerStrike());
	}

	private StrikeFactory() {
	}

	public static void registerStrike(String strikeID, iStrike strikeClass) {
		m_RegisteredStrikes.put(strikeID, strikeClass);
	}

	public static iStrike createStrike(String strikeName) {
		iStrike strike = m_RegisteredStrikes.get(strikeName);
		return strike != null ? strike.createStrike() : null;
	}

}
