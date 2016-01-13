/**
 * 
 */
package Modele;

/**
 * @author seb
 *
 */
public class Project {
	private String pName ;
	
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
