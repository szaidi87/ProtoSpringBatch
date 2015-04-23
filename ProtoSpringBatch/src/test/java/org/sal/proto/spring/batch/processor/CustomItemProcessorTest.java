package org.sal.proto.spring.batch.processor;

import org.junit.Test;
import org.sal.proto.spring.batch.Report;

import static org.junit.Assert.assertTrue;

public class CustomItemProcessorTest {
	
	private final CustomItemProcessor itemProcessor = new CustomItemProcessor();
	
	@Test
	public void processReport() throws Exception {
		Report report = new Report();
		itemProcessor.process(report);
		assertTrue(report.isProcessed());
	}
	
	@Test(expected=NullPointerException.class)
	public void processNullReport() throws Exception {
		itemProcessor.process(null);
	}
	
}
