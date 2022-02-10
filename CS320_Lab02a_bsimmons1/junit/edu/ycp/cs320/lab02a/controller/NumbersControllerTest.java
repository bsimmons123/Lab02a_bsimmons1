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
		model.setFirst(first);
		model.setSecond(second);
		model.setThrid(third);
		
		assertEquals(first, model.getFirst());
		assertEquals(second, model.getSecond());
		assertEquals(third, model.getThird());
		
		result = controller.add();
		
		model.setResult(result);
		System.out.println("Adding Result: " + result);
		assertEquals(result, model.getResult());
	}
	
	@Test
	public void MultiplyNumberstest() {
		model.setFirst(first);
		model.setSecond(second);
		
		assertEquals(first, model.getFirst());
		assertEquals(second, model.getSecond());
		
		result = controller.multiply();
		System.out.println("Multiply Result: " + result);
		model.setResult(result);
		
		assertEquals(result, model.getResult());
	}

}
