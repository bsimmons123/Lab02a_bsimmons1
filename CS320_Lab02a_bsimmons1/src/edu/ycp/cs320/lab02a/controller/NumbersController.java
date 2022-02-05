package edu.ycp.cs320.lab02a.controller;

import edu.ycp.cs320.lab02a.model.Numbers;

public class NumbersController {
	private Numbers model;
	
	public void setModel(Numbers model) {
		this.model = model;
	}
	
	public Double add() {
		return model.getFirstNumber() + model.getSecondNumber() + model.getThirdNumber();
	}
	
	public Double multiply() {
		return model.getFirstNumber() * model.getSecondNumber();
	}
	
}
