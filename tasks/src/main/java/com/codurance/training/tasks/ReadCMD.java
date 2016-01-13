/**
 * 
 */
package com.codurance.training.tasks;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.PrintWriter;

/**
 * @author seb
 *
 */
public class ReadCMD {

	private final BufferedReader in;
	private final PrintWriter out;

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
