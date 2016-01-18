package Controler;

import Modele.TaskMap;
import command.Command;
import command.*;

/**
 * 
 * @author Sébastien Arola, Tanguy Heller
 * This is the principale Class. It controle all the other class.
 */
public final class CtrlTask {

	private TaskMap tasks; // The TaskMap where all the tasks and the project are stored.
	private Command cmd;   // The Command object which permit to launch all the different command.

	/**
	 *  Constructor of CtrlTask. It initialize the TaskMap. See TaskMap.java for more details
	 */
	public CtrlTask() {
		this.tasks = new TaskMap(); 
	}

	/**
	 * Method run will analyze the command to launch the correct command class.
	 * @param commandLine
	 */
	public void run(String commandLine) { 
		String cmdInput = commandLine ; 

		String[] commandRest = cmdInput.split(" ", 4); // We split cmdInput to have all the part. commandLine is not modified.
		String command = commandRest[0];
		
		switch (command) { // This switch analyze the command
		case "view":
			this.cmd = new View(this.tasks);
			this.cmd.run();
			break;
		case "add":
			if (commandRest.length==3 &&commandRest[1].equals("project") ) { // Check if the command is correctly write.
				this.cmd = new AddProject(commandRest[2], this.tasks);
				this.cmd.run();
			} else if (commandRest.length==4&&commandRest[1].equals("task") ) {// Check if the command is correctly write.
				this.cmd = new AddTask(commandRest[2], commandRest[3], this.tasks);
				this.cmd.run();
			}else{
				this.cmd = new AddTask();
				this.cmd.man(commandLine);
				this.cmd = new AddProject();
				this.cmd.man(commandLine);
			}
			break;

		case "check":
			if(commandRest.length==2){// Check if the command is correctly write.
				this.cmd = new Check(commandRest[1],this.tasks);
				this.cmd.run();
			}else{
				this.cmd = new Check();
				this.cmd.man(commandLine);
			}
			
			break;
		case "uncheck":
			if(commandRest.length==2){// Check if the command is correctly write.
				this.cmd = new Uncheck(commandRest[1],this.tasks);
				this.cmd.run();
			}else{
				this.cmd = new Uncheck();
				this.cmd.man(commandLine);
			}
			
			break;
		case "help":
			this.cmd = new Help();
			this.cmd.run();
			break;
		case "delete":
			if (commandRest.length==3&&commandRest[1].equals("project") ) {// Check if the command is correctly write.
				this.cmd = new DeleteProject(commandRest[2],this.tasks);
				this.cmd.run();
			} else if (commandRest.length==4&& commandRest[1].equals("task")) {// Check if the command is correctly write.
				this.cmd = new DeleteTask(commandRest[2], commandRest[3],this.tasks);
				this.cmd.run();
			}else{
				this.cmd = new DeleteProject();
				this.cmd.man(commandLine);
				this.cmd = new DeleteTask();
				this.cmd.man(commandLine);
			}

			break;
		case "deadlines":
			if(commandRest.length==3){// Check if the command is correctly write.
				this.cmd = new Deadlines(commandRest[1], commandRest[2],this.tasks);
				this.cmd.run();
			}else{
				this.cmd = new Deadlines();
				this.cmd.man(commandLine);
			}
			
			break;
		default:
			error(commandLine);
			break;
		}
	}
	
	/**
	 * This method provide an error message for unknown command.
	 * @param command
	 */

	private void error(String command) {
		System.out.printf("I don't know what the command \"%s\" is.", command);
		System.out.println();
	}

}
