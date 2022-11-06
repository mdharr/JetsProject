package com.skilldistillery.jets.entities;

public class Bomber extends Jet {
	
	public Bomber(String role, String model, double speed, int range, long price) {
		super(role, model, speed, range, price);
	}
	
	public void bomb() {
		System.out.println("> " + getModel() + " dropping the package.");
	}

	@Override
	public void fly() {
		System.out.println("> " + getModel() + " soaring undetected. ");
		
	}

}
