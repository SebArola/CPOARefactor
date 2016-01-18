package Modele;

/**
 * The class where all the task's information are stored.
 * @author Sébastien Arola, Tanguy Heller
 *
 */
public final class Task {
    private final long id;
    private final String description;
    private boolean done;
    private Date deadLines ;

    /**
     * Use this constructor to create a class.
     * @param id
     * @param description
     * @param done
     */
    public Task(long id, String description, boolean done) {
        this.id = id;
        this.description = description;
        this.done = done;
        this.deadLines = new Date();
    }

    /**
	 * This default constructor could be use when you need a temporary class
	 */
	public Task() {
		this.id =0;
		this.description = "ronflex";
	}

	/**
	 * 
	 * @return the task id.
	 */
	public long getId() {
        return this.id;
    }

	/**
	 * 
	 * @return the task description.
	 */
    public String getDescription() {
        return this.description;
    }

    /**
     * 
     * @return true if the task is check else false.
     */
    public boolean isDone() {
        return this.done;
    }

    /**
     * Call this to check the task.
     * @param done
     */
    public void setDone(boolean done) {
        this.done = done;
    }

	/**
	 * Call this to set the deadline.
	 * @param the day, month and year of the date.
	 */
	public void setDeadLines(int d, int m, int y) {
		this.deadLines.setDay(d);
		this.deadLines.setMonth(m);
		this.deadLines.setYear(y);
	}
	
	/**
	 * @return the deadLines
	 */
	public String getDeadLines(){
		return this.deadLines.getDay()+"/"+this.deadLines.getMonth()+"/"+this.deadLines.getYear();
	}
}
