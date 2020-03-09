package com.sahajsoft.constants;

public enum StrikePointConstant {
	SINGLESTRIKEPOINT(1),
	DEFUNCTCOINSTRIKEFOULPOINT(2),
	NOSTRIKEPOINT(0),
	MULTISTRIKEPOINT(2),
	REDSTRIKEPOINT(3),
	STRIKERSTRIKEPOINT(1),	
	MAXSUCCESSIVENOSTRIKECOUNT(3),
	MAXCONTINUOUSFOULCOUNT(3);
	
	private int point;
	
	public int getPoint() {
		return point;
	}

	public void setCount(int point) {
		this.point = point;
	}

	StrikePointConstant(int point) {
		this.point = point;
	}
}
