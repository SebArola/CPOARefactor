package Controler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.codurance.training.tasks.ReadCMD;

import Modele.Task;
import Modele.TaskMap;
import command.Command;
import command.*;

public final class CtrlTask  {
    private static final String QUIT = "quit";
    public static TaskMap tasks;
    
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        CtrlTask ctrl = new CtrlTask();
        System.out.println("Welcome to aroller's project gesture\n");
        
        while(true){
        	String cmd =new ReadCMD(in, out).run();
        	if(cmd.equals(QUIT)){
        		 break;
        	}
        	ctrl.execute(cmd);
        }
       
    }
    
    public CtrlTask(){
    	tasks = new TaskMap();
    }


    private void execute(String commandLine) {
    	 Command cmd ;
    	 String[] commandRest = commandLine.split(" ", 4);
         String command = commandRest[0];
         switch (command) {
             case "view":
                 cmd = new View(tasks);
                 cmd.run();
                 break;
             case "add":
            	 if(commandRest[1].equals("project")){
            		 cmd = new AddProject(commandRest[2], tasks);
                     cmd.run();
            	 }else if(commandRest[1].equals("task")){
            		 cmd = new AddTask(commandRest[2],commandRest[3],tasks);
                     cmd.run();
            	 }
            	
                 break;
             case "check":
            	 cmd = new Check(commandRest[1]);
                 cmd.run();
                 break;
             case "uncheck":
            	 cmd = new Uncheck(commandRest[1]);
                 cmd.run();
                 break;
             case "help":
            	 cmd = new Help();
                 cmd.run();
                 break;
             case "delete":
            	 if(commandRest[1].equals("project")){
            		 cmd = new DeleteProject(commandRest[2]);
                     cmd.run();
            	 }else if(commandRest[1].equals("task")){ 
            		 cmd = new DeleteTask(commandRest[2], commandRest[3]);
                     cmd.run();
            	 }
            	 
             	break;
             case "deadlines":
            	 cmd = new Deadlines();
                 cmd.run();
             default:
                 error(commandLine);
                 break;
            
         }
            
        
    }

   /* private void setDone(ArrayList<String> idString, boolean done) {
        int id = Integer.parseInt(idString.get(0));
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            for (Task task : project.getValue()) {
                if (task.getId() == id) {
                    task.setDone(done);
                    return;
                }
            }
        }
        out.printf("Could not find a task with an ID of %d.", id);
        out.println();
    }*/


    private void error(String command) {
    	 System.out.printf("I don't know what the command \"%s\" is.", command);
    	 System.out.println();
    }

   
}
