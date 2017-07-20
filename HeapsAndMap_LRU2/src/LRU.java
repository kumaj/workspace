import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * This solution is also working fine.
 *  * https://www.interviewbit.com/problems/least-recently-used-cache/
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least recently used item before inserting the new item.
The LRUCache will be initialized with an integer corresponding to its capacity. Capacity indicates the maximum number of unique keys it can hold at a time.

Definition of “least recently used” : An access to an item is defined as a get or a set operation of the item. “Least recently used” item is the one with the oldest access time.

 NOTE: If you are using any global variables, make sure to clear them in the constructor. 
Example :

Input : 
         capacity = 2
         set(1, 10)
         set(5, 12)
         get(5)        returns 12
         get(1)        returns 10
         get(10)       returns -1
         set(6, 14)    this pushes out key = 5 as LRU is full. 
         get(5)        returns -1 
 * @author kumaj04
 *
 */
public class LRU {
	// Need a map to store the key value map
	// Linked list to store the key which track the newest and oldest keys.
	// Oldest key is at the end and newest key it at the start of linkedlist
	int capacity;
	LinkedList<Integer> linkedList;
	Map<Integer, Integer> map;
	
	public LRU(int capacity) {
		this.capacity = capacity;
		linkedList = new LinkedList<Integer>();
		map = new HashMap<Integer, Integer>(capacity);
	}
	
	public int get(int key) {
		if(map.containsKey(key)) {
			//remove the key from linked list and put it at first position
			linkedList.removeFirstOccurrence(key);
			linkedList.addFirst(key);
			return map.get(key);
		} else 
			return -1;
	}
	
	 public void set(int key, int value) {
		 // if the map is full then remove the oldest key which is at the end of the linked list
		 if(map.size() == capacity && !map.containsKey(key)) {
			 int oldestKey = linkedList.removeLast();
			 map.remove(oldestKey);
		 } 
		 map.put(key, value);
		 //this newly node will be placed at front of the linked list as newest reside at front
		 if(linkedList.contains(key)) {
			 linkedList.removeFirstOccurrence(key);
		 }
		 linkedList.addFirst(key);
	 }
}
