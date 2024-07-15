package org.example.game2048;

import org.example.game2048.commands.CommandExecutor;
import org.example.game2048.controllers.GameController;
import org.example.game2048.models.Game;
import org.example.game2048.models.GameStatus;
import org.example.game2048.models.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Game2048Application implements CommandLineRunner {
	private Scanner sc = new Scanner(System.in);

	@Autowired
	private CommandExecutor commandExecutor;

	@Autowired
	private GameController gameController;

	public static void main(String[] args) {
		SpringApplication.run(Game2048Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Game game = gameController.startGame(4,new Player());
		while(gameController.checkGameStatus(game).equals(GameStatus.ONGOING)){
			gameController.randomTileInsert(game);
			System.out.println("Current Score: " + game.getScore());
			System.out.println("Current Board");
			gameController.displayBoard(game);
			String input = sc.nextLine();
			commandExecutor.execute(input,game);
		}

		if(gameController.checkGameStatus(game).equals(GameStatus.WON)){
			System.out.println("You Won!");
			System.out.println("Score: " + gameController.getScore(game));
		}
		else{
			System.out.println("Game Over!");
			System.out.println("Highest Score: " + gameController.getScore(game));
		}

	}
}
