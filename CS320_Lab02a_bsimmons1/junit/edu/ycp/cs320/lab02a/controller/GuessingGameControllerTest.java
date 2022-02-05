package edu.ycp.cs320.lab02a.controller;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.lab02a.controller.GuessingGameController;
import edu.ycp.cs320.lab02a.model.GuessingGame;

public class GuessingGameControllerTest {
	private GuessingGame guessingModel;
	private GuessingGameController guessingController;
	
	@Before
	public void setUp() {
		guessingModel = new GuessingGame();
		guessingController = new GuessingGameController();
		
		guessingModel.setMin(1);
		guessingModel.setMax(100);
		
		guessingController.setModel(guessingModel);
	}
	
	@Test
	public void testNumberIsGreater() {
		int currentGuess = guessingModel.getGuess();
		guessingController.setNumberIsGreaterThanGuess();
		assertTrue(guessingModel.getGuess() > currentGuess);
	}
	

}
