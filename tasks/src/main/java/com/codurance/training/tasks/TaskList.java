package com.codurance.training.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class TaskList implements Runnable {
    private static final String QUIT = "quit";

    private final Map<String, List<Task>> tasks = new LinkedHashMap<>();
    private final BufferedReader in;
    private final PrintWriter out;

    private long lastId = 0;
    


    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        new TaskList(in, out).run();
    }

    public TaskList(BufferedReader reader, PrintWriter writer) {
        this.in = reader;
        this.out = writer;
    }

    public void run() {
        while (true) {
            out.print("> ");
            out.flush();
            Command command;
            try {
                command = new Command(in.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            
            if (command.getCmd_Name().equals(QUIT)) {
                break;
            }
            execute(command);
        }
    }

    private void execute(Command command) {
       
        switch (command.getCmd_Name()) {
            case "view":
                view();
                break;
            case "add":
                add(command.getCmd_Parameter());
                break;
            case "check":
                check(command.getCmd_Parameter());
                break;
            case "uncheck":
                uncheck(command.getCmd_Parameter());
                break;
            case "help":
                help();
                break;
            case "delete":
            	delete(command.getCmd_Parameter());
            	break;
            default:
                error(command.getCmd_Name());
                break;
        }
    }

    /**
	 * 
	 */
	private void delete(ArrayList<String> idString) {
		if(idString.size()<2 ){
			out.println("Wrong command. Type help for help");
		}
		try{
			   int id = Integer.parseInt(idString.get(0));
			   
			   List<Task> task = tasks.get(idString.get(1));
			   for (Task t : task){
				   if(t.getId()==id){
					   tasks.get(idString.get(1)).remove(t);
				   }
			   }
			  
		        out.printf("Could not find a task with an ID of %d.", id);
		        out.println();
		}catch(Exception e){
			out.println("Please enter the task id before the project name.");
		}
		
	}

	private void view() {
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            out.println(project.getKey());
            for (Task task : project.getValue()) {
                out.printf("    [%c] %d: %s%n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription());
            }
            out.println();
        }
    }

    private void add(ArrayList<String> command) {
        if (command.get(0).equals("project")) {
            addProject(command);
        } else if (command.get(0).equals("task")) {
            addTask(command.get(1),command.get(2));
        }
    }

    private void addProject(ArrayList<String> name) {
        tasks.put(name.get(1), new ArrayList<Task>());
    }

    private void addTask(String project, String description) {
        List<Task> projectTasks = tasks.get(project);
        if (projectTasks == null) {
            out.printf("Couldn't find a project with the name \"%s\".", project);
            out.println();
            return;
        }
        projectTasks.add(new Task(nextId(), description, false));
    }

    private void check(ArrayList<String> idString) {
        setDone(idString, true);
    }

    private void uncheck(ArrayList<String> idString) {
        setDone(idString, false);
    }

    private void setDone(ArrayList<String> idString, boolean done) {
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
    }

    private void help() {
        out.println("Commands:");
        out.println("  show");
        out.println("  add project <project name>");
        out.println("  add task <project name> <task description>");
        out.println("  check <task ID>");
        out.println("  uncheck <task ID>");
        out.println();
    }

    private void error(String command) {
        out.printf("I don't know what the command \"%s\" is.", command);
        out.println();
    }

    private long nextId() {
        return ++lastId;
    }
}
