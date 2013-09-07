package com.liqing.reflect;

import java.lang.reflect.Constructor;

import com.liqing.Duck;
import com.liqing.classes.PublicClass;

public class PublicClassReflect
{
	public PublicClass createPublicClassWithoutParameter() throws Exception
	{
		// can work too, only for public constructor
		// Class cls = Class.forName("com.liqing.classes.PublicClass");
		// return (PublicClass) cls.newInstance();
		Constructor<PublicClass> declaredConstructor = PublicClass.class.getDeclaredConstructor();
		declaredConstructor.setAccessible(true);
		return declaredConstructor.newInstance();
	}

	public PublicClass createPublicClassWithOneParameter(String description) throws Exception
	{
		Constructor<PublicClass> ctor = PublicClass.class.getDeclaredConstructor(String.class);
		ctor.setAccessible(true);
		return ctor.newInstance(description);
	}

	public PublicClass createPublicClassWithTwoParameters(String description, Duck duck) throws Exception
	{
		Constructor<PublicClass> ctor = PublicClass.class.getDeclaredConstructor(String.class, Duck.class);
		ctor.setAccessible(true);
		return ctor.newInstance(description, duck);
	}
}
