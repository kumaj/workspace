package Rearrange;

/*
 * Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space.

 Example:

 Input : [1, 0]
 Return : [0, 1]
 */
/*
 * 
 * https://www.quora.com/How-can-I-rearrange-a-given-array-so-that-Arr-I-becomes-Arr-Arr-I-with-O-1-extra-space
 * Consider
 a[]={4,2,0,1,3}

 i=0 a[i]=a[0]=4 ; a[a[i]]=a[4]=3
 i=1; a[i]=2; a[a[i]]=a[2]=0
 i=2; a[i]=0; a[a[i]]=a[0]=4
 i=3; a[i]=1; a[a[i]]=a[1]=2
 i=4; a[i]=3; a[a[i]]=a[3]=1;

 So o/p array is : a[]={3,0,4,2,1}

 for every index i in the array our goal is to transform
 a[i]------->a[a[i]]

 Now x % y is the remainder we get when x is divided by y
 for eg 1%5=1  10%5=0 13%3=1

 the solution to this problem consists of 2 steps:
 step 1: for(i=0 upto n-1)
 a[i]=a[i]+(a[a[i]]%n)*n

 what does this step do? let us see.

 1.0: a[0]=a[0]+(a[a[0]]%n)*n
 =4+(3%5)*5
 =4+3*5 =19
 =a[0]+a[a[0]]*n
 So the array now becomes {19,2,0,1,3}

 1.1: a[1]=a[1]+(a[a[1]]%n)*n
 =2+(0%5)*5
 =2+0*5 =2
 =a[1]+a[a[1]]*n
 So the array now becomes {19,2,0,1,3}

 1.2: a[2]=a[2]+(a[a[2]]%n)*n
 =0+(19%5)*5
 =0+((4+3*5)%5)*5
 =0+(( (4%5) + (3*5)%5 )*5   ((a+b)%c=a%c + b%c)
 =0+( 4+0)*5
 =0+ 4*5=20
 =a[2]+a[a[2]]*n   (note:Here a[a[2]] in this last line refers to the original value of a[a[2]] (which is 4) given in the input arr)

 So the array now becomes {19,2,20,1,3}

 1.3: a[3]=a[3]+(a[a[3]]%n)*n
 a[3]=1+(a[1]%n)*n
 a[3]=1+((2+0*5)%5)*5
 =1+2*5=11
 =a[3]+a[a[3]]*n

 So the array now becomes {19,2,20,11,3}

 1.4: a[4]=a[4]+(a[a[4]]%n)*n
 a[4]=3+(a[3]%5)*5
 =3+((1+2*5)%5)*5
 =3+1*5=8

 So the array now becomes {19,2,20,11,3}

 what did we do?
 initial arr is { 4,2,0,1,3}
 the current state of arr is { 4+3*5(=19), 2+0*5(=2), 0+4*5(=20), 1+2*5(=11),3+0*5(=3) }

 in essence for every index i in the array we have transformed 
 a[i]------->a[i] + a[a[i]]*n

 but remember our goal was to transform a[i]--->a[a[i]]
 How do we do this?
 We can do this by dividing each element of array by n(Step 2)

 a[i] + a[a[i]]*n     =    a[i]        +   a[a[i]]*n
 ___________        ____        _________
 n                             n                       n

 Now a[i] is a number between 0 to n-1. so, a[i] /n will be between 0 and 1
 Since we are doing integer division the answer will be truncated to 0.
 i.e a[i]/n=0;

 Also( a[a[i]]*n)/n =a[a[i]]

 So
 a[i] + a[a[i]]*n     =    a[i]        +   a[a[i]]*n          =  0 +a[a[i]] =a[a[i]]
 ___________        ____        _________
 n                             n                       n
 Hope this helps :)

 */
import java.util.ArrayList;

public class Rearrange {
	public void arrange(ArrayList<Integer> a) {
		int n = a.size();
		if (n == 0 || n == 1)
			return;
		// 1) Increase every Array element Arr[i] by (Arr[Arr[i]] % n)*n.
		// 2) Divide every element by N.
		for (int i = 0; i < n; i++) {
			int k = a.get(i) + (a.get(a.get(i)) % n) * n;
			a.set(i, k);
		}
		for (int i = 0; i < n; i++) {
			a.set(i, a.get(i)/n);	
		}
	}
}

class Solution {
	public static void main(String[] args) {
		Rearrange re = new Rearrange();
		ArrayList<Integer> arr = new ArrayList<Integer>();
	//	arr.add(1); arr.add(0);
		// {3,0,4,2,1}
		arr.add(3); arr.add(0); arr.add(4); arr.add(2); arr.add(1);
		re.arrange(arr);
		System.out.println(arr);
	}
}
