package com.sahajsoft.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

import com.sahajsoft.beans.CarromBoard;
import com.sahajsoft.beans.Player;
import com.sahajsoft.constants.GameStatus;
import com.sahajsoft.exception.InvalidStrikeException;
import com.sahajsoft.exception.PlayerLimitExceeded;
import com.sahajsoft.exception.UnfairMovesException;
import com.sahajsoft.factory.StrikeFactory;
import com.sahajsoft.strike.iStrike;

public class CleanStrikeGame {

	private final int maxPlayerCount = 2;
	private static CleanStrikeGame instance;
	private List<Player> playersList = new ArrayList<Player>();
	private String gameStatus;
	private CarromBoard board;

	public CarromBoard getBoard() {
		return board;
	}

	private CleanStrikeGame() {
		board = new CarromBoard();
	}

	public static CleanStrikeGame instance() {
		if (instance == null) {
			synchronized (CleanStrikeGame.class) {
				if (instance == null) {
					instance = new CleanStrikeGame();
				}
			}
		}

		return instance;
	}

	/**
	 * register players with moves to play the game
	 */
	public void registerPlayer(String name, Queue<String> moves) throws PlayerLimitExceeded {
		if (playersList.size() == maxPlayerCount) {
			throw new PlayerLimitExceeded("Players Limit Exceeded");
		}
		playersList.add(new Player(name, moves));
	}

	public void play() throws UnfairMovesException, InvalidStrikeException {
		gameStatus = GameStatus.InProgress.toString();
		while (board.hasCoins()) {
			for (Player player : playersList) {
				if (board.hasCoins()) {
					String outcome = player.getStrikes().poll();
					if (outcome == null) {
						gameStatus = GameStatus.Draw.toString();
						return;
					}
					
					Optional<iStrike> strike = StrikeFactory.createStrike(outcome);
					if(strike.isPresent())
						strike.get().doStrike(player);
					else
						throw new InvalidStrikeException(String.format("Invalid Strike By %s", player.getPlayerName()));
					
					if (hasWinner()) {
						gameStatus = GameStatus.Won.toString();
						return;
					}
				}
			}
		}
		gameStatus = GameStatus.Draw.toString();
		return;
	}

	private boolean hasWinner() {
		Player first = playersList.get(0);
		Player second = playersList.get(1);
		return (first.getPointCount() >= 5 || second.getPointCount() >= 5)
				&& (Math.abs(first.getPointCount()) - second.getPointCount()) >= 3;
	}

	public void announceResult() {
		if (gameStatus.equals(GameStatus.Draw.toString()))
			System.out.println("Game is draw");
		else if (gameStatus.equals(GameStatus.Won.toString())) {
			Player first = playersList.get(0);
			Player second = playersList.get(1);
			System.out.print(String.format("%s Won the game. ",
					first.getPointCount() > second.getPointCount() ? first.getPlayerName() : second.getPlayerName()));
			System.out.println(String.format("Final score is %s - %s", first.getPointCount(), second.getPointCount()));

		}
	}

}
