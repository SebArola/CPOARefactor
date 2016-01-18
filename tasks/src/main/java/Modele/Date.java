/**
 * 
 */
package Modele;

/**
 * This stored data to create date in the format dd/mm/yyyy
 * @author Sébastien Arola, Tanguy Heller
 *
 */
public class Date {
	private int day;
	private int month;
	private int year;

	/**
	 * Set a default date. The date is 0/0/0
	 */
	public Date() {
		setDay(0);
		setMonth(0);
		setYear(0);
	}

	/**
	 * @return the day
	 */
	public int getDay() {
		return this.day;
	}

	/**
	 * @param day the day to set
	 *  
	 */
	public void setDay(int day) {
		this.day = day;
	}

	/**
	 * @return the month
	 */
	public int getMonth() {
		return this.month;
	}

	/**
	 * @param month
	 *            the month to set
	 */
	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return this.year;
	}

	/**
	 * @param year
	 *            the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

}
