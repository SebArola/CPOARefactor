/**
 * 
 */
package com.codurance.training.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import Controler.CtrlTask;

/**
 * @author seb
 *
 */
public class ReadCMD {

    private final BufferedReader in;
    private final PrintWriter out;

    private long lastId = 0;
    private static final String QUIT = "quit";
    
	/**
	 * @param out2 
	 * @param in2 
	 * 
	 */
	public ReadCMD(BufferedReader reader, PrintWriter writer) {
		this.in = reader;
		this.out = writer;
	}

    public String run() {
            out.print("> ");
            out.flush();
            String command;
            try {
                command = in.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            
            return command;

    }


}
