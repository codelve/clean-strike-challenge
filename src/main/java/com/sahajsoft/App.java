package com.sahajsoft;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

import com.sahajsoft.exception.PlayerLimitExceeded;
import com.sahajsoft.game.CleanStrikeGame;

/**
 * Possible Strikes are: 
 * 1. Strike 
 * 2. Multistrike 
 * 3. Red strike 
 * 4. Striker strike 
 * 5. Defunct coin 
 * 6. None
 * 
 */
public class App {

	static CleanStrikeGame game = CleanStrikeGame.instance();

	public static void main(String[] args) throws IOException {
		registerPlayers();
		game.start();
		game.announceResult();
	}

	private static void registerPlayers() throws IOException {

		Queue<String> player1Moves = fileReader("moves/PlayerOne.txt");
		Queue<String> player2Moves = fileReader("moves/PlayerTwo.txt");

		try {
			game.registerPlayer("Player 1", player1Moves);
			game.registerPlayer("Player 2", player2Moves);
		} catch (PlayerLimitExceeded e) {
			System.out.println(e.getMessage());
		}

	}

	private static Queue<String> fileReader(String filePath) throws IOException {
		Queue<String> moves = new LinkedList<String>();

		ClassLoader classLoader = ClassLoader.getSystemClassLoader();

		try (FileInputStream inputStream = new FileInputStream(new File(classLoader.getResource(filePath).getFile()))) {

			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			String line;
			while ((line = reader.readLine()) != null) {
				moves.add(line);
			}

			reader.close();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return moves;
	}
}
