package commands;

import java.util.List;

import persons.Person;

/**
 * Command for follow
 * @author marco
 *
 */
public class CommandFollow extends AbstractCommand {


	
	public CommandFollow(List<String> arguments) {
		super(arguments);
	}
	
	@Override
	public String execute() {
		Person sender = daoPersons.getPersonByName(super.arguments.get(0));
		Person receiver = daoPersons.getPersonByName(super.arguments.get(1));
		receiver.addFollower(sender);
		sender.addFollowing(receiver);
		return "ok";
	}

}
