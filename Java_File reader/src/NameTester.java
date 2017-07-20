import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author kumaj04
 *
 */
public class NameTester {
	
	public void getName(String filePath) throws IOException {
		try {
			FileReader freader = new FileReader(new File(filePath));
			BufferedReader br = new BufferedReader(freader);
			String line = null;
			try {
				while( (line = br.readLine()) != null) {
					System.out.println(line);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Can we do the same thing using the fileInputStreamReader
	 * @param filePath
	 * @throws IOException 
	 */
	public void getName_2(String filePath) throws IOException {
		try {
			FileInputStream fis = new FileInputStream(new File(filePath));		
			int content;
			while ((content = fis.read()) != -1) {
				// convert to char and display it
				System.out.print((char) content);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
