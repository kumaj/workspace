import java.util.PriorityQueue;
import java.util.Queue;

/**
 * http://javarevisited.blogspot.in/2013/10/what-is-priorityqueue-data-structure-java-example-tutorial.html
 * how does java implement priority queue? 
i answered min heap, the interviewer seemed it was not right
 
 * @author kumaj04
 *
 */
public class Test {
	public static void main(String[] args) {
		Queue<Integer> queue = new PriorityQueue<Integer>();
		queue.add(10);
		queue.add(2);
		queue.add(1);
		
		System.out.println(queue);
		
	}
}
