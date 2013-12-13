package commands;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton factory class for parser commands This class is thread safe
 * 
 * 
 * @author marco
 * 
 */
public class CommandFactory {

	private static CommandFactory instance = null;

	private CommandFactory() {

	}

	/**
	 * Gets the instance of CommandFactory class
	 * 
	 * @return The instance
	 * 
	 */
	public static synchronized CommandFactory getInstance() {
		if (instance == null)
			instance = new CommandFactory();
		return instance;

	}

	/**
	 * Build method for command classes Supposing command are all well formed
	 * 
	 * @param command
	 *            The string containing information on commands to execute
	 * @return The Command implementation
	 */
	public AbstractCommand buildCommand(String command) {
		List<String> argsList = new ArrayList<>();
		AbstractCommand res;
		// Post
		if (command.contains("->")) {
			String[] args = command.split("->");
			argsList.add(args[0].trim());
			argsList.add(args[1].trim());
			res = new CommandPost(argsList);
		}
		// Follow
		else if (command.contains("follows")) {
			String[] args = command.split(" follows ");
			argsList.add(args[0].trim());
			argsList.add(args[1].trim());
			res = new CommandFollow(argsList);
		}// Wall
		else if (command.contains("wall")) {
			String[] args = command.split(" ");
			argsList.add(args[0].trim());
			res = new CommandWall(argsList);
		}// Exit
		else if(command.contains("exit")){
			argsList.add(command.trim());
			res = new CommandExit(argsList);
		}//Read
		else{
			argsList.add(command.trim());
			res = new CommandRead(argsList);
		}
		

		return res;
	}
}
