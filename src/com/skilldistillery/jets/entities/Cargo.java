package com.skilldistillery.jets.entities;

public class Cargo extends Jet {
	
	public Cargo(String role, String model, double speed, int range, long price) {
		super(role, model, speed, range, price);
	}
	
	public void transport() {
		System.out.println("> " + getModel() + " transport commencing");
	}

	@Override
	public void fly() {
		System.out.println("> " + getModel() + " up and away.");
		
	}

}
