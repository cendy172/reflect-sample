package com.liqing.classes;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.liqing.Duck;

public class PublicClassReflect
{
	public PublicClass createPublicClassWithoutParameter() throws ClassNotFoundException, IllegalAccessException,
			InstantiationException, NoSuchMethodException, InvocationTargetException
	{
		// can work too
		// Class cls = Class.forName("com.liqing.classes.PublicClass");
		// return (PublicClass) cls.newInstance();
		Constructor<PublicClass> declaredConstructor = PublicClass.class.getDeclaredConstructor();
		declaredConstructor.setAccessible(true);
		return declaredConstructor.newInstance();
	}

	public PublicClass createPublicClassWithOneParameter(String description) throws NoSuchMethodException,
			IllegalAccessException, InvocationTargetException, InstantiationException
	{
		Constructor<PublicClass> ctor = PublicClass.class.getDeclaredConstructor(String.class);
		ctor.setAccessible(true);
		return ctor.newInstance(description);
	}

	public PublicClass createPublicClassWithTwoParameters(String description, Duck duck) throws NoSuchMethodException,
			IllegalAccessException, InvocationTargetException, InstantiationException
	{
		Constructor<PublicClass> ctor = PublicClass.class.getDeclaredConstructor(String.class, Duck.class);
		ctor.setAccessible(true);
		return ctor.newInstance(description, duck);
	}
}
