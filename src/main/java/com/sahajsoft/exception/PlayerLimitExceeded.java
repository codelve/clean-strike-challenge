package com.sahajsoft.exception;

@SuppressWarnings("serial")
public class PlayerLimitExceeded extends Exception {
	public PlayerLimitExceeded(String message) {
		super(message);
	}
}
