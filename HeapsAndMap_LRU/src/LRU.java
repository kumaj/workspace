import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
/**
 * This solution is working fine and has been accepted.
 * https://www.interviewbit.com/problems/least-recently-used-cache/
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
	// Older item remains at the beginning of the list
	// Newer item remains at the end of the linked list
	LinkedList<Integer> linkedList;
	Map<Integer, Integer> map;
	int capacity;
    public LRU(int capacity) {
    	this.capacity = capacity;
        map = new HashMap<Integer, Integer>(capacity);
        linkedList = new LinkedList<Integer>();
    }
    
    // Return the value from the map
    public int get(int key) {
        if(map.containsKey(key)) {
        	//Remove the linked list element and put it at the end as newest item always remains at the end of linkedlist
        	linkedList.removeFirstOccurrence(key);
        	linkedList.add(key);
        	return map.get(key);
        }
        else
        	return -1;
    }
    
    // Set the value in the map.
    // Check if the map is full or not. If full then evict the old element
    public void set(int key, int value) {
        if(map.size() == capacity && !map.containsKey(key)) {
        	// then you have to remove the oldest item from the map.
        	// And linked list contains the oldest elemt at the beginning of it
        	int oldestKey = linkedList.remove();
        	map.remove(oldestKey);
        } 
        // if map is not full then insert the element into the map
    	map.put(key, value);
    	//check if the key is already present inside the key or not
    	if(linkedList.contains(key)) {
    		// then remove this key and put it at the end
    		linkedList.removeFirstOccurrence(key);
    		linkedList.add(key);
    	} else { // add the element to the end of the linked list
    		linkedList.add(key);
    	}
    
    }
}
