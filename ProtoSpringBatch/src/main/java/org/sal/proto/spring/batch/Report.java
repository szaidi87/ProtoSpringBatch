package org.sal.proto.spring.batch;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.sal.proto.jaxb.adapter.LocalDateAdapter;

@Setter @EqualsAndHashCode @ToString
@XmlRootElement(name="record")
public class Report {
	
	@Getter
	private int id;
	
	@Getter
	private BigDecimal sales;
	
	@Getter
	private int qty;
	
	@Getter
	private String staffName;
	
	@Getter
	private boolean processed;
	
	// Lombok doesn't work well with custom jaxb marshallers :(
	private LocalDate date;
	
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	public LocalDate getDate() {
		return date;
	}
}