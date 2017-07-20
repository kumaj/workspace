import java.util.ArrayList;


/**
 * Best Time to Buy and Sell Stock
 * @author kumaj04
 * Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 */
public class Stocks {
	//Working good
    public int maxProfit_mine(int[] prices) {
        
    	int len = prices.length;
    	if(len <= 1)
    		return 0;
    	int max_profit = 0;
    	int min = Integer.MAX_VALUE;
    	int max = Integer.MIN_VALUE;
    	
    	for(int i = 0; i < len ; i++) {
    		if(prices[i] < min) {
    			min = prices[i];
    			max = prices[i];
    		} else if(prices[i] > max)
    			max = prices[i];
    		
    		int diff = max - min; 
    		if(diff > max_profit)
    			max_profit = diff; 
    	}
    	return max_profit;
    }
    
    public int maxProfit_InterviewBit(ArrayList<Integer> prices) {
        
    	int len = prices.size();
    	if(len <= 1)
    		return 0;
    	int max_profit = 0;
    	int min = Integer.MAX_VALUE;
    	int max = Integer.MIN_VALUE;
    	
    	for(int i = 0; i < len ; i++) {
    		if(prices.get(i) < min) {
    			min = prices.get(i);
    			max = prices.get(i);
    		} else if(prices.get(i) > max)
    			max = prices.get(i);
    		
    		int diff = max - min; 
    		if(diff > max_profit)
    			max_profit = diff; 
    	}
    	return max_profit;
    }
    
    public int maxProfit(int[] prices) {
        int profit = 0;
        int minElement = Integer.MAX_VALUE;
        for(int i=0; i<prices.length; i++){
           profit = Math.max(profit, prices[i]-minElement);
           minElement = Math.min(minElement, prices[i]);
        }
        return profit;
    }
}

class Solution {
	public static void main(String[] args) {
		Stocks s = new Stocks();
		//int input[]={100, 180, 260, 310, 40, 535, 695}; // 655
		//int input[]= {1, 2, 1, 100}; // 99
		//int input[]= {2,1,2,0,1}; // 1
		//int input[]= {1, 2, 4}; // 3
		int input[]= {10,22,5,75,65,80}; //75
		System.out.println(s.maxProfit(input));
		System.out.println(s.maxProfit_mine(input));
	}
}
