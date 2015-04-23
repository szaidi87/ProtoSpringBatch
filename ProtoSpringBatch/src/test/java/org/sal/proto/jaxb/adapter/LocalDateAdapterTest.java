package org.sal.proto.jaxb.adapter;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

public class LocalDateAdapterTest {
	
	private LocalDateAdapter localDateAdapter = new LocalDateAdapter();
	
	@Test
	public void marshalDateTest() throws Exception {
		Assert.assertEquals("2015-04-22", localDateAdapter.marshal(LocalDate.of(2015, 04, 22)));
	}
	
	@Test
	public void unmarshalDateTest() throws Exception {
		Assert.assertEquals(LocalDate.of(2015, 04, 22), localDateAdapter.unmarshal("2015-04-22"));
	}
}