package com.liqing.testframework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestRunner
{
	private int num = 0;

	public int testAllTests() throws ClassNotFoundException, IllegalAccessException, InstantiationException,
			InvocationTargetException
	{
		Class<?> duckTest = Class.forName("com.liqing.DuckTest");
		Object o = duckTest.newInstance();
		Method[] declaredMethods = duckTest.getDeclaredMethods();
		for (Method method : declaredMethods)
		{
			if (method.isAnnotationPresent(Case.class))
			{
				method.invoke(o);
				num++;
			}
		}
		return num;
	}
}
