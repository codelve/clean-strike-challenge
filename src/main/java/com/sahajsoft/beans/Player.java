package com.sahajsoft.beans;

import java.util.Queue;

public class Player {
	
	private String playerName;
	private int pointCount;
	private int foulCount;
	private int successiveNoPocketCount;
	private Queue<String> strikes;
	
	public Player(String playerName, Queue<String> strikes) {
		this.playerName = playerName;
		this.strikes = strikes;
		pointCount = 0;
		foulCount = 0;
		successiveNoPocketCount = 0;
	}

	
	public Queue<String> getStrikes() {
		return strikes;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getPointCount() {
		return pointCount;
	}

	public void setPointCount(int pointCount) {
		this.pointCount = pointCount;
	}
	
	public void incrementPointCount(int pointCount) {
		this.pointCount += pointCount;
	}

	public void decrementPointCount(int pointCount) {
		this.pointCount -= pointCount;
	}

	public int getFoulCount() {
		return foulCount;
	}

	public void setFoulCount(int foulCount) {
		this.foulCount = foulCount;
	}
	
	public void incrementFoulCount(int pointCount) {
		this.foulCount += pointCount;
	}

	public void decrementFoulCount(int pointCount) {
		this.foulCount -= pointCount;
	}

	public int getSuccessiveNoPocketCount() {
		return successiveNoPocketCount;
	}

	public void setSuccessiveNoPocketCount(int noPocketCount) {
		this.successiveNoPocketCount = noPocketCount;
	}
	
	public void incrementSuccessiveNoPocketCount(int pointCount) {
		this.successiveNoPocketCount += pointCount;
	}

	public void decrementSuccessiveNoPocketCount(int pointCount) {
		this.successiveNoPocketCount -= pointCount;
	}
	
	public void updateFoulCount() {
		this.incrementFoulCount(1);
		if(this.getFoulCount()>=2) {
			this.decrementPointCount(1);
		}
	}
	
	public void updateSuccessiveNoPocketCount() {
		this.incrementSuccessiveNoPocketCount(1);
		if(this.getSuccessiveNoPocketCount()>=2) {
			this.decrementPointCount(1);
			this.updateFoulCount();
		}
	}
	
}
