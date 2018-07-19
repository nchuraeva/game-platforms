package ru.springboot.project.service;

import ru.springboot.project.exception.IllegalCommandException;
import ru.springboot.project.game.objects.Game;

import java.text.MessageFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class GameService {

    private static final Set<String> ALLOWED_COMMANDS;

    final private static String helpMessage =
            "Allowed terminal commands:\n" +
                    "start - starts game\n" +
                    "stop - stops game\n" +
                    "hitme - one more card\n" +
                    "help - display this message";

    final private static String  defaultTemplate = "Command {0} received";
    static {
        Set<String> tmpSet = new HashSet<String>();
        tmpSet.add("play");
        tmpSet.add("stop");
        tmpSet.add("hitme");
        tmpSet.add("help");
        tmpSet.add("activiti$simpleOrdProcess");
        ALLOWED_COMMANDS = Collections.unmodifiableSet(tmpSet);
    }

    public String play(String command) {
        String response;
        if (!isLegalCommand(command)) {
            throw new IllegalCommandException(command);
        }

        Game game = new Game();
        game.setGameCountPlayers(1);
        switch (command) {
            case "help":
               response = helpMessage;
                break;
            case "start":
                response = game.start();
                break;
            case "stop":
                response = game.stop();
            case "hitme":
                response = game.hitMe();
            default:
                 response = MessageFormat.format(defaultTemplate, command);
                break;
        }

        return response;
    }

    private boolean isLegalCommand(String command) {
        for (String allowedCommand : ALLOWED_COMMANDS) {
            if (allowedCommand.equals(command)) {
                return true;
            }
        }
        return false;
    }

}
