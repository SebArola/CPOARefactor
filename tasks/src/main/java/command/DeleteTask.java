/**
 * 
 */
package command;

import java.util.List;

import Modele.Project;
import Modele.Task;
import Modele.TaskMap;

/**
 * 
 * The command DeleteTask is called when the user write delete task <task id> <project name>.
 * Delete the task <task id>
 * @author Sébastien Arola, Tanguy Heller
 *
 */
public class DeleteTask implements Command {
	private int id;
	private String proj;
	private TaskMap tasks;
	
	/**
	 * Default constructor provide an empty constructor to have a useless command object.
	 */
	public DeleteTask(){
		
	}
	
	/**
	 * Use this constructor to use the command.
	 * @param tId the task id.
	 * @param prj the project name.
	 * @param tm
	 */
	public DeleteTask(String tId , String prj, TaskMap tm) {
		try{
			   this.id = Integer.parseInt(tId);
		
		}catch(Exception e){
			System.out.println("Please enter the task id before the project name.");
		}
		
		 this.proj = prj;
		 this.tasks=tm ;
	}

	/* (non-Javadoc)
	 * @see command.Command#run()
	 */
	@Override
	public void run() {
		Task temp = new Task();
		Project taskProj = null;
		// Search the task's project.
		for(Project pTemp : this.tasks.getTasks().keySet()){
			if(pTemp.getpName().equals(this.proj)){
				taskProj = pTemp;
			}
		}
		
		// Search the task.
		List<Task> task = this.tasks.getTasks().get(taskProj);
		   for (Task t : task){
			   if(t.getId()==this.id){
				   temp = t;
				   
			   }
		   }
		   
		   // Finnaly remove it.
		   this.tasks.getTasks().get(taskProj).remove(temp);
	}

	/* (non-Javadoc)
	 * @see command.Command#man()
	 */
	@Override
	public void man(String input) {
		System.out.println("Bad use of the command you wrote: " + input + "\nThe command must be : [delete task <task id> <project name>]\n");	
	}

}
