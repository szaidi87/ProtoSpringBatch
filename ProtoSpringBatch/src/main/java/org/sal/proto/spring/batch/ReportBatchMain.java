package org.sal.proto.spring.batch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.sal.proto.jetty.server.ProtoJettyServer;
import org.springframework.context.support.GenericXmlApplicationContext;

@Slf4j
public class ReportBatchMain {
	
	private final GenericXmlApplicationContext context;
	
	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("Error: Specify the spring configuration .xml files as resource strings - starting with file: or classpath:");
			System.exit(1);
		}
		new ReportBatchMain(Arrays.asList(args));
	}
	
	public ReportBatchMain(List<String> configurationXml) {
		context = new GenericXmlApplicationContext();
		// Use this to set properties if the need arises
		//ConfigurableEnvironment environment = context.getEnvironment();
		//MutablePropertySources propertySources = environment.getPropertySources();
		List<String> xmlConfiguration = new ArrayList<>();
		
		for(String entry : configurationXml) {
			if (entry.endsWith(".xml")) {
				xmlConfiguration.add(entry);
			} else {
				throw new IllegalArgumentException(String.format("Resources must be .xml not:", entry));
			}
		}
		
		context.load(xmlConfiguration.toArray(new String[xmlConfiguration.size()]));
		context.refresh();
		try {
			ProtoJettyServer.main(null);
		} catch (Exception e) {
			System.err.println("Error: Couldn't start up a Jetty server");
			System.exit(1);
		}
		log.info("Started Proto Spring Batch app");
	}
}