package org.sal.proto.jaxb.adapter;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

	@Override
	public String marshal(LocalDate date) throws Exception {
		return date.toString();
	}

	@Override
	public LocalDate unmarshal(String value) throws Exception {
		return LocalDate.parse(value);
	}
}