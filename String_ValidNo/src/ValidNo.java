/*
 * Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
A number is valid if :
1. pure No = +/-1234
2. Point No = +/-1.2, 0.2, 2.
3. Exponent No = +/-34e+/-43  
 */
public class ValidNo {
	
    boolean isNumber(String s) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        String s1 = s.trim(); //delete spaces in the front and end, don't delete the spaces in middle.
        if (s1.length() == 0){return false;} // if null string, return false;
        return valid(s1);
    }
    
    boolean valid(String s1){
    	char[] s = s1.toCharArray();
        int i=0;
        boolean e =false; // check if 'e' exists
        boolean dot=false; // check if '.' exists
        boolean dig =false;
         
        while (i<s.length-1){
            if (i==0){ // a number can start with +, -, .
                if (s[i]<'0' || s[i]>'9'){ // if is 0-9 continue
                    if (s[i]=='+' || s[i]=='-' || s[i]=='.'){
                        if (s.length==1){return false;} // only +, - , . is not a number
                        if (s[i]=='.'){dot=true;}
                    }
                    else {return false;}
                }else{dig=true;}
                i++;continue;
            }
            if (i>0){
                switch (s[i]){
                    case 'e': // e cannot follow +,-
                        if ( e==false && s[i-1]!='+' && s[i-1]!='-' && s[i-1]!='.' && dig && i!=s.length-1) {
                            e = true;
                        }else{
                            return false;
                        }
                        break;
                   case 'E': // e cannot follow +,-
                        if ( e==false && s[i-1]!='+' && s[i-1]!='-' && dig && i!=s.length-1) {
                            e = true;
                        }else{
                            return false;
                        }
                        break;
                   case '+': // + can only occur before e
                        if (s[i-1]=='e' || s[i-1]=='E'){}else{return false;}
                        break;
                   case '-': // - can only occur before e
                        if (s[i-1]=='e' || s[i-1]=='E'){}else{return false;}
                        break;
                   case '.': // . can only occur once and cannot occure after e
                        if (dot==false && e==false)
                        	{dot=true;}
                        else
                        	{return false;}
                        break;
                   default:  // only 0-9 can be valid numbers
                        if (s[i]<'0'||s[i]>'9'){return false;}
                        else{dig = true;}
                        break;
            } 
                i++;continue;
            }
        }
         
        //last dig can only be 0-9, or ., when it is . there is no . and e before
        if (s[s.length-1]>='0' && s[s.length-1]<='9'){return true;}
        if (s.length-2 >= 0 && s[s.length-1]=='.' && !dot && !e && s[s.length-2]>='0' && s[s.length-1]<='9') {return false;}        
        return false;
    }

	//Not working for some case like 0.
	   public boolean isNumber_02(String s) {
	        
		   // scan the character one by one
		   s = s.trim(); // " " -> false so trim the leading and trailing zeroes
		   s = s.replaceFirst("^0+(?!$)", "");
		   int i = 0;
		   int len = s.length();
		   int plus = 0;
		   int minus = 0;
		   int eCount = 0;
		   int dotCount = 0;
		   int maxPlusMinus = 1;
		   boolean efound = false;
		   boolean numFound = false; // e should always be prefix with integers
		   
		   if(len < 1)
			   return false;
		   
		   while(i < len) {
			   char ch = s.charAt(i);
			   
			   if(ch == '0' || ch == '1' || ch == '2' || ch == '3' || ch == '4' || ch == '5' || ch == '6' || ch == '7' || ch == '8' || ch == '9') {
				   if(efound == false)
					   numFound = true;
				   i++;
				   continue;
			   } else if(ch == '+') {
				   i++;
				   plus++;
				   if(plus > maxPlusMinus || i == len) // "+" false)
					   return false;
			   } else if(ch == '-') {
				   i++;
				   minus++;
				   if(minus > maxPlusMinus || i == len) // "-" false)
					   return false;
			   } else if(ch == ' ') { //space
				   i++;
			   } else if(ch == '.') { //example .12, 1.2, 12. otherwise return false
				   i++;
				   dotCount++;
				   if(dotCount > 1 || (i == len && numFound == false)) // "." false; 12. true
					   return false;
			   } else if(ch == 'e') {
				   i++;
				   efound = true;
				   eCount++;
				   maxPlusMinus++; // +/-34e+/-43  can have 2 + or -
				   if(eCount > 1)
					   return false;
				   if(numFound == false) // If e has been encountered without any integer prefix then it is not a no. But 0e is false
					   return false;
			   }
			   else
				   return false;
		   } //while
		   return true;
		   
	    } //method
}

class Solution {
	public static void main(String[] args) {
		ValidNo v = new ValidNo();
		//String s = "123e"; true -->123
		//String s = "e"; // false
		//String s = "e1"; // false
		//String s = "  "; //false
		//String s = "."; // false
		//String s = "+"; // false
		//String s = "-"; // false
		//String s = "1.2"; // true
		//String s = "12e+7"; // true
		//String s = "0e+7"; // false
		//String s = "0e"; //fasle
		//String s = "0.";
		//String s = "3.";
		String s = "1.e1";
		
		System.out.println(v.isNumber(s));
	}
}
