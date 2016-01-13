package Modele;


public final class Task {
    private final long id;
    private final String description;
    private boolean done;
    private Date deadLines ;

    public Task(long id, String description, boolean done) {
        this.id = id;
        this.description = description;
        this.done = done;
        this.deadLines = new Date();
    }

    /**
	 * 
	 */
	public Task() {
		this.id =0;
		this.description = "ronflex";
	}

	public long getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean isDone() {
        return this.done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

	/**
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
