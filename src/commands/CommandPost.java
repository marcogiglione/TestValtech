package commands;

import java.util.Date;
import java.util.List;

import persons.Message;
import persons.Person;

/**
 * Command for insertion of new messages
 * @author marco
 *
 */
public class CommandPost extends AbstractCommand {

	
	public CommandPost(List<String> arguments) {
		super(arguments);
	}
	
	
	@Override
	public String execute() {
		Person sender=daoPersons.getPersonByName(super.arguments.get(0));
		sender.add(new Message(new Date(), sender,super.arguments.get(1)));
		return "ok";
	}

	

}
