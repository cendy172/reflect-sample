package com.liqing;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.liqing.testframework.TestRunner;

public class TestRunnerTest
{
	@Test
	public void shouldTestAllTests() throws Exception
	{
		TestRunner testRunner = new TestRunner();
		int num = testRunner.testAllTests();
		assertThat(num, is(12));
	}
}
