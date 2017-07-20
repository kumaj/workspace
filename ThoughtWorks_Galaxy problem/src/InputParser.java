import java.util.HashMap;

/**
 * Class to parse the user input
 * @author kumaj04
 *
 */
public class InputParser {
  static HashMap<String, String> map = new HashMap<String, String>();
  
  public void parserUserInput(String userInput) throws Exception {
	  //If the user input  contains the word 'how much' then it means  we have to calculate something. 
	  
	  //Check the last string. If it is I, V, X, L C, D, M 
	  String[] userInputArr;
	if(userInput.contains("I") || userInput.contains("V") || userInput.contains("X") || userInput.contains("L") || userInput.contains("C") || userInput.contains("D") || userInput.contains("M")) {
		userInputArr = userInput.split(" ");
		//It's length should be 3
		if(userInputArr.length == 3) {
			map.put(userInputArr[0], userInputArr[2]);
		} else 
			throw new Exception("I have no idea what you are talking about !!");
	} else if(userInput.contains("Credits")) {
		// split the user input based upon is
		userInputArr = userInput.split("is"); // glob glob silver is 34 credits
		if(user)
		
	}
  }
}
