package com.mulesoft.training;



import org.junit.Assert;
import org.junit.Test;
import org.mule.api.MuleEvent;
import org.mule.tck.junit4.FunctionalTestCase;


public class HelloMavenTest extends FunctionalTestCase {

	@Test
	public void mavenFlowReturnsHelloMaven() throws Exception {
		runFlowAndExpect("mavenFlow", "Hello Maven");
	}
	
	 @Test
	 public void retrieveFlightsAddsAppropriateHeader() throws Exception {
	   MuleEvent event = runFlow("retrieveFlights");
	   String contentType = event.getMessage().getOutboundProperty("Content-Type");
	   Assert.assertEquals("application/json", contentType);
	 }
	
	@Override
	protected String getConfigFile() {
		return "maven-project-tm.xml";
	}
	
}
