package com.liqing.testframework;

import java.lang.reflect.Method;

public class TestRunner
{
	private int num = 0;

	public int testAllTests() throws Exception
	{
		Class<?> duckTest = Class.forName("com.liqing.DuckTest");
		Object duckTestObject = duckTest.newInstance();
		Method[] allDeclaredMethods = duckTest.getDeclaredMethods();
		for (Method testCaseMethod : allDeclaredMethods)
		{
			if (isTestCase(testCaseMethod))
			{
				invokeTestMethod(duckTest, duckTestObject, testCaseMethod);
			}
		}
		return this.num;
	}

	private void invokeTestMethod(Class<?> duckTest, Object testCaseObject, Method testCaseMethod) throws Exception
	{
		setUp(duckTest, testCaseObject);
		testCaseMethod.invoke(testCaseObject);
		tearDown(duckTest, testCaseObject);
		addInvokeCount();
	}

	private void tearDown(Class<?> duckTest, Object testCaseObject) throws Exception
	{
		duckTest.getDeclaredMethod("tearDown").invoke(testCaseObject);
		addInvokeCount();
	}

	private void setUp(Class<?> duckTest, Object testCaseObject) throws Exception
	{
		duckTest.getDeclaredMethod("setUp").invoke(testCaseObject);
		addInvokeCount();
	}

	private void addInvokeCount()
	{
		this.num++;
	}

	private boolean isTestCase(Method method)
	{
		return method.isAnnotationPresent(Case.class);
	}
}
