package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class AirField {
	
	private ArrayList<Jet> fleet = new ArrayList<Jet>();
	private String role;
	private String model;
	private double speed;
	private int range;
	private long price;

	String fileName;

	public void readAirField(String fileName) {

		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line;
			while ((line = br.readLine()) != null) {
				String[] splitLine = line.split(",");
				role = splitLine[0];
				model = splitLine[1];
				speed = Double.parseDouble(splitLine[2]);
				range = Integer.parseInt(splitLine[3]);
				price = Long.parseLong(splitLine[4]);
				Jet jet = null;
				if (role.equalsIgnoreCase("Fighter")) {
					jet = new Fighter(role, model, speed, range, price);
				} else if (role.equalsIgnoreCase("Cargo")) {
					jet = new Cargo(role, model, speed, range, price);

				} else if (role.equalsIgnoreCase("Bomber")) {
					jet = new Bomber(role, model, speed, range, price);

				} else if (role.equalsIgnoreCase("Surveillance")) {
					jet = new Surveillance(role, model, speed, range, price);
				}

				fleet.add(jet);

			}
		} catch (IOException e) {
			System.err.println("Invalid filename: " + e.getMessage());
		}
	} // closes readAirField method

	public ArrayList<Jet> getFleet() {

		return fleet;

	}
	
	public void listFleet() {
		int i = 0;
		for(i = 0; i < fleet.size(); i++) {
			System.out.println("> " + fleet.get(i));
			System.out.println();
		}	
	}

	public void flyAllJets() {
	System.out.println();
		for (Jet jet : fleet) {
			jet.fly();
			System.out.println();
		}
		System.out.println();

	}

	public void displayFastestJet() {
		double fastest = 0;
		Jet fastestJet = fleet.get(0);
		for (Jet jet : fleet) {
			if (jet.getSpeed() > fastest) {
				fastest = jet.getSpeed();
				fastestJet = jet;
			}
		}
		System.out.println("> The fastest jet is " + fastestJet);
		System.out.println();

	}
	
	public void removeJet(Scanner scanner) {
		while(true) {
			System.out.println();
			int i = 0;
			for(i = 0; i < fleet.size(); i++) {
				System.out.println(i + ": " + fleet.get(i));
			}	
			System.out.println("Let's retire an aircraft unit from the fleet. Which'll it be?");
			int userNum = scanner.nextInt();
			if(userNum >= 0 && userNum <= fleet.size()) {
				fleet.remove(userNum);
				break;
			} else {
				System.out.println("That's not a valid input. Try again.");
				continue;
			}
			
		}

	}

	public void displayLongestRangeJet() {
		int longestRange = 0;
		Jet longestRangeJet = fleet.get(0);
		for (Jet jet : fleet) {
			if (jet.getRange() > longestRange) {
				longestRange = jet.getRange();
				longestRangeJet = jet;
			}
		}
		System.out.println("> The longest range jet is " + longestRangeJet);
		System.out.println();
	}

	public void addJet(Scanner scanner) {
		Jet jet = null;
		String role = "";
		String model = "";
		double speed = 0.0;
		int range = 0;
		long price = 0;

		System.out.println("> Ready to add a jet to the fleet, are ya? ");
		System.out.println("                      ,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
		System.out.println("> Please enter a role (Fighter, Bomber, Cargo, or Surveillance):");
		System.out.println("                      '''''''''''''''''''''''''''''''''''''''''");
		role = scanner.nextLine();
		System.out.println();
		scanner.nextLine();
		System.out.println("                 ,,,,,,,");
		System.out.println("> Please enter a |Model|: ");
		System.out.println("                 '''''''");
		model = scanner.nextLine();
		System.out.println();
		System.out.println("> Please enter top Speed: ");
		speed = scanner.nextDouble();
		System.out.println();
		System.out.println("> Please enter maximum Range: ");
		range = scanner.nextInt();
		System.out.println();
		System.out.println("> Please enter total Price: ");
		price = scanner.nextLong();
		System.out.println();
		jet = new JetImpl(role, model, speed, range, price);
		
		fleet.add(jet);
		System.out.println();

	}

	public void setFleet(ArrayList<Jet> fleet) {
		this.fleet = fleet;
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
	
	public void titleScreen() {
		System.out.println("   _____________________________________________________________________________");
		System.out.println("   |                                                                            |");
		System.out.println("   |                                                                            |");
		System.out.println("   |                                                                            |");
		System.out.println("   | -------------------====+====-------------------                            |");
		System.out.println("   |                     {_| |_}                                                |");
		System.out.println("   |                   /| _|_|_ |\\                                              |");
		System.out.println("   |                  ( |/_____\\| )                                             |");
		System.out.println("   |               |--`/_/  |   \\_\'--|                                          |");
		System.out.println("   |           ____   //( ) |    \\\\   ____                                      |");
		System.out.println("   |          | ++ |==|\\___/ \\___/|==| ++ |                                     |");
		System.out.println("   |           \\__/   |  ___ ___  |   \\__/                                      |");
		System.out.println("   |                 __\\/oo X []\\/__                                            |");
		System.out.println("   |                || [\\__/_\\__/] ||                                           |");
		System.out.println("   |               ~~~~             ~~~~                                        |");
		System.out.println("   |   ______  _____    ___  ___  _________                                     |");
		System.out.println("   |    | |__)  | |     | |  | |   | |___                                       |");
		System.out.println("   |    | |__)  | |_-|  | ```' |   | |_____                                     |");
		System.out.println("   |   ~~~~~~~ ~~~~~~~   ~~~~~~   ~~~~~~~~~                                     |");
		System.out.println("   |  _________ _____ _____ ___  ___ ____   ___ _______  _________ _______      |");
		System.out.println("   |  |_/| |\\_|  | |___| |  | |  | |  ||\\.. ||  | | \\ \\   | |___    | |__)      |");
		System.out.println("   |     | |     | |---| |  | ```' |  || `'\\||  | |_/ /   | |_____  | |``|\\_    |");
		System.out.println("   |    ~~~~~   ~~~~  ~~~~~  ~~~~~~  ~~~~   ~~~ ~~~~~~~  ~~~~~~~~~ ~~~~  ~~~~   |");
		System.out.println("   |                                                                            |");
		System.out.println("   |____________________________________________________________________________|");
		
	}
	
	public void longRangeJet() {
		
		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.println("| _____         ______                          |");
		System.out.println("| | : \\         |    \\                          |");
		System.out.println("| | :  `\\______|______\\_______                  |");
		System.out.println("|  \\'______              \\_____\\_____           |");
		System.out.println("|    \\____/-)_,---------,_____________>--       |");
		System.out.println("|              \\       /                        |");
	    System.out.println("|               |     /                         |");
	    System.out.println("|	       |____/__                         |");
	    System.out.println("-------------------------------------------------");
	    System.out.println();
	}
	
	public void allJetsTogether() {
		System.out.println("------------------------------------------");
		System.out.println("|            \\            /              |");
		System.out.println("|             \\    __    /               |");
		System.out.println("|  ____________\\.-|__|-./____________    |");
		System.out.println("|      + + ---\\__| \\/ |__/--- + +        |");
		System.out.println("|                 \\__/                   |");
		System.out.println("|                           __|__        |");
		System.out.println("|                __|__   *---o0o---*     |");
		System.out.println("|     __|__   *---o0o---*                |");
		System.out.println("|  *---o0o---*                           |");
		System.out.println("------------------------------------------");
	}
	
	public void allJetsFlying() {
		System.out.println(" -------------------------------------");	
		System.out.println(" | 	                             |");
		System.out.println(" |                      __|__        |");
		System.out.println(" |             __|__ *---oOo---*     |");
		System.out.println(" |    __|__ *---oOo---*              |");
		System.out.println(" | *---oOo---*                       |");
		System.out.println(" |                                   |");
		System.out.println(" -------------------------------------");
	}
	
	public void superFastJet() {
		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println("|  ______                                                                            |");
		System.out.println("|  L,.   ',                                                                          |");
		System.out.println("|   \\      ',_                                                                       |");
		System.out.println("|    \\   @   ',                                                                      |");
		System.out.println("|     \\ ^~^    ',                                                                    |");
		System.out.println("|      \\    NR   ',                                                                  |");
		System.out.println("|       \\___'98fw  ',_                          _..----.._                           |");
		System.out.println("|       [______       \"'==.I\\_____________..--\"<__\\\\_n@___4\\,_                       |");
		System.out.println("|     ,..-=T         __   ____________          \\/  \"'\" O<==  \"\"-+.._                |");
		System.out.println("|     I____|_____    }_>=========I>=**\"\"\'\'==-------------==-   \" |   \"'-.,___        |");
		System.out.println("|     [_____,.--'\"             _______         \"\"--=<\"\"-----=====+==--\'\'\"\"           |");
		System.out.println("|     \"\"'-=+..,,__,-----,_____|       |         -=* |                                |");
		System.out.println("|                 |__   /     |---,--'\"---+------+-'\"                                |");
		System.out.println("|                    \"\"\"     d\"b=\"        '-----+t                                   |");
		System.out.println("|                            q_p                '@                                   |");
		System.out.println("--------------------------------------------------------------------------------------");
		
	}
	
	public void bombsAway() {
	System.out.println("------------------------------------------------------------------");
  System.out.println("|                                        |                       |");
  System.out.println("|                 |                      |                       |");
  System.out.println("|                 |                    -/_\\-                     |");
  System.out.println("|               -/_\\-   ______________(/ . \\)______________      |");
  System.out.println("|  ____________(/ . \\)_____________    \\___/     <>              |");
  System.out.println("|  <>           \\___/      <>    <>                              |");
  System.out.println("|                                                                |");
  System.out.println("|     ||                                                         |");
  System.out.println("|     <>                                                         |");
  System.out.println("|                           ||                                   |");
  System.out.println("|                           <>                                   |");
  System.out.println("|                                        |                       |");
  System.out.println("|                                       ||            BIG        |");
  System.out.println("|       _____               __          <>      (^)))^ BOOM!     |");
  System.out.println("| BOOM!/((  )\\       BOOM!((  )))            (     ( )           |");
  System.out.println("|---- (__()__))          (() ) ))           (  (  (   )          |");
  System.out.println("|    ||  |||____|------    \\  (/   ___     (__\\     /__)         |");
  System.out.println("|     |__|||  |     |---|---|||___|   |___-----|||||             |");
  System.out.println("| |  ||.  |   |       |     |||                |||||             |");
  System.out.println("|     |__|||  |     |---|---|||___|   |___-----|||||             |");
  System.out.println("| |  ||.  |   |       |     |||                |||||             |");
  System.out.println("|                                                                |");
	System.out.println("------------------------------------------------------------------");
	}
	
	public void missilesAway() {
		System.out.println("------------------------------------------");
		System.out.println("|                                        |");
        System.out.println("|                |     |                 |");
        System.out.println("|                |  _  |                 |");
        System.out.println("|  ______________|_( )_|______________   |");
        System.out.println("|     o   +|+   [ ( o ) ]   +|+          |");
        System.out.println("|              *[_]---[_]*               |");
        System.out.println("|                                        |");
        System.out.println("------------------------------------------");
	}

	@Override
	public int hashCode() {
		return Objects.hash(fleet, model, price, range, role, speed);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AirField other = (AirField) obj;
		return Objects.equals(fleet, other.fleet) && Objects.equals(model, other.model) && price == other.price
				&& range == other.range && Objects.equals(role, other.role)
				&& Double.doubleToLongBits(speed) == Double.doubleToLongBits(other.speed);
	}

	@Override
	public String toString() {
		return "AirField [fleet=" + fleet + ", role=" + role + ", model=" + model + ", speed=" + speed + ", range="
				+ range + ", price=" + price + "]";
	}
	
	
}
