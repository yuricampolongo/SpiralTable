package com.cgi.entretien.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.AfterClass;
import org.junit.Test;

import com.cgi.entretien.tablespirale.Main;

public class TestTableSpiral {

	private static PrintStream old = System.out;
	private static PrintStream oldErr = System.err;
	private ByteArrayOutputStream baos = new ByteArrayOutputStream();

	@Test
	public void test4x4table() {
		setOutput();
		String[] args = new String[1];
		args[0] = "4";
		Main.main(args);
		assertTrue(baos.toString().length() == 237);
	}
	
	@Test
	public void test5x5table() {
		setOutput();
		String[] args = new String[1];
		args[0] = "5";
		Main.main(args);
		assertTrue(baos.toString().length() == 346);
	}
	
	@Test
	public void testInvalidInput() {
		setOutput();
		String[] args = new String[1];
		args[0] = "NO_VALID";
		Main.main(args);
		assertTrue(baos.toString().equals("Invalid number passed as argument.\r\n"));
	}

	private void setOutput() {
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		System.setErr(ps);
	}

	@AfterClass
	public static void endTest() {
		System.setOut(old);
		System.setErr(oldErr);
	}

}
