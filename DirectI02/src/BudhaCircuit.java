import java.util.Arrays;
import java.util.Scanner;


public class BudhaCircuit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	      int no_of_racer;
	      float trackDistance;
	      String s;
	 
	      Scanner in = new Scanner(System.in);
	 
	      System.out.println("Enter no of racer participated in the race : ");
	      no_of_racer = in.nextInt();
	 
	      System.out.println("Enter distance of the track : ");
	      trackDistance = in.nextInt();
	 
	      //create an array to store the initial speed, acceleration and time taken by each participant
	      float[] initialSpeed = new float[no_of_racer];
	      float[] acc = new float[no_of_racer];
	      float[] timeTaken = new float[no_of_racer];
	      
	      for(int i = 0; i < no_of_racer; i++)
	      {
		      System.out.println("Enter initial speed of racer  : " + i+1);
		      initialSpeed[i] = in.nextFloat();
		      
		      System.out.println("Enter acceleration of racer  : " + i+1);
		      acc[i] = in.nextFloat();
		      
	      	 //Get the time taken by each participant using the below formula
		      // s = u*t + (a*pow(t,2))/2
		      timeTaken[i]=(float) ((-(initialSpeed[i])+ Math.sqrt( Math.pow(initialSpeed[i], 2) + (2*acc[i]*trackDistance) ))/acc[i]);
	      }
	      //get the minimum time
	      Arrays.sort(timeTaken);
	      System.out.println("Minimum time taken : " + timeTaken[0]);
	}

}

