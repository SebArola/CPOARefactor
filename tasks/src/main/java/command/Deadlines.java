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
public class Deadlines implements Command {
	private int id;
	private int day;
	private int month;
	private int year;
	private TaskMap tasks;
	
	public Deadlines(){
		
	}
	/**
	 * 
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
		for( Project proj : this.tasks.getTasks().keySet()){
			for( Task t : this.tasks.getTasks().get(proj) ){
				if(t.getId()==this.id){
					t.setDeadLines(this.day, this.month, this.year);
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
