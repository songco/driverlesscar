package com.test.car.command;

import java.util.Set;

public class TurnBackCommand extends MultiCommand {
    public TurnBackCommand() {
        super(Commands.TURN_RIGHT, Commands.TURN_RIGHT);
    }

    public Set<String> getNameAlias() {
        return Set.of("Turn Back");
    }

    @Override
    public String getName() {
        return "TurnBack";
    }

    @Override
    public String getDescription() {
        return "Turn car back";
    }
}
