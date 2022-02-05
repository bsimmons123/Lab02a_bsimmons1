package edu.ycp.cs320.lab02a.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.lab02a.model.Numbers;
import edu.ycp.cs320.lab02a.controller.NumbersController;

public class NumbersControllerTest {
	private Numbers model;
	private NumbersController controller;
	
	private Double first;
	private Double second;
	private Double third;
	private Double result;
	
	@Before
	public void setUp() {
		model = new Numbers();
		controller = new NumbersController();
		controller.setModel(model);
		
		first = 1.5;
		second = 2.3;
		third = 3.7;
	}

	@Test
	public void AddNumberstest() {
		model.setFirstNumber(first);
		model.setSecondNumber(second);
		model.setThridNumber(third);
		
		assertEquals(first, model.getFirstNumber());
		assertEquals(second, model.getSecondNumber());
		assertEquals(third, model.getThirdNumber());
		
		result = controller.add();
		
		model.setResult(result);
		System.out.println("Adding Result: " + result);
		assertEquals(result, model.getResult());
	}
	
	@Test
	public void MultiplyNumberstest() {
		model.setFirstNumber(first);
		model.setSecondNumber(second);
		
		assertEquals(first, model.getFirstNumber());
		assertEquals(second, model.getSecondNumber());
		
		result = controller.multiply();
		System.out.println("Multiply Result: " + result);
		model.setResult(result);
		
		assertEquals(result, model.getResult());
	}

}
