import java.util.HashMap;

import org.w3c.dom.NodeList;

/**
 * 
 * @author kumaj04
 *
 */
class RandomListNode {
     int label;
     RandomListNode next, random;
     RandomListNode(int x) { this.label = x; }
};

public class DeepCopy {
	public RandomListNode copyRandomList(RandomListNode head) {
		//Traverse the link list and put the random node in the hashmap
		HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		RandomListNode curr = head;
		RandomListNode prev = null;
		RandomListNode newHead = null;
		
		while(curr != null) { //traverse till the end of the linked list
			//Now try to get the random pointer associated with the current node
			RandomListNode rand = curr.random;
			//store the curr and its random pointer in map, if there is no random pointer
			// then don't store it in map
			if(rand != null)
				map.put(curr, rand);
			
			RandomListNode newNode = new RandomListNode(curr.label);
			if(newHead == null)
				newHead = newNode;
			if(prev != null)
				prev.next = newNode;
			curr = curr.next;
			prev = newNode;
		}
		
		curr = newHead;
		//Now all the nodes get stored in map .. and create the random pointers		
		while(curr != null) {
			if(map.containsKey(curr)) {
				RandomListNode rand = map.get(curr);
				curr.random = rand;
			}
			curr = curr.next;	
		}
		return newHead;
    }
}
