package com.liqing;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CreateDuckUseReflect
{
	private Class cls;
	private Duck duck;

	public Duck createDuck()
	{
		try
		{
			cls = Class.forName("com.liqing.Duck");
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		try
		{
			duck = (Duck) cls.newInstance();
		} catch (InstantiationException e)
		{
			e.printStackTrace();
		} catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
		return duck;
	}

	public String invokeQuack()
	{
		Method method = null;
		try
		{
			method = cls.getDeclaredMethod("quack");
		} catch (NoSuchMethodException e)
		{
			e.printStackTrace();
		}
		try
		{
			return String.valueOf(method.invoke(duck));
		} catch (IllegalAccessException e)
		{
			e.printStackTrace();
		} catch (InvocationTargetException e)
		{
			e.printStackTrace();
		}
		return "";
	}

	public void setDuckDescription(String description)
	{
		Field descriptionField = null;
		try
		{
			descriptionField = cls.getDeclaredField("description");
			descriptionField.setAccessible(true);
		} catch (NoSuchFieldException e)
		{
			e.printStackTrace();
		}
		if (descriptionField != null)
		{
			try
			{
				descriptionField.set(duck, description);
			} catch (IllegalAccessException e)
			{
				e.printStackTrace();
			}
		}
	}

	public String invokeQuackWithName(String name)
	{
		Method quackWithName = null;
		try
		{
			Class[] parameters =
			{ String.class };
			quackWithName = cls.getDeclaredMethod("quack", parameters);
		} catch (NoSuchMethodException e)
		{
			e.printStackTrace();
		}
		try
		{
			return (String) quackWithName.invoke(duck, name);
		} catch (IllegalAccessException e)
		{
			e.printStackTrace();
		} catch (InvocationTargetException e)
		{
			e.printStackTrace();
		}
		return "";
	}

	public String invokeQuackWithNameAndDescription(String description, String name)
	{
		Method quackWithNameAndDescription = null;
		try
		{
			Class[] parameters = new Class[2];
			parameters[0] = String.class;
			parameters[1] = String.class;

			quackWithNameAndDescription = cls.getDeclaredMethod("quack", parameters);
		} catch (NoSuchMethodException e)
		{
			e.printStackTrace();
		}
		try
		{
			return (String) quackWithNameAndDescription.invoke(duck, description, name);
		} catch (IllegalAccessException e)
		{
			e.printStackTrace();
		} catch (InvocationTargetException e)
		{
			e.printStackTrace();
		}
		return "";
	}
}
