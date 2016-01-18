/**
 * 
 */
package command;

import java.util.ArrayList;

import Modele.Project;
import Modele.Task;
import Modele.TaskMap;

/**
 * The command AddProject is called when the user write add project <project name>.
 * It add a new project to the TaskMap.
 * @author Sébastien Arola, Tanguy Heller
 *
 */
public class AddProject implements Command {
	private String proj;
	private TaskMap taskMap;

	/**
	 * Default constructor provide an empty constructor to have a useless command object.
	 */
	public AddProject(){
		
	}
	/**
	 * Use this constructor to use the command. 
	 * @param project : the project name enter by the user.
	 * @param tm : the TaskMap where all data are stored.
	 */
	public AddProject(String project, TaskMap tm) {
		this.proj = project;
		this.taskMap = tm;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see command.Command#run()
	 */
	@Override
	public void run() {
		this.taskMap.getTasks().put(new Project(this.proj), new ArrayList<Task>()); // Add the project.
	}

	/* (non-Javadoc)
	 * @see command.Command#man()
	 */
	@Override
	public void man(String input) {
		// Error message for bad use.
		System.out.println("Bad use of the command you wrote: " + input + "\nThe command must be : [add project <project name>]");	
	}

}
