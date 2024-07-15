package org.example.game2048.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Game {
    private Player player;
    private int score;
    private boolean win2048;
    private Board board;
    private GameStatus gameStatus;
    private Bot bot;
    private Move move;

    public void makeMove(MoveDir moveDir) {
        Move move = new Move();
        score += move.makeMove(board,moveDir);
        checkBoard();
    }

    private void checkBoard(){
        if(board.contains2048()){
            win2048 = true;
            gameStatus = GameStatus.WON;
        }
        if(!board.isEmptyCellExists()){
            gameStatus = GameStatus.LOST;
        }
    }

    public void randomTileInsert() {
        bot.makeMove(board);
    }

    public void displayBoard() {
        board.displayBoard();
    }
}
