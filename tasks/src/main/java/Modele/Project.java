/**
 * 
 */
package Modele;

/**
 * This class stored all the project information.
 * @author Sébastien Arola, Tanguy Heller
 *
 */
public class Project {
	private String pName ;
	
	/**
	 * This constructor initialize a project with a name name.
	 * @param name
	 */
	public Project(String name){
		this.pName = name;
	}

	/**
	 * @return the pName
	 */
	public String getpName() {
		return this.pName;
	}

	/**
	 * @param pName the pName to set
	 */
	public void setpName(String pName) {
		this.pName = pName;
	}
}
