/**
 * 
 */
package command;

import java.util.List;

import Modele.Project;
import Modele.Task;
import Modele.TaskMap;

/**
 * @author seb
 *
 */
public class DeleteTask implements Command {
	private int id;
	private String proj;
	private TaskMap tasks;
	
	public DeleteTask(){
		
	}
	/**
	 * 
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
		for(Project pTemp : this.tasks.getTasks().keySet()){
			if(pTemp.getpName().equals(this.proj)){
				taskProj = pTemp;
			}
		}
		List<Task> task = this.tasks.getTasks().get(taskProj);
		   for (Task t : task){
			   if(t.getId()==this.id){
				   temp = t;
				   
			   }
		   }
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
