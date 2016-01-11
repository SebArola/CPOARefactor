/**
 * 
 */
package command;

import java.util.ArrayList;

import Modele.Task;
import Modele.TaskMap;

/**
 * @author seb
 *
 */
public class AddProject extends Command{
	String proj ;
	TaskMap taskMap ;
	
	/**
	 * 
	 */
	public AddProject(String project, TaskMap tm) {
		proj = project;
		taskMap = tm;
	}

	/* (non-Javadoc)
	 * @see command.Command#run()
	 */
	@Override
	public void run() {
		taskMap.getTasks().put(proj, new ArrayList<Task>());
	}

}
