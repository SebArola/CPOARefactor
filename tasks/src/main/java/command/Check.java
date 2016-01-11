/**
 * 
 */
package command;

import java.util.List;
import java.util.Map;

import Controler.CtrlTask;
import Modele.Task;

/**
 * @author seb
 *
 */
public class Check extends Command{
	
	int id;
	/**
	 * 
	 */
	public Check(String idTask) {
		try{
			id = Integer.parseInt(idTask);
		}catch(Exception e ){
			System.out.println("Enter an integer. Type help for help");
		}
	}

	/* (non-Javadoc)
	 * @see command.Command#run()
	 */
	@Override
	public void run() {
		for (Map.Entry<String, List<Task>> project : CtrlTask.tasks.getTasks().entrySet()) {
            for (Task task : project.getValue()) {
                if (task.getId() == id) {
                    task.setDone(true);
                    return;
                }
            }
        }
        System.out.printf("Could not find a task with an ID of %d.", id);
        System.out.println();
		
	}

}
