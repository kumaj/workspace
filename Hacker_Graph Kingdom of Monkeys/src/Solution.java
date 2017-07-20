import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is the driver class
 * @author kumaj04
 * https://www.hackerearth.com/practice/algorithms/graphs/depth-first-search/practice-problems/algorithm/kingdom-of-monkeys/
 * Input:
First line contains an integer T. T test cases follow. First line of each test case contains two space-separated N and M.
 M lines follow. Each of the M lines contains two integers Xi and Yi, the indexes of monkeys that perform the i'th ritual. 
 Last line of the testcase contains N space-separated integer constituting the array A.
 *SAMPLE INPUT 
1
4 3
1 2
2 3
3 1
1 2 3 5
 */
public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//Read the no of test cases
		int noOfTestCases = sc.nextInt();
		
		while(noOfTestCases > 0) {
			//Get the value of N and M
			int noOfMonkeys = sc.nextInt(); // it is the total no of nodes
			int noOfRituals = sc.nextInt(); // it represent the nodes which will connect with each other
			//Now get the ritual performed by monkeys and create the nodes
			Graph g = new Graph(noOfMonkeys);
			while(noOfRituals > 0) {
				int r1 = sc.nextInt();
				int r2 = sc.nextInt();
				Node n1 = new Node(r1);
				Node n2 = new Node(r2);
				g.addNode(n1);
				g.addNode(n2);
				g.connectNodes(r1, r2);
				noOfRituals--;
			}
			//now get the no of monkeys
			ArrayList<Integer> monkeysList = new ArrayList<Integer>();
			int num = sc.nextInt();
			monkeysList.add(num);
			
			noOfTestCases--;
		}
	}
}
