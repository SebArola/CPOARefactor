/**
 * 
 */
package Controler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import View.ReadCMD;

/**
 * @author Sébastien Arola, Tanguy Heller
 *	This class have the main which launch the application.
 */
public class Launcher {
	 private static final String QUIT = "quit"; 

	 /**
	  * 
	  * @param args
	  * @throws Exception
	  */
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        
        CtrlTask ctrl = new CtrlTask(); // Create a new CtrlTask. That's the only object link to the modele
        System.out.println("Welcome to aroller's project gesture\n");
        
        while(true){
        	String cmd =new ReadCMD(in, out).run(); //Take the command tape by the user
        	if(cmd.equals(QUIT)){
        		 break;
        	}
        	ctrl.run(cmd); //Run the cmd with CtrlTask
        }
    }
}
