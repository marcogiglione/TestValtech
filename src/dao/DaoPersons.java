package dao;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import persons.Person;

/**
 * A simple Singleton Dao for adding a person to the system Thread Safe class
 * 
 * @author marco
 * 
 */
public class DaoPersons {

	private static DaoPersons instance = null;

	private DaoPersons() {

	}

	/**
	 * Gets the instance of CommandFactory class
	 * 
	 * @return The instance
	 * 
	 */
	public static synchronized DaoPersons getInstance() {
		if (instance == null)
			instance = new DaoPersons();
		return instance;

	}

	/**
	 * A simple in memory map for storing persons Associate name to persons
	 * instance, we suppose name is unic in the system
	 */
	static Map<String, Person> persons = new ConcurrentHashMap<>();

	/**
	 * Retrieves a person by his name, if the person doesn't exist it creates a
	 * new one
	 * 
	 * @param name
	 *            The name of person to retrieve
	 * @return The person instance
	 */
	public Person getPersonByName(String name) {
		if (persons.get(name) == null)
			persons.put(name, new Person(name));
		return persons.get(name);
	}

	/**
	 * Add a person
	 * 
	 * @param The
	 *            person to add
	 * 
	 */
	public void addPerson(Person p) {
		persons.put(p.getName(), p);
	}

}
