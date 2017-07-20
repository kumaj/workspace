import java.util.ArrayList;

/**
 * 
 * @author kumaj04
 * Given an inorder traversal of a cartesian tree, construct the tree.

 Cartesian tree : is a heap ordered binary tree, where the root is greater than all the elements in the subtree. 
 Note: You may assume that duplicates do not exist in the tree. 
 */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }

public class CartesianTree {
    public TreeNode buildTree(ArrayList<Integer> a) {
    	//conevrt the arraylist into array
    	Integer [] arr = new Integer[a.size()];
    	a.toArray(arr);
    	return buildCartesianTree(arr, 0, a.size()-1);
    }

    private int findMax(Integer[] arr, int p, int r){
        
        int maxIndex = p;
        for(int i=p; i<=r; i++){
            
            if(arr[i] > arr[maxIndex]){
                
                maxIndex = i;
            }
        }
        return maxIndex;
    }		
    // http://www.personal.kent.edu/~rmuhamma/Algorithms/MyAlgorithms/Sorting/heapSort.htm
    //It's a bottom up approach to create a binary tree 
	private TreeNode buildCartesianTree(Integer[] arr, int p, int r) {
		if(r-p < 0) return null;
	    
	    if(r-p == 0) return new TreeNode(arr[p]);
		
		int q = findMax(arr, p, r);
		TreeNode lTree = buildCartesianTree(arr, p, q-1);
		TreeNode rTree = buildCartesianTree(arr, q+1, r);
		
		TreeNode root = new TreeNode(arr[q]);
		root.left = lTree;
		root.right = rTree;
		return root;
	}
	
	//Let's create the tree in top down approach
	private TreeNode buildCartesianTree_02(Integer[] arr, int p, int r) {
		if(r-p < 0) return null;
		
		if(r-p == 0) return new TreeNode(arr[p]);
		int max = findMax(arr, p, r);
		TreeNode root = new TreeNode(arr[max]);
		root.left = buildCartesianTree_02(arr, p, max-1);
		root.right = buildCartesianTree_02(arr, max+1, r);
		return root;
	}
}

class Solution {
	public static void main(String[] args) {
		CartesianTree ct = new CartesianTree();
		
		TreeNode root = new TreeNode(50);
		root.left = new TreeNode(40);
		root.left.left = new TreeNode(30);
		root.left.left.left = new TreeNode(20);
		root.right = new TreeNode(60);
		root.right.right = new TreeNode(70);
		root.right.right.right = new TreeNode(80);
		
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		a.add(3);
		System.out.println(ct.buildTree(a ));
	}
}
