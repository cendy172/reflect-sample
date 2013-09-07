package com.liqing.reflect;

import java.lang.reflect.Constructor;

import com.liqing.Duck;
import com.liqing.classes.ProtectedClass;

public class ProtectedClassReflect
{

	public ProtectedClass createProtectedClassWithoutParameter() throws Exception
	{
		Constructor<ProtectedClass> cls = ProtectedClass.class.getDeclaredConstructor();
		return cls.newInstance();
	}

	public ProtectedClass createProctedClassWithOneParameter(String description) throws Exception
	{
		Constructor<ProtectedClass> cls = ProtectedClass.class.getDeclaredConstructor(String.class);
		return cls.newInstance(description);
	}

	public ProtectedClass createProctedClassWithTwoParameter(String description, Duck duck) throws Exception
	{
		Constructor<ProtectedClass> cls = ProtectedClass.class.getDeclaredConstructor(String.class, Duck.class);
		return cls.newInstance(description, duck);
	}
}
