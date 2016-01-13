/**
 * 
 */
package com.codurance.training.tasks;

import static org.junit.Assert.*;

import org.junit.Test;

import Modele.Project;
import Modele.TaskMap;

import command.*;

/**
 * @author Sebastien Arola, Tanguy Heller
 *
 */
public class CommandTest {
	private Command cmd;

	private TaskMap tm;

	@Test
	public void addProject() {
		this.tm = new TaskMap();

		this.cmd = new AddProject("p1", this.tm);
		this.cmd.run();
		assertEquals("p1", this.tm.getTasks().keySet().iterator().next().getpName());
	}

	@Test
	public void addTask() {
		this.tm = new TaskMap();

		this.cmd = new AddProject("p1", this.tm);
		this.cmd.run();
		Project p = this.tm.getTasks().keySet().iterator().next();
		assertEquals("p1", p.getpName());
		
		this.cmd = new AddTask("p1", "t1", this.tm);
		this.cmd.run();
		assertTrue("Task not created", !this.tm.getTasks().get(p).isEmpty());
	}

	@Test
	public void DeleteProject() {
		this.tm = new TaskMap();

		this.cmd = new AddProject("p1", this.tm);
		this.cmd.run();
		Project p = this.tm.getTasks().keySet().iterator().next();
		assertEquals("p1", p.getpName());
		this.cmd = new DeleteProject("p1", this.tm);
		this.cmd.run();
		assertTrue("Project not deleted", !this.tm.getTasks().containsKey(p));
	}

	@Test
	public void DeleteTask() {
		this.tm = new TaskMap();

		this.cmd = new AddProject("p1", this.tm);
		this.cmd.run();
		Project p = this.tm.getTasks().keySet().iterator().next();
		assertEquals("p1", p.getpName());

		this.cmd = new AddTask("p1", "t1", this.tm);
		this.cmd.run();
		
		assertTrue("Task not created", !this.tm.getTasks().get(p).isEmpty());

		this.cmd = new DeleteTask("2", "p1", this.tm);
		this.cmd.run();

		assertTrue("Task not deleted", this.tm.getTasks().get(p).size() == 0);
	}

	@Test
	public void Check() {
		this.tm = new TaskMap();

		this.cmd = new AddProject("p1", this.tm);
		this.cmd.run();
		Project p = this.tm.getTasks().keySet().iterator().next();
		assertEquals("p1",p.getpName());
		
		this.cmd = new AddTask("p1", "t1", this.tm);
		this.cmd.run();
		assertTrue("Task not created", !this.tm.getTasks().get(p).isEmpty());

		this.cmd = new Check("3", this.tm);
		this.cmd.run();
		assertTrue("Task not check", this.tm.getTasks().get(p).get(0).isDone());
	}

	@Test
	public void Uncheck() {
		this.tm = new TaskMap();

		this.cmd = new AddProject("p1", this.tm);
		this.cmd.run();
		Project p = this.tm.getTasks().keySet().iterator().next();
		assertEquals("p1", p.getpName());

		this.cmd = new AddTask("p1", "t1", this.tm);
		this.cmd.run();
		assertTrue("Task not created", !this.tm.getTasks().get(p).isEmpty());

		this.cmd = new Check("4", this.tm);
		this.cmd.run();
		assertTrue("Task not check", this.tm.getTasks().get(p).get(0).isDone());

		this.cmd = new Uncheck("4", this.tm);
		this.cmd.run();
		assertTrue("Task not check", !this.tm.getTasks().get(p).get(0).isDone());
	}
	/*
	 * @Test public void View(){ tm = new TaskMap();
	 * 
	 * cmd = new AddProject("p1",tm); cmd.run(); assertTrue(
	 * "Project not created",tm.getTasks().containsKey("p1"));
	 * 
	 * cmd = new AddTask("p1","t1",tm); cmd.run(); assertTrue("Task not created"
	 * ,!tm.getTasks().get("p1").isEmpty());
	 * 
	 * assertEquals("p1\n    [ ] 1: t1 [no deadline]\n",); }
	 */
}
