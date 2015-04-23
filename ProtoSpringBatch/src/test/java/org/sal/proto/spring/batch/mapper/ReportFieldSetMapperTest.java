package org.sal.proto.spring.batch.mapper;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Test;
import org.sal.proto.spring.batch.Report;
import org.springframework.batch.item.file.transform.DefaultFieldSet;
import org.springframework.validation.BindException;

import static org.junit.Assert.assertEquals;

public class ReportFieldSetMapperTest {
	
	private final ReportFieldSetMapper reportFieldSetMapper = new ReportFieldSetMapper();
	
	@Test
	public void mapFieldSetToReportTest() throws BindException {
		DefaultFieldSet fieldSet = new DefaultFieldSet(new String[]{"1", "123,456", "789", "Salmaan Zaidi", "21/04/2015"});
		Report report = reportFieldSetMapper.mapFieldSet(fieldSet);
		Report expectedReport = getReport();
		expectedReport.setDate(LocalDate.of(2015, 04, 21));
		assertEquals(expectedReport, report);
	}
	
	@Test
	public void mapFieldWithIncorrectDateFormatTest() throws BindException {
		DefaultFieldSet fieldSet = new DefaultFieldSet(new String[]{"1", "123,456", "789", "Salmaan Zaidi", "2015-04-21"});
		Report report = reportFieldSetMapper.mapFieldSet(fieldSet);
		Report expectedReport = getReport();
		expectedReport.setDate(null);
		assertEquals(expectedReport, report);
	}
	
	private Report getReport() {
		Report report = new Report();
		report.setId(1);
		report.setSales(BigDecimal.valueOf(123456));
		report.setQty(789);
		report.setStaffName("Salmaan Zaidi");
		return report;
	}
}