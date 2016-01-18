/**
 * 
 */
package command;

/**
 * 
 * The command DeleteTask is called when the user write delete task <task id> <project name>.
 * Delete the task <task id>
 * @author Sébastien Arola, Tanguy Heller
 *
 */
public class Help implements Command{
	
	/**
	 * Default constructor provide an empty constructor to have a useless command object.
	 */
	public Help(){
		
	}
	
	/* (non-Javadoc)
	 * @see command.Command#man()
	 */
	@Override
	public void run(){
		  System.out.println("Commands:");
		  System.out.println("  view");
		  System.out.println("  add project <project name>");
		  System.out.println("  add task <project name> <task description>");
		  System.out.println("  check <task ID>");
		  System.out.println("  uncheck <task ID>");
		  System.out.println("  delete  project <project name>");
		  System.out.println("  delete  task <task ID> <project name>");
		  System.out.println("  deadlines <task id> <dd/mm/yyyy>");
		  System.out.println();
	}

	/* (non-Javadoc)
	 * @see command.Command#man()
	 */
	@Override
	public void man(String input) {
		System.out.println("Bad use of the command you wrote: " + input + "\nThe command must be : [add project <project name>]");	
	}
}
