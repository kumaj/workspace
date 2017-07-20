package heightOfATree;

public class TreeNode {
	public TreeNode lChild;
	public TreeNode rChild;
	public int data;
	
	//Method to insert to get the new node
	public TreeNode getNewNode(int value)
	{
		TreeNode newNode = new TreeNode();
		newNode.data = value;
		newNode.lChild = null;
		newNode.rChild = null;
		return newNode;
	}
}
