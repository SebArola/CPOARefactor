/**
 * 
 */
package command;

import java.util.ArrayList;

import Modele.Project;
import Modele.Task;
import Modele.TaskMap;

/**
 * @author seb
 *
 */
public class AddProject implements Command {
	private String proj;
	private TaskMap taskMap;

	/**
	 * 
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
		this.taskMap.getTasks().put(new Project(this.proj), new ArrayList<Task>());
	}

	/* (non-Javadoc)
	 * @see command.Command#man()
	 */
	@Override
	public void man() {
		// TODO Auto-generated method stub
		
	}

}
