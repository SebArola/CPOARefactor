/**
 * 
 */
package com.codurance.training.tasks;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author SebArola
 *	This class provide function to manage the command enter by the user.
 */
public class Command {
	
		private String cmd_Name ;
		private ArrayList<String> cmd_Parameter ;

		
		public Command(String inputCmd){
			 String[] commandRest = inputCmd.split(" ", 11);
		     setCmd_Name(commandRest[0]);
		     ArrayList<String> onlyParameter = new ArrayList<String>();
		     for(int i=0; i<commandRest.length ; i++ ){
		    	 onlyParameter.add(commandRest[i]);
		     }
		     setCmd_Parameter(onlyParameter);
		}
		
		/**
		 * @return the cmd_Name
		 */
		public String getCmd_Name() {
			return cmd_Name;
		}
		
		/**
		 * @param cmd_Name the cmd_Name to set
		 */
		public void setCmd_Name(String cmd_Name) {
			this.cmd_Name = cmd_Name;
		}
		
		/**
		 * @return the cmd_Parameter
		 */
		public ArrayList<String> getCmd_Parameter() {
			return cmd_Parameter;
		}
		
		/**
		 * @param cmd_Parameter the cmd_Parameter to set
		 */
		public void setCmd_Parameter(ArrayList<String> cmd_Parameter) {
			this.cmd_Parameter = cmd_Parameter;
		}
		
	
		
}
