package com.liqing;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

import com.liqing.testframework.TestRunner;

public class TestRunnerTest
{
	@Test
	public void shouldTestAllTests() throws ClassNotFoundException, IllegalAccessException, InstantiationException,
			NoSuchFieldException, NoSuchMethodException, InvocationTargetException
	{
		TestRunner testRunner = new TestRunner();
		int num = testRunner.testAllTests();
		assertThat(num, is(5));
	}
}
