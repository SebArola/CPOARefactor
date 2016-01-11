/**
 * 
 */
package command;

import Controler.CtrlTask;
import Modele.TaskMap;

/**
 * @author seb
 *
 */
public class DeleteProject extends Command  {
	String proj;
	/**
	 * 
	 */
	public DeleteProject(String prj) {
		proj = prj;
	}

	/* (non-Javadoc)
	 * @see command.Command#run()
	 */
	@Override
	public void run() {
		CtrlTask.tasks.getTasks().remove(proj);
		
	}

}
