package com.liqing.classes;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import com.liqing.reflect.PrivateClassReflect;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.liqing.Duck;

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

	@Test
	public void shouldReturnAPrivateClassWhenCreateWithOneParameter() throws Exception
	{
		privateClass = privateClassReflect.createPrivateClassWithOneParameter("fake_description");
		assertNotNull(privateClass);
		assertThat(privateClass.getDescription(), is("fake_description"));
		assertNull(privateClass.getDuck());
	}

	@Test
	public void shouldReturnAPrivateClassWhenCreateWithTwoParameters() throws Exception
	{
		privateClass = privateClassReflect.createPrivateClassWithTwoParameters("fake_description", new Duck("fake_duck"));
		assertNotNull(privateClass);
		assertThat(privateClass.getDescription(), is("fake_description"));
		assertNotNull(privateClass.getDuck());
	}

	@After
	public void tearDown()
	{
		privateClass = null;
	}
}
