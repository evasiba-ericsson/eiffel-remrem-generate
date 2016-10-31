package com.ericsson.eiffel.remrem.generate.cli;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.springframework.test.context.junit4.SpringRunner;

import com.ericsson.eiffel.remrem.generate.config.PropertiesConfig;

@RunWith(SpringRunner.class)
public class CliOptionsUnitTests {
	private PrintStream console;
	private ByteArrayOutputStream bytes;

	@Before public void setUp() throws Exception {
		String key = PropertiesConfig.TEST_MODE;
		System.setProperty(key, "true");
		//Switch std out to another stream
		bytes   = new ByteArrayOutputStream();		  
		console = System.out;
		System.setOut(new PrintStream(bytes));
	}

	@After
	public void tearDown() {
		System.clearProperty(PropertiesConfig.TEST_MODE);
		System.setOut(console);
		// reset error code since it is static
		CLIOptions.setErrorCode(0);
	}	

	@Test
	public void testParseEmptyCLIOptionsFails() throws Exception {	
		String[] args = new String[0];	    

		CLIOptions.parse(args);
		assertEquals(CLIExitCodes.CLI_MISSING_OPTION_EXCEPTION,
				CLIOptions.getErrorCode());
	}
	
	@Test
	public void testParseAllCLIOptions() throws Exception {
		String[] args = {"-t", "mt", "-f", "filename"};	    

		CLIOptions.parse(args);
		int i = 0;
	}
	
	@Test
	public void testHelpOptionOnlyWorks() throws Exception {
		String[] args = {"-h"};
		CLIOptions.parse(args);
		assertEquals(0,
				CLIOptions.getErrorCode());
		int i = 0;
	}
	
	@Test
	public void testHelpOptionWorks() throws Exception {
		String[] args = {"-h", "-r", "respons file"};
		CLIOptions.parse(args);
		assertEquals(0,
				CLIOptions.getErrorCode());
		int i = 0;
	}
}
