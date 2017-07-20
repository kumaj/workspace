import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ProcessBuilderDemo {
	
	   public static void main(String[] args) {
		   startNotePad();
	   }
	   
	   /**
	    * start the notepad
	 * @throws IOException 
	    */
	   private static void startNotePad(){
		   // create a new list of arguments for our process
			// Create ProcessBuilder.
			ProcessBuilder p = new ProcessBuilder();

			// Use command "notepad.exe" and open the file.
			ProcessBuilder a = p.command("notepad.exe", "C:\\eula.1028.txt");
			try {
				p.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      
		   // get the command list
		   System.out.println(""+p.command()); 
	   }
}
