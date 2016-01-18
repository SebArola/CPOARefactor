
package command;

import Modele.Project;
import Modele.Task;
import Modele.TaskMap;

/**
 * The command AddProject is called when the user write add task <project name> <task description>.
 * It add a new task to the project <project name>.
 * @author Sébastien Arola, Tanguy Heller
 *
 */
public class AddTask implements Command {
	// Stored the data 
	private String proj;   
	private String taskDesc;
	private TaskMap taskMap;
	
	/**
	 * Default constructor provide an empty constructor to have a useless command object.
	 */
	public AddTask(){
		
	}
	/**
	 * Use this constructor to use the command. 
	 * @param project
	 * @param taskDes
	 * @param tm
	 */
	public AddTask(String project, String taskDes, TaskMap tm) {
		this.proj = project;
		this.taskDesc = taskDes;
		this.taskMap = tm;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see command.Command#run()
	 */
	@Override
	public void run() {
		
		Project taskProj = null;
		// Find the project design by <project name>
		for(Project pTemp : this.taskMap.getTasks().keySet()){
			if(pTemp.getpName().equals(this.proj)){
				taskProj = pTemp;
			}
		}
		this.taskMap.getTasks().get(taskProj).add(new Task(TaskMap.nextId(), this.taskDesc, false)); // Add the task

	}

	/* (non-Javadoc)
	 * @see command.Command#man()
	 */
	@Override
	public void man (String input) {
		System.out.println("Bad use of the command you wrote: " + input + "\nThe command must be : [add task <project name> <task name>]\n");
	}

}
