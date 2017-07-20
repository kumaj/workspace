import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MinJump {
	int minJumps(ArrayList<Integer> arr) {
		
		int size = arr.size();
		if(size == 0 || arr.get(0) == 0)
			return -1;
		
		ArrayList<Integer> jump = new ArrayList<Integer>();
		jump.add(0);
		
		for(int i = 1; i < size; i++) {
			jump.add(Integer.MAX_VALUE);
			for(int j = 0; j < i; j++) {
				if((arr.get(j)+j) >= i) {
					if(jump.get(i) > (jump.get(j) + 1)) {
						jump.set(i, (jump.get(j) + 1));
					}
				}
			}
		}
		if(jump.get(size - 1) < 0)
			return -1;
		else
			return jump.get(size - 1);
	}
	
    public int jump(ArrayList<Integer> a) {
        if (a.size() == 1) {
            return 0;
        }
        int count = 0;
        int i = 0;
        while (i + a.get(i) < a.size() - 1) {
            int maxVal = 0;
            int maxValIndex = 0;
            for (int j = 1; j <= a.get(i); j++) {
                if (a.get(j + i) + j > maxVal) {
                    maxVal = a.get(j + i) + j;
                    maxValIndex = i + j;
                }
            }
            i = maxValIndex;
            count++;
        }
        return count + 1;
    }
    
    //Leet code
    // Working good but time limit exceed
    public boolean canJump(int[] nums) {
        boolean isReachable = false;
        if(nums.length == 0)
        	return false;
        
        for(int i = 1; i< nums.length; i++) {
        	isReachable = false;
        	for(int j = 0; j < i; j++) {
        		if(j + nums[j] >= i) {
        			isReachable = true;
        			break;
        		}
        	}
        	if(isReachable == false)
        		return false;
        }
        return true;
    }
    
    // Time limit passed
    public boolean canJump_02(int[] nums) {
        boolean isReachable = false;
        int size = nums.length;
        if(size == 0)
        	return false;
        
        for(int i = size - 1; i >= 1; i--) {
        	isReachable = false;
        	for(int j = i - 1; j >= 0; j--) {
        		if(j + nums[j] >= i) {
        			isReachable = true;
        			break;
        		}
        	}
        	if(isReachable == false)
        		return false;
        }
        return true;
    }
    
    public int canJump_InterviewBit(ArrayList<Integer> a) {
        boolean isReachable = false;
        int size = a.size();
        if(size == 0)
        	return 0;
        
        for(int i = size - 1; i >= 1; i--) {
        	isReachable = false;
        	for(int j = i - 1; j >= 0; j--) {
        		if(j + a.get(j) >= i) {
        			isReachable = true;
        			break;
        		}
        	}
        	if(isReachable == false)
        		return 0;
        }
        return 1;
    }
}

class Solution {
	public static void main(String[] args) {
		MinJump m = new MinJump();
		Integer arr[] = {1, 3, 6, 1, 0, 9};
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1); a.add(0); a.add(6); a.add(1); a.add(0); a.add(9);
		System.out.println(m.minJumps(a));
	}
}
