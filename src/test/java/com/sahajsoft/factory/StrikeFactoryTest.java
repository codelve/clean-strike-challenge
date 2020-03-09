package com.sahajsoft.factory;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.Test;

import com.sahajsoft.strike.iStrike;

public class StrikeFactoryTest {

	@Test
	public void givenNonNull_whenCreatesNonNullable_thenCorrect() {
		String strike = "Multistrike";
		Optional<iStrike> opt = StrikeFactory.createStrike(strike);
		assertTrue(opt.isPresent());
	}

	@Test(expected = NoSuchElementException.class)
	public void givenNull_whenThrowsErrorOnCreate_thenCorrect() {
		String strike = null;
		Optional<iStrike> opt = StrikeFactory.createStrike(strike);
		opt.get();
	}

	@Test
	public void givenNonNullWrong_whenCreatesEmpty_thenCorrect() {
		String strike = "Random Strike";
		Optional<iStrike> opt = StrikeFactory.createStrike(strike);
		assertFalse(opt.isPresent());
	}

}
