import java.util.Scanner;


public class Arithmetic {
	   int power(int n, int p) throws Exception {
	        if(n < 0 || p < 0) {
	            throw new Exception("n and p should be non-negative");
	        }
	          
	        return (p == 0) ? 1 : n*power(n,p-1);
	    }
}

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		while(in.hasNext())
		{
            //Get one line at a time (a b)
			String input = in.nextLine();
            // Now split (a b) based on space between them
            String[] res = input.split(" ");
            int a  = Integer.parseInt(res[0]);
            int b  = Integer.parseInt(res[1]);
            
            Arithmetic cal = new Arithmetic();
            try {
                int result = cal.power(a, b);
                System.out.println(result);
            } catch(Exception ex) {
                System.out.println(ex.getMessage());
            }
		}
    }
}
