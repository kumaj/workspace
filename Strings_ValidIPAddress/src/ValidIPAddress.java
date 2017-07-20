
public class ValidIPAddress {
	public int isValidIPAddress(String a) {
		//first split the string using its ":"
		if(a == null) 
			return 0;
		String[] address = a.split(":");
		//if array lenghth is less tha 4 then return false
		if(address.length != 4)
			return 0;
		//chrck if each part is in the range of 0 to 255
		for(int i = 0; i < address.length; i++) {
			if(Integer.parseInt(address[i]) >= 0 && Integer.parseInt(address[i]) <= 255)
				continue;
			else
				return 0;
		}
		return 1;
	}
}

class Solution {
	public static void main(String[] args) {
		ValidIPAddress v = new ValidIPAddress();
	}
}
