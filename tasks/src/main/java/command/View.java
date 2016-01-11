/**
 * 
 */
package command;

import java.util.List;
import java.util.Map;

import Modele.Task;
import Modele.TaskMap;

/**
 * @author seb
 *
 */
public class View extends Command {

	TaskMap taskMap;
	/**
	 * 
	 */
	public View(TaskMap tm) {
		taskMap = tm;
	}

	/* (non-Javadoc)
	 * @see command.Command#run()
	 */
	@Override
	public void run() {
		
		 for (Map.Entry<String, List<Task>> project : taskMap.getTasks().entrySet()) {
	            System.out.println(project.getKey());
	            for (Task task : project.getValue()) {
	            	System.out.printf("    [%c] %d: %s%n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription());
	            }
	            System.out.println();
	        }
		
	}

}
