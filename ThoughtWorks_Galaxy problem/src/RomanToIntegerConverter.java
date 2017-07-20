/**
 * 
 * @author kumaj04
 *
 */
public class RomanToIntegerConverter {
	
	public Integer convertRomanToInteger(String romanStr) {
		int sum = 0;
		int prev = 0;
		int curr = 0;
		for(int i = 0; i< romanStr.length(); i++) {
			char c = romanStr.charAt(i);
			
			switch (c) {
			case 'I':
				if(prev > curr)
					sum = sum - 1;
				else
					sum = sum + 1;
				prev = curr;
				break;
			case 'V':
				if(prev > curr)
					sum = sum - 5;
				else
					sum = sum + 5;
				prev = curr;
				break;
			case 'X':
				if(prev > curr)
					sum = sum - 10;
				else
					sum = sum + 10;
				prev = curr;
				break;
			case 'L':
				if(prev > curr)
					sum = sum - 50;
				else
					sum = sum + 50;
				prev = curr;
				break;
			case 'C':
				if(prev > curr)
					sum = sum - 100;
				else
					sum = sum + 100;
				prev = curr;
				break;
			case 'D':
				if(prev > curr)
					sum = sum - 500;
				else
					sum = sum + 500;
				prev = curr;
				break;
			case 'M':
				if(prev > curr)
					sum = sum - 1000;
				else
					sum = sum + 1000;
				prev = curr;
				break;
			default:
				break;
			}
		}
		return sum;
	}
}
