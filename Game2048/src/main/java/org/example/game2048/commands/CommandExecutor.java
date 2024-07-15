package org.example.game2048.commands;

import org.example.game2048.controllers.GameController;
import org.example.game2048.models.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandExecutor {

    private List<Command> commands;


    @Autowired
    public CommandExecutor(MakeMoveCommand makeMoveCommand){
        commands = new ArrayList<>();
        commands.add(makeMoveCommand);
    }


    public void execute(String input, Game game) {
        for(Command command:commands){
            if(command.matches(input))
                command.execute(input, game);
        }
    }
}
