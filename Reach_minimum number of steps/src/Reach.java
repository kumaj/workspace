import java.util.ArrayList;

// Arrays
public class Reach {

    // X and Y co-ordinates of the points in order.
    // Each point is represented by (X.get(i), Y.get(i))
    public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
    	int len = X.size();
    	int steps = 0;
    	for(int i=0; i< len-1; i++) {
    		int x = Math.abs(X.get(i+1) - X.get(i));
    		int y = Math.abs(Y.get(i+1) - Y.get(i));
    		if(x > y) {
    			steps = steps + x;
    		} else
    			steps = steps + y;
    	}
    	return steps;
    }
}

class Solution {
	public static void main(String[] args) {
		Reach r = new Reach();
	}
}