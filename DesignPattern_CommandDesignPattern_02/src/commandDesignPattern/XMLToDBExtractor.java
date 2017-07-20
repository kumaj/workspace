/**
 * 
 */
package commandDesignPattern;

/**
 * @author kumaj04
 *
 */
public class XMLToDBExtractor implements Extractor {

	@Override
	public void begin() {
		System.out.println("XML: loading the XML file..");
	}

	@Override
	public void execute() {
		System.out.println("XML:Executing the process...");
	}

	@Override
	public void end() {
		System.out.println("XMLToDB: Process completed successfully");
	}

}
