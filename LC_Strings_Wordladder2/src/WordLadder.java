import java.util.LinkedList;
import java.util.List;
import java.util.Set;


class WordNode {
	String wordNode;
	int numSteps;
	
	//Constructor to create the wordNode
	public WordNode(String wordNode, int numSteps) {
		this.wordNode = wordNode;
		this.numSteps = numSteps;
	}
}
public class WordLadder {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
    		//put the starting word into the queue
    		//We will use the BFS
    		LinkedList<WordNode> queue = new LinkedList<WordNode>();
    		queue.add(new WordNode(beginWord, 1));
    		
    		
    		
    }
}

class Solution {
	public static void main(String[] args) {
		
	}
}
