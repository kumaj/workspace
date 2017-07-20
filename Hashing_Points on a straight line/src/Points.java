import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;

/**
 * https://www.interviewbit.com/problems/points-on-the-straight-line/
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

Sample Input :

(1, 1)
(2, 2)
Sample Output :

2
You will be give 2 arrays X and Y. Each point is represented by (X[i], Y[i])
 * @author kumaj04
 *
 */

class Point{
	int x;
	int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class Points {
	public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
		if(a.size() == 0 || b.size() == 0)
			return 0;
		
		if(a.size() == 1 || b.size() == 1)
			return 1;
		
		//traverse the array and create the points.
		ArrayList<Point> arr = new ArrayList<Point>();
		int len = 0;
		while(len < a.size()) {
			Point p = new Point(a.get(len), b.get(len));
			arr.add(p);
			len++;
		}
		HashMap<Double, Integer> map = new HashMap<Double, Integer>();
		//Now calculate the slope of each point
		for(int i = 0; i<arr.size()-1; i++) {
			for(int j = i+1; j<arr.size(); j++) {
				Point p1 = arr.get(i);
				Point p2 = arr.get(j);
				int x = p1.x - p2.x;
				int y = p1.y - p2.y;

				if(x!= 0) {
					Double m = (double) (y/x);
					if(map.containsKey(m)) {
						int count = map.get(m);
						map.put(m, ++count);
					} else {
						map.put(m, 2);
					}
				} else {
					if(map.containsKey((double)Integer.MAX_VALUE)) {
						int count = map.get((double)Integer.MAX_VALUE);
						map.put((double) Integer.MAX_VALUE, ++count);
					} else {
						map.put((double) Integer.MAX_VALUE, 2);
					}
				}
				//handle duplicates
				if(p1.x == p2.x && p1.y == p2.y) {// overlapping/duplicate point 
					//System.out.println(j);
					if(j < b.size())
						b.remove(j);
				}
			} // inside for
		} // out for
		
		//now iterate the map and get the max value
		int max = Integer.MIN_VALUE;
		for(Map.Entry<Double, Integer> temp : map.entrySet()) {	
			if(temp.getValue() > max) {
				max = temp.getValue();
			}
		}
		return max;
	} // function
}

class Solution {
	public static void main(String[] args) {
		Points p = new Points();
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
/*		a.add(0); a.add(1); a.add(-1);
		b.add(0); b.add(1); b.add(-1);*/
		
		a.add(1); a.add(1); a.add(1); a.add(1); a.add(1); // handle duplicates
		b.add(1); b.add(1); b.add(1); b.add(1); b.add(1);
		
		System.out.println(p.maxPoints(a, b));
	}
}
