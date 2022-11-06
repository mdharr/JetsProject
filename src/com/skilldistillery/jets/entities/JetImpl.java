package com.skilldistillery.jets.entities;

public class JetImpl extends Jet {
	
	public JetImpl(String role, String model, double speed, int range, long price) {
		super(role, model, speed, range, price);
	}

	@Override
	public void fly() {
		System.out.println("> " + getModel() + " has spread its wings and taken flight.");
	}
}
