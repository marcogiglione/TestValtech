package commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import persons.Message;
import persons.Person;


/**
 * Command for wall
 * @author marco
 *
 */
public class CommandWall extends AbstractCommand {

	public CommandWall(List<String> arguments) {
		super(arguments);
	}

	@Override
	public String execute() {
		StringBuffer sb = new StringBuffer();
		Person wall = daoPersons.getPersonByName(arguments.get(0));
		List<Message> complete=new ArrayList<Message>();
		complete.addAll(wall.getTimeline());
		for (Person person : wall.getFollowing()) {
			complete.addAll(person.getTimeline());
		}
		Collections.sort(complete);
		Date date = new Date();
		for (Message msg : complete) {
			sb.append(msg.getSender().getName()).append(" - ");
			sb.append(msg.prettyPrint(date));
		}
		return sb.toString();
	}

}
