/*
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * 
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
342 + 465 = 807
Make sure there are no trailing zeros in the output list
So, 7 -> 0 -> 8 -> 0 is not a valid response even though the value is still 807.
 */

package AddNum;

 class ListNode {
     public int val;
     public ListNode next;
     ListNode(int x) { val = x; next = null; }
 }

public class AddNum {

	//Insert the data
	public ListNode insert(ListNode head, int data) {
		if(head == null)
			head = new ListNode(data);
		else {
			ListNode curr = head;
			while(curr.next != null) {
				curr = curr.next;
			}
			//add the node at the end
			curr.next = new ListNode(data);
		}
		return head;	
	}
	
	//Display the data
	public void display(ListNode head) {
		ListNode curr = head;
		while(curr != null) {
			System.out.print(curr.val + " ");
			curr = curr.next;
		}
	}
	
	//add two list
	public ListNode addTwoNumbers(ListNode a, ListNode b) {
		ListNode curr1 = a;
		ListNode curr2 = b;
		
		int carr = 0;
		int sum = 0;
		int rem = 0;
		ListNode prev1 = null;
		ListNode prev2 = null;
		if(curr1 == null)
			return curr2;
		if(curr2 == null)
			return curr1;
		
		ListNode head = curr1;
		while(curr1 != null && curr2 != null) {
			sum = curr1.val + curr2.val + carr;
			rem = sum % 10;
			carr = sum / 10;
			curr1.val = rem;
			
			prev1 = curr1;
			curr1 = curr1.next;
			
			prev2 = curr2;
			curr2 = curr2.next;
		}
		
		//handle the remaing list
		if(curr1 == null) {
			prev2.next = null;
			prev1.next = curr2;
			while(curr2 != null) {
				sum = curr2.val + carr;
				rem = sum % 10;
				carr = sum / 10;
				curr2.val = rem;
				prev2 = curr2;
				curr2 = curr2.next;
			}
			if(carr > 0)
				prev2.next = new ListNode(carr);
		}
		else {
			while(curr1 != null) {
				sum = curr1.val + carr;
				rem = sum % 10;
				carr = sum / 10;
				curr1.val = rem;
				prev1 = curr1;
				curr1 = curr1.next;
			}
			if(carr > 0)
				prev2.next = new ListNode(carr);
		}
		return head;
	}
	/*
	 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

	You should preserve the original relative order of the nodes in each of the two partitions.

	For example,
	Given 1->4->3->2->5->2 and x = 3,
	return 1->2->2->4->3->5.
	 */
	 public ListNode partition(ListNode head, int x) {
	        if(head == null) return null;
	 
	        ListNode fakeHead1 = new ListNode(0);
	        ListNode fakeHead2 = new ListNode(0);
	        fakeHead1.next = head;
	 
	        ListNode p = head;
	        ListNode prev = fakeHead1;
	        ListNode p2 = fakeHead2;
	 
	        while(p != null){
	            if(p.val < x){
	                p = p.next;
	                prev = prev.next;
	            }else{
	 
	                p2.next = p;
	                prev.next = p.next;
	 
	                p = prev.next;
	                p2 = p2.next;
	            } 
	        }
	 
	        // close the list
	        p2.next = null;
	 
	        prev.next = fakeHead2.next;
	 
	        return fakeHead1.next;
	    }
	 
	 
		public ListNode swapPairs(ListNode a) {
			ListNode prev = null;
			if(a == null || a.next == null)
				return a;
			ListNode curr1 = a;
			ListNode curr2 = curr1.next;
			ListNode head = curr2; //this will be the head node
			
			while(curr1 != null && curr2 != null) {
				curr1.next = curr2.next;
				curr2.next = curr1;
				if(prev != null)
					prev.next = curr2;				
				//after swaping the elements the pointers also get swapped
				// c1,c2 becomes c2,c1. So change it again to c1 and c2
				ListNode temp = curr1;
				curr1 = curr2;
				curr2 = temp;
				//increment the counters by 2 steps
				prev = curr2;
				if(curr1.next != null)
					curr1 = curr1.next.next;
				if(curr2.next != null)
					curr2 = curr2.next.next;
			}
			return head;
		}
		
		//Reverse the linkList
		/*
		 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
		For example:
		Given 1->2->3->4->5->NULL, m = 2 and n = 4,
		return 1->4->3->2->5->NULL.
		 */
		public ListNode reverseBetween(ListNode a, int m, int n) {
			if(a == null || a.next == null || m==n)
				return a;
			ListNode head = a;
			int count = 1;
			ListNode mthNode = a;
			ListNode prevToMNode = null;
			
			//get to the mth node of the linkList
			// prevToMNode is used to hook the nth node and
			//mthNode will be hooked to n+1 node
			while(count < m)
			{
				prevToMNode = mthNode;
				mthNode = mthNode.next;
				count++;
			}
			
			//Normal reverse between m and n
			ListNode prev = null;
			ListNode temp = null;
			ListNode curr = mthNode;
			while( count <= n)
			{
				temp = curr;
				curr = curr.next;
				temp.next = prev;
				prev = temp;
				count++;
			}
			temp = curr;
			if(prevToMNode != null)
				prevToMNode.next = prev;
			mthNode.next = temp;
			return m > 1 ? head : prev;
		}
}

class Solution {
	public static void main(String[] args) {
		AddNum add = new AddNum();
		ListNode head1 = null;
		head1 = add.insert(head1, 2);
		head1 = add.insert(head1, 4);
		head1 = add.insert(head1, 3);
		
		ListNode head2 = null;
		head2 = add.insert(head2, 5);
		head2 = add.insert(head2, 6);
		head2 = add.insert(head2, 8);
		head2 = add.insert(head2, 9);
		
		add.display(head1);
		System.out.println("\n");
		add.display(head2);
		
		ListNode hh = add.addTwoNumbers(head1, head2);
		System.out.println("\n");
		add.display(hh);
		
		ListNode head3 = null;
		head3 = add.insert(head3, 1);
		head3 = add.insert(head3, 4);
		head3 = add.insert(head3, 3);
//		head3 = add.insert(head3, 0);
//		head3 = add.insert(head3, 5);
//		head3 = add.insert(head3, 2);
		
		ListNode hh3 = add.partition(head3, 3);
		System.out.println("\n");
		add.display(hh3);
		
		//swap the adjacent nodes of the link list
		ListNode hh4 = add.swapPairs(head3);
		System.out.println("\n");
		add.display(hh4);
		
		ListNode head5 = null;
		head5 = add.insert(head5, 1);
		head5 = add.insert(head5, 2);
		head5 = add.insert(head5, 3);
//		head5 = add.insert(head5, 4);
//		head5 = add.insert(head5, 5);
		
		//reverse the link list 
//		int m = 2;
//		int n = 4;
		
		int m = 1;
		int n = 2;
		ListNode hh5 = add.reverseBetween(head5, m, n);
		System.out.println("\nAfter reversing the linkList : ");
		add.display(hh5);
		
	}
}
