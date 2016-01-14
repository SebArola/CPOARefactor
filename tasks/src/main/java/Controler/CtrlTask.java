package Controler;

import Modele.TaskMap;
import command.Command;
import command.*;

public final class CtrlTask {

	private TaskMap tasks;
	private Command cmd;

	public CtrlTask() {
		this.tasks = new TaskMap();
	}

	public void run(String commandLine) {
		String cmdInput = commandLine ;

		String[] commandRest = cmdInput.split(" ", 4);
		String command = commandRest[0];
		switch (command) {
		case "view":
			this.cmd = new View(this.tasks);
			this.cmd.run();
			break;
		case "add":
			if (commandRest.length==3 &&commandRest[1].equals("project") ) {
				this.cmd = new AddProject(commandRest[2], this.tasks);
				this.cmd.run();
			} else if (commandRest.length==4&&commandRest[1].equals("task") ) {
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
			if(commandRest.length==2){
				this.cmd = new Check(commandRest[1],this.tasks);
				this.cmd.run();
			}else{
				this.cmd = new Check();
				this.cmd.man(commandLine);
			}
			
			break;
		case "uncheck":
			if(commandRest.length==2){
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
			if (commandRest.length==3&&commandRest[1].equals("project") ) {
				this.cmd = new DeleteProject(commandRest[2],this.tasks);
				this.cmd.run();
			} else if (commandRest.length==4&& commandRest[1].equals("task")) {
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
			if(commandRest.length==3){
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

	private void error(String command) {
		System.out.printf("I don't know what the command \"%s\" is.", command);
		System.out.println();
	}

}
