package commands;

import java.util.List;

import persons.Person;

/**
 * Command for reading messages
 * @author marco
 *
 */
public class CommandRead extends AbstractCommand {

	public CommandRead(List<String> arguments) {
		super(arguments);
	}
	
	@Override
	public String execute() {
		Person p = daoPersons.getPersonByName(super.arguments.get(0));
		return p.toString();
	}

	

}
