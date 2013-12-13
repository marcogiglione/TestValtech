package commands;

import java.util.List;

import dao.DaoPersons;

/**
 * Abstract class for mapping a generic command that executes and gets back a string
 * @author marco
 *
 */
public abstract class AbstractCommand {

	/**
	 * The list of arguments for this command
	 */
	protected List<String> arguments;

	protected DaoPersons daoPersons=DaoPersons.getInstance();
	
	/**
	 * 
	 * @param arguments Arguments list for the command
	 */
	public AbstractCommand(List<String> arguments){
		this.arguments=arguments;
	}
	
	/**
	 * Method to be called to execute the command
	 * @return String in output from the command
	 */
	public abstract String execute();

}
