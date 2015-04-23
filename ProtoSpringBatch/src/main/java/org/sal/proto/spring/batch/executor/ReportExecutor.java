package org.sal.proto.spring.batch.executor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;

@Slf4j
@ManagedResource
@RequiredArgsConstructor
public class ReportExecutor {
	
	private final JobLauncher jobLauncher;
	private final Job job;
	private final JobParameters parameters = new JobParameters();
	
	@ManagedOperation
	public void runJob() {
		try {
			JobExecution execution = jobLauncher.run(job, parameters);
			log.info("Exit status: {}", execution.getStatus());
		} catch(Exception e) {
			log.error("Caught unexpected exception during batch job execution", e);
		}
	}
}