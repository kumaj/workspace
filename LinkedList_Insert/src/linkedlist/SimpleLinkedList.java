package linkedlist;

//create a class LinkedList
class Node {
	int data;
	Node next;
}

public class SimpleLinkedList {
	
	//Let's insert some data into the linked list
	public Node insert(Node head, int value) {
		if(head == null) {
			head = getNewNode(value);
		}
		else {
			Node curr = head;
			while(curr.next != null) {
				curr = curr.next;
			}
			//add the node at the end
			curr.next = getNewNode(value);
		}
		return head;
	}
	
	public void display(Node head) {
		//display all the nodes of the linked list
		
		Node curr = head;
		while(curr != null)
		{
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
	}
	/*
	 * Given a sorted linked list, delete all duplicates such that each element appear only once.
	 * For example,
	 * Given 1->1->2, return 1->2.
	 * Given 1->1->2->3->3, return 1->2->3.
	 */
	//remove duplicate link from the link list
	public Node deleteDuplicates(Node a) {
		Node curr = a;
		Node prev = null;
		while(curr != null)
		{
			prev = curr;
			curr = curr.next;
			while((curr != null ) && (prev.data == curr.data))
			{
				Node temp = curr;
				prev.next = curr.next;
				curr = curr.next;
				temp.next = null;
				
			}
		}
		return a;
	}
	
	/*
	 * This approach has created new node. Don't create new linklist
	 *  5 -> 8 -> 20 
  		4 -> 11 -> 15
  		4 -> 5 -> 8 -> 11 -> 15 -> 20
	 */
	public Node mergeTwoLists(Node a, Node b) {
		Node curr1 = a;
		Node curr2 = b;
		Node head = null;
		
		while(curr1 != null && curr2 != null) {
			if(curr1.data < curr2.data) {
				head = insert(head, curr1.data);
				curr1 = curr1.next;
			}
			else {
				head = insert(head, curr2.data);
				curr2 = curr2.next;
			}
		} //while
		
		if(curr1 != null) {
			while(curr1 != null) {
				head = insert(head, curr1.data);
				curr1 = curr1.next;
			}
		} //if
		else {
			head = insert(head, curr2.data);
			curr2 = curr2.next;
		}
		return head;
	}
	
	//create a new node
	private Node getNewNode(int value) {
		Node newNode = new Node();
		newNode.data = value;
		newNode.next = null;
		return newNode;
	}
}

class solution {
	public static void main(String[] args)
	{
		SimpleLinkedList ll = new SimpleLinkedList();
		Node head = null;
		head = ll.insert(head, 1);
		head = ll.insert(head, 1);
		head = ll.insert(head, 1);
		head = ll.insert(head, 2);
		head = ll.insert(head, 3);
//		head = ll.insert(head, 4);
//		head = ll.insert(head, 4);
//		head = ll.insert(head, 4);
//		head = ll.insert(head, 5);
//		head = ll.insert(head, 5);
		
		//display all the nodes of the ll
		ll.display(head);
		
		ll.deleteDuplicates(head);
		System.out.println("\nAfter removing the duplicates..");
		ll.display(head);
	}
}
