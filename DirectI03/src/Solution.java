
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution { 

private static class Node {
       Node left, right;
       int data;
       Node(int newData) {
           left = right = null;
           data = newData;
       }
}

static void treeDiameter(int[] values)
{
	//sort the array and create the BST
	Arrays.sort(values);
	Node rootNode = sortedArrayToBST(values);
	
	//once you get the root node get the diameter of the tree.
	int diameter = getDiameter(rootNode);
	System.out.println("Diameter.... : " + diameter);
	
}


private static int getDiameter(Node root) {        
    if (root == null)
        return 0;

    /* get the height of left and right sub-trees */
    int lheight = getHeight(root.left);
    int rheight = getHeight(root.right);
    
   // int rootDiameter = getHeight(root.left) + getHeight(root.right) + 1;
    int leftDiameter = getDiameter(root.left);
    int rightDiameter = getDiameter(root.right);

    return Math.max(lheight + rheight + 1, Math.max(leftDiameter, rightDiameter));
}

private static int getHeight(Node root) {
    if (root == null)
        return 0;

    return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
}

private static Node sortedArrayToBST(int[] num) {
	if (num.length == 0)
		return null;

	return createBST(num, 0, num.length - 1);
}

// Create the Binary search tree using the sorted array
private static Node createBST(int[] num, int start, int end) {
		if (start > end)
			return null;

		int mid = (start + end) / 2;
		Node root = new Node(num[mid]);
		root.left = createBST(num, start, mid - 1);
		root.right = createBST(num, mid + 1, end);
		return root;
}	

public static void main(String[] args)
{
	int[] array = {9,5,4,3,2,1,6,7,8,9};
	treeDiameter(array);
}
	

/////////////////////////////////////////////////////////



/* Write your custom functions here */
//static int diameterOfTree(Node root) {
/* For your reference
   class Node {
       Node left, right;
       int data;
               Node(int newData) {
           left = right = null;
           data = newData;
       }
   }
*/     
//}
}

