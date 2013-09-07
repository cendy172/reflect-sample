package com.liqing.classes;

import java.lang.reflect.Constructor;

import com.liqing.Duck;

public class PrivateClassReflect
{

	public PrivateClass createPrivateClassWithoutParameter() throws Exception
	{
		// can work too, only for public constructor
		// Class<?> cls = getClass().getClassLoader().loadClass("com.liqing.classes.PrivateClass");
		// Class<?> cls = Class.forName("com.liqing.classes.PrivateClass");
		// return (PrivateClass) cls.newInstance();

		Constructor<PrivateClass> constructorWithOneParameter = PrivateClass.class.getDeclaredConstructor();
		return constructorWithOneParameter.newInstance();
	}

	public PrivateClass createPrivateClassWithoutParameter(String description) throws Exception
	{
		Constructor<PrivateClass> constructorWithOneParameter = PrivateClass.class.getDeclaredConstructor(String.class);
		return constructorWithOneParameter.newInstance(description);
	}

	public PrivateClass createPrivateClassWithoutParameter(String description, Duck duck) throws Exception
	{
		Constructor<PrivateClass> constructorWithTwoParameters = PrivateClass.class.getDeclaredConstructor(
				String.class, Duck.class);
		return constructorWithTwoParameters.newInstance(description, duck);
	}
}
