package com.liqing.classes;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import com.liqing.Duck;
import com.liqing.reflect.ProtectedClassReflect;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProtectedClassReflectTest
{

	private ProtectedClassReflect protectedClassReflect;
	private ProtectedClass protectedClass;

	@Before
	public void setUp()
	{
		protectedClassReflect = new ProtectedClassReflect();
	}

	@Test
	public void shouldReturnAProtectedClassWhenCreateWithoutParameter() throws Exception
	{
		protectedClass = protectedClassReflect.createProtectedClassWithoutParameter();
		assertNotNull(protectedClass);
		assertThat(protectedClass.getDescription(), is(""));
		assertNull(protectedClass.getDuck());
	}

    @Test
    public void shouldReturnAProtectedClassWhenCreateWithOneParameter() throws Exception
    {
        protectedClass = protectedClassReflect.createProctedClassWithOneParameter("fake_description");
        assertNotNull(protectedClass);
        assertThat(protectedClass.getDescription(), is("fake_description"));
        assertNull(protectedClass.getDuck());
    }

    @Test
    public void shouldReturnAProtectedClassWhenCreateWithTwoParameters() throws Exception
    {
        protectedClass = protectedClassReflect.createProctedClassWithTwoParameter("fake_description", new Duck("fake_duck"));
        assertNotNull(protectedClass);
        assertThat(protectedClass.getDescription(), is("fake_description"));
        assertNotNull(protectedClass.getDuck());
    }

	@After
	public void tearDown()
	{
		protectedClass = null;
	}
}
