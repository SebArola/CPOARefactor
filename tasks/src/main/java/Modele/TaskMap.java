/**
 * 
 */
package Modele;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author seb
 *
 */
public class TaskMap {
	  private static long lastId = 0;
	  private Map<String, List<Task>> tasks;

	/**
	 * 
	 */
	public TaskMap() {
		tasks = new LinkedHashMap<>();
	}
	
	/**
	 * @return the tasks
	 */
	public Map<String, List<Task>> getTasks() {
		return tasks;
	}
	
	private void check(String idString) {
	       
	}

	private void uncheck(ArrayList<String> idString) {
	       
	}
	
	 public static long nextId() {
	        return ++lastId;
	    }
}
