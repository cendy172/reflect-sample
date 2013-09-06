package com.liqing.classes;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PrivateClassReflectTest
{

	private PrivateClassReflect privateClassReflect;
	private PrivateClass privateClass;

	@Before
	public void setUp()
	{
		privateClassReflect = new PrivateClassReflect();
	}

	@Test
	public void shouldReturnAPrivateClassWhenCreateWithoutParameter() throws Exception
	{
		privateClass = privateClassReflect.createPrivateClassWithoutParameter();
		assertNotNull(privateClass);
		assertThat(privateClass.getDescription(), is(""));
		assertNull(privateClass.getDuck());
	}

	@After
	public void tearDown()
	{
		privateClass = null;
	}
}
