package com.skilldistillery.jets.entities;

public class Fighter extends Jet {
	
	public Fighter(String role, String model, double speed, int range, long price) {
		super(role, model, speed, range, price);
	}
	
	public void missiles() {
		System.out.println("> " + getModel() + " fire fire fire. Fox 2!");
	}

	@Override
	public void fly() {
		System.out.println("> " + getModel() + " lurking above.");
		
	}
	
}
