package com.liqing;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class DuckTest
{

	private Duck duck;

	@Before
	public void setUp()
	{
		duck = new Duck();
	}

	@Test
	public void shouldQuackWhenDuckIsQuacking()
	{
		String quackVoice = duck.quack();
		assertThat(quackVoice, is("I'm a duck"));
	}

	@Test
	public void shouldQuackWithNameWhenDuckIsQuacking()
	{
		String quackVoice = duck.quack("fake_name");
		assertThat(quackVoice, is("My name is fake_name"));
	}

	@Test
	public void shouldReturnQuackVoiceWhenSetNameAndDescription()
	{
		String quackVoice = duck.quack("Mallard", "fake_name");
		assertThat(quackVoice, is("A Mallard named fake_name is quacking"));
	}

	@Test
	public void shouldReturnDescriptionWhenToString()
	{
		String description = duck.toString();
		assertThat(description, is("I'm a "));
	}
}
