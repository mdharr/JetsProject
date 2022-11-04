package com.skilldistillery.jets.entities;

public abstract class Jet {
	private String model;
	
//	public void fly() {
//		System.out.println("Flying!");
//	}
	
	// each jet must define fly method for itself
	public abstract void fly();

}
