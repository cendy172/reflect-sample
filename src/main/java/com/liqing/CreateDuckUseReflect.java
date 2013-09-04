package com.liqing;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CreateDuckUseReflect
{
	private Class cls;
	private Duck duck;

	public Duck createDuck() throws ClassNotFoundException, IllegalAccessException, InstantiationException
	{
		cls = Class.forName("com.liqing.Duck");
		duck = (Duck) cls.newInstance();
		return duck;
	}

	public String invokeQuack() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException
	{
		return String.valueOf(cls.getDeclaredMethod("quack").invoke(duck));
	}

	public void setDuckDescription(String description) throws NoSuchFieldException, IllegalAccessException
	{
		cls.getDeclaredField("description").setAccessible(true);
		if (cls.getDeclaredField("description") != null)
		{
			cls.getDeclaredField("description").set(duck, description);
		}
	}

	public String invokeQuackWithName(String name) throws NoSuchMethodException, InvocationTargetException,
			IllegalAccessException
	{
		return (String) cls.getDeclaredMethod("quack", String.class).invoke(duck, name);
	}

	public String invokeQuackWithNameAndDescription(String description, String name) throws NoSuchMethodException,
			InvocationTargetException, IllegalAccessException
	{
		Method quackWithNameAndDescription = null;
		Class[] parameters = new Class[2];
		parameters[0] = String.class;
		parameters[1] = String.class;

		quackWithNameAndDescription = cls.getDeclaredMethod("quack", parameters);
		return (String) quackWithNameAndDescription.invoke(duck, description, name);
	}
}
