package persons;

import java.util.Date;

/**
 * Class for mapping a Message in the timeline
 * @author marco
 *
 */
public class Message implements Comparable<Message>{

	private String message;
	private Date time;
	private Person sender;

	public Person getSender() {
		return sender;
	}

	public void setSender(Person sender) {
		this.sender = sender;
	}

	public Message(Date time, Person sender,String message) {
		super();
		this.time = time;
		this.message = message;
		this.sender=sender;
	}

	public String getMessage() {
		return message;
	}

	public Date getTime() {
		return time;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public int compareTo(Message o) {
		return o.getTime().compareTo(this.time);
	}
	
	@Override
	public String toString() {
		return this.message;
	}
	
	/**
	 * Method for printing in pretty format
	 * @param actualDate
	 * @return
	 */
	public String prettyPrint(Date actualDate){
		StringBuffer sb=new StringBuffer();
		long msgTime = this.time.getTime();
		long seconds=(actualDate.getTime() - msgTime) / 1000;
		long minutes = seconds / 60;
		
		sb.append(this.message);
		sb.append("(").append(minutes!=0?(minutes+" minutes ago )"):(seconds+ " seconds ago )"));
		sb.append("\n");
		return sb.toString();
	}
	
}
