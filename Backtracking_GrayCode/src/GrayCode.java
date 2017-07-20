import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * The gray code is a binary numeral system where two successive values differ in only one bit.
Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
00 - 0
01 - 1
11 - 3
10 - 2
Note:
For a given n, a gray code sequence is not uniquely defined.
For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 */
public class GrayCode {
	//Working fine . Leet code version
    public List<Integer> grayCode_02(int n) {
        List<Integer> ret = new LinkedList<>();
        ret.add(0);
        for (int i = 0; i < n; i++) {
            int size = ret.size();
            for (int j = size - 1; j >= 0; j--)
                ret.add(ret.get(j) + size);
        }
        return ret;
    }
    
	public ArrayList<Integer> grayCode(int a) {
		
		ArrayList<Integer> ret = new ArrayList<Integer>();
        ret.add(0);
        for (int i = 0; i < a; i++) {
            int size = ret.size();
            for (int j = size - 1; j >= 0; j--)
                ret.add(ret.get(j) + size);
        }
        return ret;
	}
}

class Solution {
	public static void main(String[] args) {
		GrayCode g = new GrayCode();
		int n = 3;
		System.out.println(g.grayCode(3));
	}
}
