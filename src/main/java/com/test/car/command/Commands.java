package com.test.car.command;

import com.test.car.exception.InvalidCarCommandException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class Commands {
    public static final String CMD_MOVE_FORWARD = "Forward";
    public static final String CMD_TURN_RIGHT = "Right";
    private static final List<Command> commands = new ArrayList<>(10);

    public static final Command MOVE_FORWARD = new MoveForwardCommand();
    public static final Command MOVE_BACK = new MoveBackCommand();
    public static final Command TURN_LEFT = new TurnLeftCommand();
    public static final Command TURN_RIGHT = new TurnRightCommand();
    public static final Command TURN_BACK = new TurnBackCommand();

    static {
        registerCommand(MOVE_FORWARD);
        registerCommand(MOVE_BACK);
        registerCommand(TURN_LEFT);
        registerCommand(TURN_RIGHT);
        registerCommand(TURN_BACK);
    }

    private static void registerCommand(Command cmd) {
        commands.add(cmd);
    }

    public static List<Command> getCommands() {
        return Collections.unmodifiableList(commands);
    }

    public static Command of(String command) throws InvalidCarCommandException {
        if (command == null) {
            throw new InvalidCarCommandException("null command");
        }
        String commandString = command.trim().toLowerCase(Locale.ROOT);
        if (commandString.isBlank()) {
            throw new InvalidCarCommandException("empty command");
        }

        return commands.stream()
                .filter(c -> c.getNameAlias().stream().anyMatch(commandString::equalsIgnoreCase)
                        || c.getName().equalsIgnoreCase(commandString))
                .findFirst()
                .orElseThrow(InvalidCarCommandException::new);
    }
}
