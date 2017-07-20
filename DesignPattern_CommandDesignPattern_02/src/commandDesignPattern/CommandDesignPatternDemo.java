package commandDesignPattern;

public class CommandDesignPatternDemo {

	public static void main(String[] args) {
		
		//Wrap the request as an Invoker object and call the invoker and it will 
		// redirect to the right class.
		XSDExtractor xsdextractor = new XSDExtractor();
		XMLToDBExtractor xmltodbextractor = new XMLToDBExtractor();
		DBToXMLExtractor dbtoxmlExtractor = new DBToXMLExtractor();
		
		Invoker invk = new Invoker();
		invk.addOption(xsdextractor);
		invk.addOption(xmltodbextractor);
		invk.addOption(dbtoxmlExtractor);
		
		invk.executeFlow();
	}
}
