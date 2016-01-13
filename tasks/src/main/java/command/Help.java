/**
 * 
 */
package command;

/**
 * @author seb
 *
 */
public class Help implements Command{
	public Help(){
		
	}
	
	public void run(){
		  System.out.println("Commands:");
		  System.out.println("  view");
		  System.out.println("  add project <project name>");
		  System.out.println("  add task <project name> <task description>");
		  System.out.println("  check <task ID>");
		  System.out.println("  uncheck <task ID>");
		  System.out.println("  delete  project <project name>");
		  System.out.println("  delete  task <task ID> <project name>");
		  System.out.println();
	}

	/* (non-Javadoc)
	 * @see command.Command#man()
	 */
	@Override
	public void man() {
		// TODO Auto-generated method stub
		
	}
}
