package com.liqing;

public class Duck
{

	private String description = "";

	public Duck()
	{

	}

	public Duck(String description)
	{
		this.description = description;
	}

	public String quack()
	{
		return "I'm a duck";
	}

	public String quack(String name)
	{
		return "My name is " + name;
	}

	public String quack(String description, String name)
	{
		return "A " + description + " named " + name + " is quacking";
	}

	@Override
	public String toString()
	{
		return "I'm a " + this.description;
	}
}
