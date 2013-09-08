package com.liqing.metod;

import com.liqing.Duck;

public class PublicClassWithMethods
{
	private String description;

	private Duck duck;

	private PublicClassWithMethods()
	{
		this.description = "";
		this.duck = null;
	}

	public void setDuck(Duck duck)
	{
		this.duck = duck;
	}

	public void setDescription(String description)
	{

		this.description = description;
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
