package org.sal.proto.spring.batch.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import lombok.val;
import lombok.extern.slf4j.Slf4j;

import org.sal.proto.spring.batch.Report;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

@Slf4j
public class ReportFieldSetMapper implements FieldSetMapper<Report> {

	private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	@Override
	public Report mapFieldSet(FieldSet fieldSet) throws BindException {
		Report report = new Report();
		report.setId(fieldSet.readInt(0));
		report.setSales(fieldSet.readBigDecimal(1));
		report.setQty(fieldSet.readInt(2));
		report.setStaffName(fieldSet.readString(3));
		val date = fieldSet.readString(4);
		try {
			report.setDate(LocalDate.parse(date, DATE_FORMAT));
		} catch (DateTimeParseException e) {
			log.error("Couldn't parse date {} because it was not of the format \"dd/MM/yyyy\"", date);
		}
		return report;
	}
}