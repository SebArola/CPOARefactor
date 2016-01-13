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
public class Uncheck implements Command {

	private int id;
	private TaskMap tasks;

	/**
	 * 
	 */
	public Uncheck(String idTask, TaskMap tm) {
		try {
			this.id = Integer.parseInt(idTask);
		} catch (Exception e) {
			System.out.println("Enter an integer. Type help for help");
		}
		this.tasks = tm;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see command.Command#run()
	 */
	@Override
	public void run() {
		for (Map.Entry<Project, List<Task>> project : this.tasks.getTasks().entrySet()) {
			for (Task task : project.getValue()) {
				if (task.getId() == this.id) {
					task.setDone(false);
					return;
				}
			}
		}
		System.out.printf("Could not find a task with an ID of %d.", this.id);
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
