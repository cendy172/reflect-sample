package com.liqing;

import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.lang.reflect.InvocationTargetException;

import org.junit.Before;
import org.junit.Test;

public class CreateDuckUseReflectTest
{

	private CreateDuckUseReflect createDuckUseReflect;
	private Duck duck;

	@Before
	public void setUp() throws IllegalAccessException, InstantiationException, ClassNotFoundException
	{
		createDuckUseReflect = new CreateDuckUseReflect();
		duck = createDuckUseReflect.createDuck();
	}

	@Test
	public void shouldReturnADuckWhenCreateADuck() throws IllegalAccessException, InstantiationException,
			ClassNotFoundException
	{
		assertNotNull(duck);
	}

	@Test
	public void shouldReturnQuackVoiceWhenInvokeQuack() throws NoSuchMethodException, IllegalAccessException,
			InvocationTargetException
	{
		String quackVoice = createDuckUseReflect.invokeQuack();
		assertThat(quackVoice, is("I'm a duck"));
	}

	@Test
	public void shouldReturnQuackVoiceWithNameWhenSetName() throws NoSuchMethodException, IllegalAccessException,
			InvocationTargetException
	{
		String quackVoice = createDuckUseReflect.invokeQuackWithName("fake_name");
		assertThat(quackVoice, is("My name is fake_name"));
	}

	@Test
	public void shouldReturnVoiceWhenWithNameAndDescription() throws NoSuchMethodException, IllegalAccessException,
			InvocationTargetException
	{
		String quackVoice = createDuckUseReflect.invokeQuackWithNameAndDescription("Mallard", "fake_name");
		assertThat(quackVoice, is("A Mallard named fake_name is quacking"));
	}

	@Test
	public void shouldSetDuckDescriptionWhenSetIsMallard() throws NoSuchFieldException, IllegalAccessException
	{
		createDuckUseReflect.setDuckDescription("Mallard");
		assertThat(duck.toString(), is("I'm a Mallard"));
	}
}
