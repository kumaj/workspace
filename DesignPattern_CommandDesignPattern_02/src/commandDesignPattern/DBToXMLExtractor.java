package commandDesignPattern;

public class DBToXMLExtractor implements Extractor {

	@Override
	public void begin() {
		System.out.println("DBToXML:Initialising the DB..");
	}

	@Override
	public void execute() {
		System.out.println("DBToXML:Executing the process...");
	}

	@Override
	public void end() {
		System.out.println("DBToXML: Process completed successfully");
	}

}
