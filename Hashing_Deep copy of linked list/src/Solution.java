/**
 * Driver class
 * @author kumaj04
 *
 */
public class Solution {
	public static void main(String[] args) {
		DeepCopy d = new DeepCopy();
		RandomListNode node1 = new RandomListNode(1);
		RandomListNode node2 = new RandomListNode(2);
		RandomListNode node3 = new RandomListNode(3);
		node1.next = node2;
		node2.next = node3;
		node1.random = node3;
		node2.random = node1;
		node3.random = node1;
		
		System.out.println(d.copyRandomList(node1));
	}
}
