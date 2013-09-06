package com.liqing.classes;

import com.liqing.Duck;

public class PublicClass
{
	private final String description;

	private final Duck duck;

	private PublicClass()
	{
		this.description = "";
		this.duck = null;
	}

	private PublicClass(String description)
	{
		this.description = description;
		this.duck = null;
	}

	private PublicClass(String description, Duck duck)
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
