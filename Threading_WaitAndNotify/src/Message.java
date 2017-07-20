// http://www.journaldev.com/1037/java-thread-wait-notify-and-notifyall-example
/**
 * A java bean class on which threads will work and call wait and notify methods.
 * http://howtodoinjava.com/core-java/multi-threading/thread-synchronization-object-level-locking-and-class-level-locking/
 * @author kumaj04
 *
 */
public class Message {

	private String msg;
	
	public Message(String message) {
		this.setMsg(message);
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
