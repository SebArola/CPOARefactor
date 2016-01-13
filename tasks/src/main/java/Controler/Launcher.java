/**
 * 
 */
package Controler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import com.codurance.training.tasks.ReadCMD;

/**
 * @author seb
 *
 */
public class Launcher {
	 private static final String QUIT = "quit";

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        
        CtrlTask ctrl = new CtrlTask();
        System.out.println("Welcome to aroller's project gesture\n");
        
        while(true){
        	String cmd =new ReadCMD(in, out).run();
        	if(cmd.equals(QUIT)){
        		 break;
        	}
        	ctrl.run(cmd);
        }
    }
}
