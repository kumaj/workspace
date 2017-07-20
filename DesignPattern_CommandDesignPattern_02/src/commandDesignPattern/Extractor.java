/**
 * We are going to implement TDM Shredder in this example.
 */
package commandDesignPattern;

/**
 * @author kumaj04
 *
 */
public interface Extractor {

	public void begin();
	public void execute();
	public void end();
}
