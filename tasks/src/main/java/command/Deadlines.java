/**
 * 
 */
package command;

import Modele.Project;
import Modele.Task;
import Modele.TaskMap;

/**
 * The command DeadLines is called when the user write deadlines <task name> <dd/mm/yyyy>.
 * It initialize a deadline for a task.
 * @author Sébastien Arola, Tanguy Heller
 *
 */
public class Deadlines implements Command {
	private int id;
	private int day;
	private int month;
	private int year;
	private TaskMap tasks;
	
	/**
	 * Default constructor provide an empty constructor to have a useless command object.
	 */
	public Deadlines(){
		
	}
	
	/**
	 * Use this constructor to use the command.
	 * @param idT the task id
	 * @param dt the date
	 * @param tm the TaskMap
	 */
	public Deadlines(String idT, String dt, TaskMap tm) {
		this.id = Integer.parseInt(idT);
		
		String[] tabDate = dt.split("/",3);
		
		this.day = Integer.parseInt(tabDate[0]);
		
		this.month = Integer.parseInt(tabDate[1]);

		this.year = Integer.parseInt(tabDate[2]);
		
		this.tasks =tm;
	}

	/* (non-Javadoc)
	 * @see command.Command#run()
	 */
	@Override
	public void run() {
		// Find the task and stored the deadline
		for( Project proj : this.tasks.getTasks().keySet()){
			for( Task t : this.tasks.getTasks().get(proj) ){
				if(t.getId()==this.id){
					t.setDeadLines(this.day, this.month, this.year); // Stored the deadline
				}
			}
		}
	}

	/* (non-Javadoc)
	 * @see command.Command#man()
	 */
	@Override
	public void man(String input) {
		System.out.println("Bad use of the command you wrote: " + input + "\nThe command must be : [deadlines <task id> <dd/mm/yyyy>]\n");	
	}
}
