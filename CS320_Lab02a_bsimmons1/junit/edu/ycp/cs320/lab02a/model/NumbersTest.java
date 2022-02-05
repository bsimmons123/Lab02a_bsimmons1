package edu.ycp.cs320.lab02a.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NumbersTest {
	Numbers model;
	Double first;
	Double second;
	Double third;
	
	@Before
	public void setUp() {
		model = new Numbers();
		
		first = 1.5;
		second = 2.3;
		third = 3.7;
	}

	@Test
	public void FirstNumbertest() {
		model.setFirstNumber(first);
		
		assertEquals(first, model.getFirstNumber());
	}
	
	@Test
	public void SecondNumberTest() {
		model.setSecondNumber(second);
		
		assertEquals(second, model.getSecondNumber());
	}
	
	@Test
	public void ThirdNumberTest() {
		model.setThridNumber(third);
		
		assertEquals(third, model.getThirdNumber());
	}

}
