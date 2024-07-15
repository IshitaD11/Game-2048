package org.example.game2048.commands;

import org.example.game2048.models.Game;

public interface Command {
    boolean matches(String input);
    void execute(String input, Game game);
}
