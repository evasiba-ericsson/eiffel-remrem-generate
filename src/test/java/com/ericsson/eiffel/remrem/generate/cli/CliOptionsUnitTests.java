package com.ericsson.eiffel.remrem.generate.cli;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class CliOptionsUnitTests {
	private PrintStream console;
    private ByteArrayOutputStream bytes;

	
	@Before public void setUp() throws Exception {
		  bytes   = new ByteArrayOutputStream();
	      console = System.out;
	      System.setOut(new PrintStream(bytes));
	}
	
	 @After
	   public void tearDown() {
	      System.setOut(console);
	   }
	
	@Test
    public void testParseEmptyCLIOptionsFails() throws Exception {
		CLIOptions cliOptions = new CLIOptions();
		String[] args = new String[0];
	    
	
	         cliOptions.parse(args);
	    int i = 0;
		
	}
}
