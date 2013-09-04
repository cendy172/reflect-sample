package com.liqing;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import com.liqing.testframework.Case;

public class DuckTest
{

	private Duck duck;

	@Case
	public void setUp()
	{
		duck = new Duck();
	}

	@Case
	public void shouldQuackWhenDuckIsQuacking()
	{
		String quackVoice = duck.quack();
		assertThat(quackVoice, is("I'm a duck"));
	}

	@Case
	public void shouldQuackWithNameWhenDuckIsQuacking()
	{
		String quackVoice = duck.quack("fake_name");
		assertThat(quackVoice, is("My name is fake_name"));
	}

	@Case
	public void shouldReturnQuackVoiceWhenSetNameAndDescription()
	{
		String quackVoice = duck.quack("Mallard", "fake_name");
		assertThat(quackVoice, is("A Mallard named fake_name is quacking"));
	}

	@Case
	public void shouldReturnDescriptionWhenToString()
	{
		String description = duck.toString();
		assertThat(description, is("I'm a "));
	}
}
