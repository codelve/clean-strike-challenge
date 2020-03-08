package  com.sahajsoft.beans;

public class CarromBoard {
	
	private int blackCoins;
	private int redCoins;
	
	{
		blackCoins = 9;
		redCoins = 1;
	}

	public int getBlackCoins() {
		return blackCoins;
	}

	public void addBlackCoins(int blackCoins) {
		this.blackCoins += blackCoins;
	}
	
	public void reduceBlackCoins(int blackCoins) {
		this.blackCoins -= blackCoins;
	}

	public int getRedCoins() {
		return redCoins;
	}

	public void addRedCoins(int redCoins) {
		this.redCoins += redCoins;
	}
	
	public void reduceRedCoins(int redCoins) {
		this.redCoins -= redCoins;
	}
	
	public boolean hasRedCoins() {
		return redCoins>0;
	}
	
	public boolean hasBlackCoins() {
		return blackCoins>0;
	}
	
	public boolean hasCoins() {
		return (hasBlackCoins() || hasRedCoins());
	}

}
