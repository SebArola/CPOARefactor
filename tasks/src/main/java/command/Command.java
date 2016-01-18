/**
 * 
 */
package command;


/**
 * @author  Sebastien Arola, Tanguy Heller
 *	Provide method for all the command.
 */
public interface Command {
		/**
		 *  Launch the command.
		 */
		public void run(); 
		
		/**
		 * Return information about the common use of the command.
		 * @param input the command enter by the user.
		 */
		public void man(String input);
}
