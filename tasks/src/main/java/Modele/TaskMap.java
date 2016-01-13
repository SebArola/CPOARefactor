/**
 * 
 */
package Modele;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sébastien Arola, Tanguy Heller
 *
 */
public class TaskMap {
	  private static long lastId = 0;
	  private Map<Project, List<Task>> tasks;

	/**
	 * Constructor of the model TaskMap. It initialize the Map with a LinkedHashMap
	 */
	public TaskMap() {
		this.tasks = new LinkedHashMap<>();
	}
	
	/**
	 * @return the tasks
	 */
	public Map<Project, List<Task>> getTasks() {
		return this.tasks;
	}
	
	/**
	 * Compute the next task id.
	 * @return task id
	 */
	 public static long nextId() {
	        return ++lastId;
	    }
}
