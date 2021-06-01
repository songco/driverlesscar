package com.test.car.command;

import com.test.car.exception.InvalidCarCommandException;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class Commands {
    public static final String CMD_MOVE_FORWARD = "MoveForward";
    public static final String CMD_TURN_RIGHT = "TurnRight";
    private static final Set<Command> commands = new HashSet<>();

    static {
        registerCommand(new MoveForwardCommand());
        registerCommand(new TurnRightCommand());
    }

    private static void registerCommand(Command cmd) {
        commands.add(cmd);
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
                .filter(c -> c.getNameAlias().stream().anyMatch(commandString::equalsIgnoreCase))
                .findFirst()
                .orElseThrow(InvalidCarCommandException::new);
    }
}
