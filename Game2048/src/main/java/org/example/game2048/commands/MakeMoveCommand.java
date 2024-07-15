package org.example.game2048.commands;

import org.example.game2048.controllers.GameController;
import org.example.game2048.models.Game;
import org.example.game2048.models.GameStatus;
import org.example.game2048.models.MoveDir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MakeMoveCommand implements Command{

    @Autowired
    GameController gameController;

    @Override
    public boolean matches(String input) {
        try{
            int moveDir = Integer.parseInt(input);
            if(moveDir<0 || moveDir>3) {
                System.out.println("Invalid Input");
                return false;
            }
            return true;
        } catch (Exception ex) {
            System.out.println("Invalid Input");
            return false;
        }
    }

    @Override
    public void execute(String input, Game game) {
        gameController.makeMove(MoveDir.values()[Integer.parseInt(input)],game);
    }
}
