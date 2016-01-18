/**
 * 
 */
package View;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.PrintWriter;

/**
 * @author Sébastien Arola, Tanguy Heller
 * 
 * This class read the input from the user.
 *
 */
public class ReadCMD {

	private final BufferedReader in;
	private final PrintWriter out;

	/**
	 * Constructor of ReadCMD. Initialize the to buffer.
	 * @param out2
	 * @param in2
	 * 
	 */
	public ReadCMD(BufferedReader reader, PrintWriter writer) {
		this.in = reader;
		this.out = writer;
	}

	/**
	 * Principal method. Use it to read the input from the user.
	 * @return the command enter
	 */
	public String run() {
		this.out.print("> ");
		this.out.flush();
		String command;
		try {
			command = this.in.readLine();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		return command;

	}

}
