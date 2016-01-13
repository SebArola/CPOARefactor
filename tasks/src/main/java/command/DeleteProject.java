/**
 * 
 */
package command;

import Modele.Project;
import Modele.TaskMap;

/**
 * @author Sébastien Arola, Tanguy Heller
 *
 */
public class DeleteProject implements Command  {
	private String proj;
	private TaskMap tasks;
	/**
	 * 
	 */
	public DeleteProject(String prj, TaskMap tm) {
		this.proj = prj;
		this.tasks = tm;
	}

	/* (non-Javadoc)
	 * @see command.Command#run()
	 */
	@Override
	public void run() {
		Project taskProj = null;
		for(Project pTemp : this.tasks.getTasks().keySet()){
			if(pTemp.getpName().equals(this.proj)){
				taskProj = pTemp;
			}
		}
		this.tasks.getTasks().remove(taskProj);
	}

	/* (non-Javadoc)
	 * @see command.Command#man()
	 */
	@Override
	public void man() {
		// TODO Auto-generated method stub
		
	}

}
