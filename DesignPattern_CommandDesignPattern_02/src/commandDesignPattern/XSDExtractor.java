package commandDesignPattern;

public class XSDExtractor implements Extractor {

	@Override
	public void begin() {
		System.out.println("XSD:loading the XSD file");
	}

	@Override
	public void execute() {
		System.out.println("XSD:Executing the process...");
	}

	@Override
	public void end() {
		System.out.println("XSD: Process completed successfully");
	}

}
