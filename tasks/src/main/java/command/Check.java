
package command;

import java.util.List;
import java.util.Map;

import Modele.Project;
import Modele.Task;
import Modele.TaskMap;

/**
 * The command Check is called when the user write check <task name>.
 * It check the task design by <task name>.
 * @author Sébastien Arola, Tanguy Heller
 *
 */
public class Check implements Command{
	
	private int id;
	private TaskMap tasks;
	
	/**
	 * Default constructor provide an empty constructor to have a useless command object.
	 */
	public Check(){
		
	}
	
	/**
	 * Use this constructor to use the command.
	 * @param idTask
	 * @param tm
	 */
	public Check(String idTask, TaskMap tm) {
		try{
			this.id = Integer.parseInt(idTask);
		}catch(Exception e ){
			System.out.println("Enter an integer. Type help for help");
		}
		this.tasks =tm;
	}

	/* (non-Javadoc)
	 * @see command.Command#run()
	 */
	@Override
	public void run() {
		
		// Find the task design by <task name> and set it done
		for (Map.Entry<Project, List<Task>> project : this.tasks.getTasks().entrySet()) {
            for (Task task : project.getValue()) {
                if (task.getId() == this.id) {
                    task.setDone(true); // Check the task
                    return;
                }
            }
        }
		
		// If the task is not find write this error message.
        System.out.printf("Could not find a task with an ID of %d.", this.id);
        System.out.println();
		
	}

	/* (non-Javadoc)
	 * @see command.Command#man()
	 */
	@Override
	public void man(String input) {
		System.out.println("Bad use of the command you wrote: " + input + "\nThe command must be : [check <task name>]\n");
	}

}
