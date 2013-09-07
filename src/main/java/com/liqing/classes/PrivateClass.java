package com.liqing.classes;

import com.liqing.Duck;

public class PrivateClass
{
	private final String description;
	private final Duck duck;

	protected PrivateClass()
	{
		this.description = "";
		this.duck = null;
	}

	protected PrivateClass(String description)
	{
		this.description = description;
		this.duck = null;
	}

	protected PrivateClass(String description, Duck duck)
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
