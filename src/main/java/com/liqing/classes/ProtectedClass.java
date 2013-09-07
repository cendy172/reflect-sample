package com.liqing.classes;

import com.liqing.Duck;

public class ProtectedClass
{
	private final String description;
	private final Duck duck;

	protected ProtectedClass()
	{
		this.description = "";
		this.duck = null;
	}

	protected ProtectedClass(String description)
	{
		this.description = description;
		this.duck = null;
	}

	protected ProtectedClass(String description, Duck duck)
	{
		this.description = description;
		this.duck = duck;
	}

	public Duck getDuck()
	{
		return duck;
	}

	public String getDescription()
	{
		return this.description;
	}
}
