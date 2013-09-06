package com.liqing.classes;

public class PrivateClassReflect
{

	public PrivateClass createPrivateClassWithoutParameter() throws Exception
	{
		// can work too
		// Class<?> cls = getClass().getClassLoader().loadClass("com.liqing.classes.PrivateClass");
		Class<?> cls = Class.forName("com.liqing.classes.PrivateClass");
		return (PrivateClass) cls.newInstance();
	}

}
