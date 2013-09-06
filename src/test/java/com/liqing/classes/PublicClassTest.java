package com.liqing.classes;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

import com.liqing.Duck;

public class PublicClassTest
{

	private PublicClass publicClass;

	@Test
	public void shouldCreateAPublicClassWithNoParameter()
	{
//		publicClass = new PublicClass();
//		assertThat(publicClass.getDescription(), is(""));
	}

	@Test
	public void shouldCreateAPublicClassWithOneParameter()
	{
		// publicClass = new PublicClass("fake_description");
		// assertThat(publicClass.getDescription(), is("fake_description"));
	}

	@Test
	public void shouldCreateAPublicClassWithTwoParameter()
	{
//		publicClass = new PublicClass("fake_description", new Duck("fake_duck"));
//		assertThat(publicClass.getDescription(), is("fake_description"));
//		assertThat(publicClass.getDuck().toString(), is("I'm a fake_duck"));
	}
}
