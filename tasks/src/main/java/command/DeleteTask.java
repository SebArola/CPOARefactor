/**
 * 
 */
package command;

import java.util.List;

import Controler.CtrlTask;
import Modele.Task;
import Modele.TaskMap;

/**
 * @author seb
 *
 */
public class DeleteTask extends Command {
	int id;
	String proj;
	/**
	 * 
	 */
	public DeleteTask(String tId , String prj) {
		try{
			   id = Integer.parseInt(tId);
		
		}catch(Exception e){
			System.out.println("Please enter the task id before the project name.");
		}
		
		 proj = prj;
	}

	/* (non-Javadoc)
	 * @see command.Command#run()
	 */
	@Override
	public void run() {
		List<Task> task = CtrlTask.tasks.getTasks().get(proj);
		   for (Task t : task){
			   if(t.getId()==id){
				   CtrlTask.tasks.getTasks().get(proj).remove(t);
			   }
		   }
		
	}

}
