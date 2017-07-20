package ModifyValues;

/*
 * Given a singly linked list, modify the value of first half nodes such that :

1st node’s new value = the last node’s value - first node’s current value
2nd node’s new value = the second last node’s value - 2nd node’s current value,
and so on …

NOTE : 
* If the length L of linked list is odd, then the first half implies at first floor(L/2) nodes. So, if L = 5, the first half refers to first 2 nodes. 
* If the length L of linked list is even, then the first half implies at first L/2 nodes. So, if L = 4, the first half refers to first 2 nodes.
Example :

Given linked list 1 -> 2 -> 3 -> 4 -> 5,

You should return 4 -> 2 -> 3 -> 4 -> 5
as

for first node, 5 - 1 = 4
for second node, 4 - 2 = 2
Try to solve the problem using constant extra space.
 */
class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
}

public class ModifyValues {

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
	
	//Logic is to reverse the 2nd half, then do the substraction and then get do the reverse of the 2nd half.
	public ListNode subtract(ListNode a) {
	
		//Use 2 pointers to reach to the middle of the linkList 
		if(a.next == null || a == null)
			return a;
		
		ListNode fast = a;
		ListNode slow = a;
		ListNode prev = null;
		
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			prev = slow;
			slow = slow.next;
		}
		
		//reverse the 2nd half of the linklist
		ListNode sndhalfhead = reverse(slow);
		//Now the 1st half to the 2nd half
		prev.next = sndhalfhead;
		
		ListNode hh = a;
//		ListNode scndHalfNode = slow; //don't use the slow think why. ???
		ListNode scndHalfPtr = sndhalfhead;
		while(hh != sndhalfhead) {
			  int temp = scndHalfPtr.val - hh.val;
			  hh.val = temp;
			  hh = hh.next;
			  scndHalfPtr = scndHalfPtr.next;
		}
		
		//again reverse the 2nd half.
		ListNode sndHalfhead2 = reverse(sndhalfhead);
		prev.next = sndHalfhead2;
		return a;
	}
	
	private ListNode reverse(ListNode head) {
		ListNode curr = head;
		ListNode prev = null;
		ListNode temp = null;
		
		while(curr != null) {
			temp = curr;
			curr = curr.next;
			temp.next = prev;
			prev = temp;
		}
		return temp;
	}
}
	
class Solution {
	public static void main(String[] args) {
		ModifyValues modify = new ModifyValues();
		ListNode head1 = null;
		head1 = modify.insert(head1, 1);
//		head1 = modify.insert(head1, 2);
//		head1 = modify.insert(head1, 3);
//		head1 = modify.insert(head1, 4);
//		head1 = modify.insert(head1, 5);
		
		
		ListNode head2 = null;
		head2 = modify.insert(head2, 5);
		head2 = modify.insert(head2, 6);
		head2 = modify.insert(head2, 8);
		head2 = modify.insert(head2, 9);
		
		modify.display(head1);
		System.out.println("\n");
		
		ListNode hh = modify.subtract(head1);
		System.out.println("\n");
		modify.display(hh);
	}
}
