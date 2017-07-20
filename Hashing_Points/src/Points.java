import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


/**
 * Definition for a point.
 * */
  class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
  }
 
public class Points {
    public int maxPoints(Point[] points) {
     //get the points one by one and calculate the slope
    	int len = points.length;
    	HashMap<Double, Integer> set = new HashMap<Double, Integer>(); //double is a primitive data type and HashMap cann't store it.
    	int originCount = 0;
    	boolean originFound = false;
    	
    	for(int i = 0; i<len; i++) {
    		Point pt = points[i];
    		double x = pt.x;
    		double y = pt.y;
    		double slope = 0;
    		if(x == 0 && y == 0) {
    			originCount++;
    			originFound = true;
    			continue;
    		}
    		else if(x == 0 && y!= 0)
    			slope = Integer.MAX_VALUE;
    		else
    			slope = y/x;
    		
    		if(set.containsKey(slope)) {
    			//get the existing count and increment it by 1 
    			int count = set.get(slope);
    			set.put(slope, ++count);
    		} else {
    			set.put(slope, 1);
    		}
    	} //for loop
    	
    	//Now iterate through the Map and find the max value for a slope
    	int max = 0;
    	for (Map.Entry<Double, Integer> entry : set.entrySet()) {
    		int val = entry.getValue();
			if(val > max)
				max = val;
		}
    	return originFound ? max+originCount : max;
    }
    
    //Interview Bit version
	public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
    	HashMap<Double, Integer> set = new HashMap<Double, Integer>(); //double is a primitive data type and HashMap cann't store it.
    	int originCount = 0;
    	boolean originFound = false;
    	
    	for(int i = 0; i<a.size(); i++) {
    		double x = a.get(i);
    		double y = b.get(i);
    		double slope = 0;
    		if(x == 0 && y == 0) {
    			originCount++;
    			originFound = true;
    			continue;
    		}
    		else if(x == 0 && y!= 0)
    			slope = Integer.MAX_VALUE;
    		else
    			slope = y/x;
    		
    		if(set.containsKey(slope)) {
    			//get the existing count and increment it by 1 
    			int count = set.get(slope);
    			set.put(slope, ++count);
    		} else {
    			set.put(slope, 1);
    		}
    	} //for loop
    	
    	//Now iterate through the Map and find the max value for a slope
    	int max = 0;
    	for (Map.Entry<Double, Integer> entry : set.entrySet()) {
    		int val = entry.getValue();
			if(val > max)
				max = val;
		}
    	return originFound ? max+originCount : max;
	}
	
	//Correct version
	public int maxPoints_03(ArrayList<Integer> a, ArrayList<Integer> b) {
	    if(b.size() == 0|| a.size() == 0) return 0;
	 
	    HashMap<Double, Integer> result = new HashMap<Double, Integer>();
	    int max=0;
	 
	    for(int i=0; i<a.size(); i++){
	        int duplicate = 1;//
	        int vertical = 0;
	        for(int j=i+1; j<a.size(); j++){
	            //handle duplicates and vertical
	            if(a.get(i) == a.get(j)){
	                if(b.get(i) == b.get(j)){
	                    duplicate++;
	                }else{
	                    vertical++;
	                }
	            }else{
	                double slope = b.get(j) == b.get(i) ? 0.0
					        : (1.0 * (b.get(j) - b.get(i)))
							/ (a.get(j) - a.get(i));
	 
	                if(result.get(slope) != null){
	                    result.put(slope, result.get(slope) + 1);
	                }else{
	                    result.put(slope, 1);
	                }
	            }
	        }
	 
	        for(Integer count: result.values()){
	            if(count+duplicate > max){
	                max = count+duplicate;
	            }
	        }
	 
	        max = Math.max(vertical + duplicate, max);
	        result.clear();
	    }
	 
	 
	    return max;
	}
}

class Solution {
	public static void main(String[] args) {
		Points p = new Points();
		
/*		Point p1 = new Point(1, 1);
		Point p2 = new Point(2, 2);
		Point p3 = new Point(6, 4);
		Point p4 = new Point(5, 6);
		
		Point[] points = {p1, p2, p3, p4};*/
		
		Point p1 = new Point(0, 0);
		Point p2 = new Point(1, 0);
		Point p3 = new Point(0, 1);
		
		Point[] points = {p1, p2, p3};
		
		System.out.println(p.maxPoints(points));
	}
}
