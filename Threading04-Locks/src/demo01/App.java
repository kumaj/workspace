package demo01;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// create the object of the worker class 
		Worker wrk = new Worker();
		//wrk.doWork();

		for(int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(str);
/*		int x = sc.nextInt();
		int y = sc.nextInt();
		int p = sc.nextInt();
		int q = sc.nextInt();
		
		System.out.println(x + " " + y + " " + p + " " + " " + q);
	  	int result = countStep(x,y,p,q);
	  	System.out.println(result);*/
	}
	
  	private static int countStep(int x, int y, int p, int q) {
        if(x > p || y > q)
          return -1;
        int i = p-x;;
        int j = q - y;
        return i + j;
    }

}
