package org.example.game2048.controllers;

import org.example.game2048.models.*;
import org.springframework.stereotype.Controller;

@Controller
public class GameController {

    public Game startGame(int size,Player player){
        Game game = new Game();
        game.setBoard(new Board(size,2048));
        game.setGameStatus(GameStatus.ONGOING);
        game.setPlayer(player);
        game.setScore(0);
        game.setWin2048(false);
        game.setBot(new Bot());
        return game;
    }

    public GameStatus checkGameStatus(Game game) {
        return game.getGameStatus();
    }

    public void makeMove(MoveDir moveDir, Game game) {
        game.makeMove(moveDir);
    }

    public void randomTileInsert(Game game) {
        game.randomTileInsert();
    }

    public void displayBoard(Game game) {
        game.displayBoard();
    }

    public int getScore(Game game) {
        return game.getScore();
    }
}
