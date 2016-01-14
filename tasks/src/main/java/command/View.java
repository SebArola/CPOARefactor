/**
 * 
 */
package command;

import java.util.List;
import java.util.Map;

import Modele.Project;
import Modele.Task;
import Modele.TaskMap;

/**
 * @author seb
 *
 */
public class View implements Command {

	TaskMap taskMap;
	/**
	 * 
	 */
	public View(TaskMap tm) {
		this.taskMap = tm;
	}

	/* (non-Javadoc)
	 * @see command.Command#run()
	 */
	@Override
	public void run() {
		
		 for (Map.Entry<Project, List<Task>> project : this.taskMap.getTasks().entrySet()) {
	            System.out.println(project.getKey().getpName());
	            for (Task task : project.getValue()) {
	            	System.out.printf("    [%c] %d: %s [%s]%n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription(), (task.getDeadLines().equals("0/0/0") ? "no deadline" : "Deadline :"+task.getDeadLines()));
	            }
	            System.out.println();
	        }
		
	}

	/* (non-Javadoc)
	 * @see command.Command#man()
	 */
	@Override
	public void man(String input) {
		System.out.println("Bad use of the command you wrote: " + input + "\nThe command must be : [add project <project name>]");	
	}

}
