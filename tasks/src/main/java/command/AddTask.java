/**
 * 
 */
package command;

import java.util.ArrayList;
import java.util.List;

import Modele.Task;
import Modele.TaskMap;

/**
 * @author seb
 *
 */
public class AddTask extends Command{
	String proj ;
	String taskDesc ;
	TaskMap taskMap;

	/**
	 * 
	 */
	public AddTask(String project, String taskDes, TaskMap tm) {
		proj = project;
		taskDesc = taskDes;
		taskMap = tm;
	}

	/* (non-Javadoc)
	 * @see command.Command#run()
	 */
	@Override
	public void run() {
		
       taskMap.getTasks().get(proj).add(new Task(TaskMap.nextId(), taskDesc, false));
		
	}

}
