package com.skilldistillery.jets.entities;

public class Surveillance extends Jet {
	
	public Surveillance(String role, String model, double speed, int range, long price) {
		super(role, model, speed, range, price);
	}
	
	public void surveil() {
		System.out.println("> " + getModel() + "surveillance commencing");
	}

	@Override
	public void fly() {
		System.out.println("> " + getModel()+ " flying high.");
		
	}

}
