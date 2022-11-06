package com.skilldistillery.jets.entities;

import java.util.Objects;

public abstract class Jet {
	private String role;
	private String model;
	private double speed;
	private int range;
	private long price;
	
//	public void fly() {
//		System.out.println("Flying!");
//	}
	public Jet() {
		
	}
	
	public Jet(String role, String model, double speed, int range, long price) {
		this.role = role;
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}
	
	// each jet must define fly method for itself
	public abstract void fly();

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(model, price, range, role, speed);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jet other = (Jet) obj;
		return Objects.equals(model, other.model) && price == other.price && range == other.range
				&& Objects.equals(role, other.role)
				&& Double.doubleToLongBits(speed) == Double.doubleToLongBits(other.speed);
	}

	@Override
	public String toString() {
		return "Aircraft [role=" + role + ", model=" + model + ", speed=" + speed + ", range=" + range + ", price="
				+ price + "]";
	}
	
	

}
