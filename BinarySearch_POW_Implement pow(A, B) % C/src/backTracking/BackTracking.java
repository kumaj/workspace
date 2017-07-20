package backTracking;
/* BinarySearch :: POW
 * 
 * Implement pow(A, B) % C.
In other words, given A, B and C, 
find (AB)%C.

Input : A = 2, B = 3, C = 3
Return : 2 
2^3 % 3 = 8 % 3 = 2
A : -1
B : 1
C : 20
res: 19
 */
public class BackTracking {

	//The problem with this pproach is that it will overflow when 
	// a and b are large as shown in above example
	public int Mod(int a, int b, int c) {
		long result = 1 ;
		long count = 1 ;
		
		while(count <= b) {
			result = result * a;
			count++;
		}
		Long rem = result % c;
		return (int) ((rem >=0 )?rem : c+rem); // rem is less than 0 then add c to it.
	}
	
	//method 2 is the intelligent way
	// The approach is rather than calculating the pow of a, b
	// one a t a time and then dividing it by d. It's better to 
	// do in steps.
	public int pow(int x, int n, int d) {
		   int t = 1;
		   x = x % d;
		   for(int j = 0;j< n;j++)
		      {
		          t = (t*x)%d;
		       }
		   return t;
	}
	
//	public int getMod(int x, int y, int z){
//        if(y == 1)
//            return x%z;
//        int halfMod = ((getMod(x, y/2, z)%z) * getMod(x, y/2,z))%z;
//        if (y%2 == 0){
//            return halfMod;
//        }else {
//            return ((halfMod%z)*(x%z))%z;
//        }
//    }
	
//	int pow2(int x,int n,int m){
//		int c=x,d=n,r=1;
//		while(d>0){
//			if(d%2==1) r=(c*r)%m;
//			d/=2;
//			c=(c*c)%m;
//		}
//		return (int) ((r >=0 )?r : m+r);
//	}
	
	//The PowerMod method begins here
	//The PowerMod method begins here
	public  int  PowerMod(int a, int b, int m) {
	   long  tempo;
	  if (b ==0 ){
	   tempo =  1;  //EXIT condition
	   }//if
	  else  if (b == 1) tempo = a;
	        else { long temp = PowerMod(a,b/2,m);
	            if (b%2 == 0)
	               tempo = (temp*temp)%m;
	            else
	     		    tempo = ((temp*temp)%m)*a%m;
			   }
	    return (int) tempo;
	 } //POWERMOD method
	
	
	public int pow2(int x, int n, int d) {
		  int  tempo;
		  if (x ==0 ){
		   tempo = 0;  //EXIT condition
		   }//if
		   else if(n == 0)
		    tempo = 1;
		  else  if (n == 1) tempo = x;
		        else { int temp = pow(x,n/2,d);
		            if (n%2 == 0)
		               tempo = (temp*temp)%d;
		            else
		     		    tempo = ((temp*temp)%d)*x%d;
				   }
		   // return tempo;
		    return (int) ((tempo >=0 )?tempo : d+tempo);
		}
}

class solution {
	public static void main(String[] args) {
		BackTracking bc = new BackTracking();
//		int a = -1;
//		int b = 1;
//		int c = 20;
		
//		A : 71045970
//		B : 41535484
//		C : 64735492
//      out : 20805472
		
//		A : 79161127
//		B : 99046373
//		C : 57263970
//		out : 47168647
		
		int a = 71045970;
		int b = 41535484;
		int c = 64735492;
		
		System.out.println(bc.Mod(a, b, c));
		System.out.println(bc.pow(a, b,c));
		System.out.println(bc.PowerMod(a, b,c));
		System.out.println(bc.pow2(a, b,c));
	}
}
