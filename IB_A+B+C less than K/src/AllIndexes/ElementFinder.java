package AllIndexes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

class Elmenets {
	private int i;
	private int j;
	
	public Elmenets(int a, int b) {
		this.i = a;
		this.j = b;
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public int getJ() {
		return j;
	}
	public void setJ(int j) {
		this.j = j;
	}
}
public class ElementFinder {
	public ArrayList<Integer> equal(ArrayList<Integer> a, int k) {
		//HashMap to store the sum and its corresponding elemets
		// In hash map we have to store the duplicates as well. So use linkedlist
		//when collison happens
		HashMap<Integer, LinkedList<Elmenets>> hashmap = new HashMap<Integer, LinkedList<Elmenets>>();
		int size = a.size();
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				int sum = a.get(i) + a.get(j);
				//If hashmap already have the sum, then add the new elements at the first location
				if(hashmap.containsKey(sum)) {
					LinkedList<Elmenets> node = hashmap.get(sum);
					node.addFirst(new Elmenets(a.get(i), a.get(j)));
					hashmap.put(sum, node);
				} else {
					LinkedList<Elmenets> ll = new LinkedList<Elmenets>();
					ll.add(new Elmenets(a.get(i), a.get(j)));
					hashmap.put(sum, ll);
				}
			}
		}
		//Sort the hashmap based upon key.
		Map<Integer, LinkedList<Elmenets>> sortedmap = new TreeMap<Integer, LinkedList<Elmenets>>(hashmap);
		
		//Iterate through the input array and find all the elements whose values is less than k-c
		for(int i =0; i< size; i++) {
			if(sortedmap.containsKey(k - a.get(i))) {
				
			}
		}
	}
}

class Solution {
	public static void main(String[] args) {
		
	}
}
