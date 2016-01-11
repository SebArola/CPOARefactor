/**
 * 
 */
package com.codurance.training.tasks;
import static org.junit.Assert.*;

import org.junit.Test;

import command.Command;

/**
 * @author Sebastien Arola, Tanguy Heller
 *
 */
public class CommandTest {
	
		@Test
		public void test_Name(){
			Command cmd = new Command("name param1 param2");
			
			assertEquals("name",cmd.getCmd_Name());
		}
		
		@Test
		public void test_LonelyParam(){
			Command cmd = new Command("name param1");
			
			assertEquals("param1",cmd.getCmd_Parameter().get(0));
		}
		
		
		
}
