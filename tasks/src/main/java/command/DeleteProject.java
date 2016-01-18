/**
 * 
 */
package command;

import Modele.Project;
import Modele.TaskMap;

/**
 * 
 * The command DeleteProject is called when the user write delete project <project name>.
 * Delete the project <project name>
 * @author Sébastien Arola, Tanguy Heller
 *
 */
public class DeleteProject implements Command  {
	private String proj;
	private TaskMap tasks;
	
	/**
	 * Default constructor provide an empty constructor to have a useless command object.
	 */
	public DeleteProject(){
		
	}
	
	/**
	 * Use this constructor to use the command.
	 * @param prj the <project name>
	 * @param tm
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
		// Find the project
		for(Project pTemp : this.tasks.getTasks().keySet()){
			if(pTemp.getpName().equals(this.proj)){
				taskProj = pTemp; // Store the project's reference
			}
		}
		this.tasks.getTasks().remove(taskProj); // Remove it
	}

	/* (non-Javadoc)
	 * @see command.Command#man()
	 */
	@Override
	public void man(String input) {
		System.out.println("Bad use of the command you wrote: " + input + "\nThe command must be : [delete project <project name>]\n");	
	}

}
