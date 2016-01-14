/**
 * 
 */
package command;

import Modele.Project;
import Modele.Task;
import Modele.TaskMap;

/**
 * @author seb
 *
 */
public class AddTask implements Command {
	private String proj;
	private String taskDesc;
	private TaskMap taskMap;

	public AddTask(){
		
	}
	/**
	 * 
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
		for(Project pTemp : this.taskMap.getTasks().keySet()){
			if(pTemp.getpName().equals(this.proj)){
				taskProj = pTemp;
			}
		}
		this.taskMap.getTasks().get(taskProj).add(new Task(TaskMap.nextId(), this.taskDesc, false));

	}

	/* (non-Javadoc)
	 * @see command.Command#man()
	 */
	@Override
	public void man (String input) {
		System.out.println("Bad use of the command you wrote: " + input + "\nThe command must be : [add task <project name> <task name>]\n");
	}

}
