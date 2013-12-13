package persons;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Class for mapping a Person
 * @author marco
 *
 */
public class Person {
	public List<Message> getTimeline() {
		return timeline;
	}

	/**
	 * Persons who follows this one
	 */
	private List<Person> followers = new ArrayList<>();

	/**
	 * Persons who this person follows
	 */
	private List<Person> following = new ArrayList<>();

	private String name;

	private List<Message> timeline = new ArrayList<>();

	public Person(String name) {
		super();
		this.name = name;
	}

	public boolean add(Message e) {
		return timeline.add(e);
	}

	public boolean addFollower(Person e) {
		return followers.add(e);
	}

	public boolean addFollowing(Person e) {
		return following.add(e);
	}

	@Override
	public boolean equals(Object obj) {
		return this.name.equals(((Person) obj).getName());
	}

	public List<Person> getFollowers() {
		return followers;
	}

	public List<Person> getFollowing() {
		return following;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		return this.name.hashCode();
	}

	public void setFollowers(List<Person> followers) {
		this.followers = followers;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer(this.getName()).append(">\n");
		Date date=new Date();
		for (Message msg : timeline) {
			sb.append(msg.prettyPrint(date));
		}
		return sb.toString();
	}
}
