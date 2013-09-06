package com.liqing.classes;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.lang.reflect.InvocationTargetException;

import com.liqing.Duck;
import org.junit.Before;
import org.junit.Test;

public class PublicClassReflectTest
{

	private PublicClassReflect classReflect;
	private PublicClass publicClass;

	@Before
	public void setUp()
	{
		classReflect = new PublicClassReflect();
	}

	@Test
	public void shouldCreatePublicClassWithoutParameter() throws IllegalAccessException, InstantiationException,
            ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
		publicClass = classReflect.createPublicClassWithoutParameter();
		assertNotNull(publicClass);
		assertThat(publicClass.getDescription(), is(""));
		assertNull(publicClass.getDuck());
	}

	@Test
	public void shouldCreatePublicClassWithOneParameter() throws IllegalAccessException, InstantiationException,
			ClassNotFoundException, NoSuchMethodException, InvocationTargetException
	{
		publicClass = classReflect.createPublicClassWithOneParameter("fake_description");
		assertNotNull(publicClass);
		assertThat(publicClass.getDescription(), is("fake_description"));
		assertNull(publicClass.getDuck());
	}

	@Test
	public void shouldCreatePublicClassWithTwoParameters() throws IllegalAccessException, InstantiationException,
            ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        Duck duck = new Duck("fake_duck");
        String description = "fake_description";
        publicClass = classReflect.createPublicClassWithTwoParameters(description, duck);
		assertNotNull(publicClass);
		assertThat(publicClass.getDescription(), is("fake_description"));
		assertNotNull(publicClass.getDuck());
        assertThat(publicClass.getDuck().toString(), containsString("fake_duck"));
	}
}
