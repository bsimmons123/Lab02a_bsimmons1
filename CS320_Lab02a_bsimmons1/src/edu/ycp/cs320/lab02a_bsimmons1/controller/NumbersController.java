package edu.ycp.cs320.lab02a_bsimmons1.controller;

import edu.ycp.cs320.lab02a_bsimmons1.model.Numbers;

public class NumbersController {
	private Numbers model;
	
	public void setModel(Numbers model) {
		this.model = model;
	}
	
	public Double add() {
		return model.getFirst() + model.getSecond() + model.getThird();
	}
	
	public Double multiply() {
		return model.getFirst() * model.getSecond();
	}
	
}
