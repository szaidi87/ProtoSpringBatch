package org.sal.proto.spring.batch.processor;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import org.sal.proto.spring.batch.Report;
import org.springframework.batch.item.ItemProcessor;

@Slf4j
public class CustomItemProcessor implements ItemProcessor<Report, Report> {

	@Override
	public Report process(@NonNull Report item) throws Exception {
		log.info("Processing item: {}", item);
		item.setProcessed(true);
		return item;
	}
}