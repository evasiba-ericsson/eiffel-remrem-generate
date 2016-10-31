package com.ericsson.eiffel.remrem.generate.cli;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import com.ericsson.eiffel.remrem.generate.config.PropertiesConfig;
import com.ericsson.eiffel.remrem.shared.MsgService;

@RunWith(SpringRunner.class)
public class CliUnitTests {
	private PrintStream console;
	private ByteArrayOutputStream bytes;
	
	@Mock
    private MsgService msgService;
	

	private CLI cli;
	
	@Before public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		String key = PropertiesConfig.TEST_MODE;
		System.setProperty(key, "true");
		//Switch std out to another stream
		bytes   = new ByteArrayOutputStream();		  
		console = System.out;
		System.setOut(new PrintStream(bytes));
		MsgService[] msgServices = {msgService};
		cli = new CLI(msgServices);		
		
		Mockito.when(msgService.generateMsg(
	                Mockito.anyString(),
	                Mockito.anyObject()
	        )).thenReturn("{ \"service\":\"msgService\" }");
	}
	
	@After
	public void tearDown() {
		System.clearProperty(PropertiesConfig.TEST_MODE);
		System.setOut(console);
		// reset error code since it is static
		CLIOptions.setErrorCode(0);
	}

	@Test
	public void testHandleFileArgs() throws Exception {	
		int i = 0;
	}
}
