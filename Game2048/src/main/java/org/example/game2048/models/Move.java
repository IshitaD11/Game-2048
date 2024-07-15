package org.example.game2048.models;

import lombok.Getter;
import lombok.Setter;

public class Move {
    public int makeMove(Board board,MoveDir moveDir){
        if(moveDir.equals(MoveDir.Left))
            return moveLeft(board);
        else if(moveDir.equals(MoveDir.Right))
            return moveRight(board);
        else if(moveDir.equals(MoveDir.Top))
            return moveTop(board);
        else if(moveDir.equals(MoveDir.Bottom))
            return moveBottom(board);
        return 0;
    }

    public int moveLeft(Board board) {
        return board.moveLeft();
    }

    public int moveRight(Board board) {
        board.reverse();
        int score = moveLeft(board);
        board.reverse();
        return score;
    }

    public int moveTop(Board board) {
        board.transpose();
        int score = moveLeft(board);
        board.transpose();
        return score;
    }

    public int moveBottom(Board board) {
        board.transpose();
        int score = moveRight(board);
        board.transpose();
        return score;
    }
}
