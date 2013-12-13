package commands;

import java.util.List;

/**
 * Class for mapping command exit
 * @author marco
 *
 */
public class CommandExit extends AbstractCommand {

	public CommandExit(List<String> arguments) {
		super(arguments);
	}

	@Override
	public String execute() {
		return "bye";
	}

}
