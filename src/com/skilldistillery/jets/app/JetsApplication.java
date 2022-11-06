package com.skilldistillery.jets.app;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.skilldistillery.jets.entities.AirField;
import com.skilldistillery.jets.entities.Bomber;
import com.skilldistillery.jets.entities.Cargo;
import com.skilldistillery.jets.entities.Fighter;
import com.skilldistillery.jets.entities.Jet;
import com.skilldistillery.jets.entities.Surveillance;

public class JetsApplication {

	private static Scanner scanner = new Scanner(System.in);

	private AirField airfield = new AirField();

	private List<Jet> fleet = airfield.getFleet();
	private String userCallSign;

	public static void main(String[] args) {

		JetsApplication app = new JetsApplication();

		app.launch();

	}

	public void launch() {
		
		airfield.readAirField("jets.txt");
								
		airfield.titleScreen();

		start();

		menu();

	}


	public void start() {
		System.out.println();
		System.out.println("             ,,,,,,,,,,,,,,");
		System.out.println("> Welcome to |BLUE THUNDER|, Rookie.");
		System.out.println("             ''''''''''''''");
		while (true) {
			System.out.println("             ,,,,,,,,,,,");
			System.out.print("> Enter Your |CALL SIGN|: \n");
			System.out.println("             '''''''''''");
			userCallSign = scanner.nextLine();
			System.out.println();
			System.out.print("> You entered " + userCallSign + ", is that correct? (y/n) ");
			char userConfirm = scanner.next().charAt(0);
			System.out.println();
			scanner.nextLine();
			if (userConfirm == 'y') {
				System.out.println("> Affirmative, welcome to the fleet, " + userCallSign + ".");
				System.out.println();
				break;
			} else {
				continue;
			}

		}

		while (true) {
			System.out.println("                                 ,,,,,,,,,,,,,,,,");
			System.out.print("> Press the 'Enter' key to begin |BASIC TRAINING|: \n");
			System.out.println("                                 ''''''''''''''''");
			String userInput = scanner.nextLine();

			if (userInput.equals("")) {
				System.out.println("> That's the spirit, " + userCallSign + "! Now let's get to work!");
				break;
			} else {
				System.out.println();
				System.out.println("> THAT'S NOT THE ENTER KEY, " + userCallSign + "! TRY AGAIN!");
				System.out.println();
				continue;
			}
		}
	}

	public void menu() {
		System.out.println("  ,,,,,,,,,,,,,,,,");
		System.out.println("> |BASIC TRAINING|: ");
		System.out.println("  ''''''''''''''''");
		System.out.println("   ___________________________________________________________________________________________");
		System.out.println("   |               |                 |                       |                                |");
		System.out.println("   | 1) List Fleet | 2) Fly All Jets | 3) View Fastest Jet   | 4) View Jet With Longest Range |");
		System.out.println("   |---------------|-----------------|-----------------------|--------------------------------|");
		System.out.println("   |               |                 |                       |                                |");
		System.out.println("   | 5) Bomb       | 6) Attack       | 7) Add a Jet to Fleet | 8) Remove a Jet From Fleet     |");
		System.out.println("   |---------------'-----------------|-----------------------'--------------------------------|");
		System.out.println("   |                                 |                                                        |");
		System.out.println("   | 9) Quit                         | 0) Menu                                                |");
		System.out.println("   |_________________________________|________________________________________________________|");
		System.out.println();

		while (true) {
			System.out.println("> Input the corresponding number to get familiar with our aircraft's capabilities: ");
			System.out.println();
			System.out.println("> Enter '0' to see the Menu.");
			int userInput = Integer.parseInt(scanner.next());
			if (userInput == 1) {
				airfield.allJetsTogether();
				System.out.println();
//				System.out.println(airfield.getFleet());
				airfield.listFleet();
				System.out.println();
				banter();
				System.out.println();

			} else if (userInput == 2) {
				airfield.allJetsFlying();
				airfield.flyAllJets();
				banter();
				System.out.println();

			} else if (userInput == 3) {
				airfield.superFastJet();
				System.out.println();
				airfield.displayFastestJet();
				System.out.println();
				banter();
				System.out.println();

			} else if (userInput == 4) {
				airfield.longRangeJet();
				System.out.println();
				airfield.displayLongestRangeJet();
				banter();
				System.out.println();

			} else if (userInput == 5) {
				airfield.bombsAway();
				System.out.println();
				for (Jet jet : fleet) {
					if (jet instanceof Bomber) {
						((Bomber) jet).bomb();
						System.out.println();
					}
				}
				banter();
				System.out.println();

			} else if (userInput == 6) {
				airfield.missilesAway();
				System.out.println();
				for (Jet jet : fleet) {
					if (jet instanceof Fighter) {
						((Fighter) jet).missiles();
						System.out.println();
					}
				}
				banter();
				System.out.println();

			} else if (userInput == 7) {
				airfield.addJet(scanner);
				banter();
				System.out.println();

			} else if (userInput == 8) {
				airfield.removeJet(scanner);

				banter();
				System.out.println();
			} else if (userInput == 9) {
				System.out.println("> Are you sure you want to quit? (y/n) ");
				char userConfirm = scanner.next().charAt(0);
				if (userConfirm == 'y') {
					System.out.println();
					airfield.allJetsFlying();
					System.out.println();
					farewell();
					System.out.println("  ,,,,,,,,,,,,,,,,,,,,");
					System.out.println("> |Application Closed|");
					System.out.println("  ''''''''''''''''''''");
					System.exit(8);
					break;
				}
				continue;
			} else if (userInput == 0) {
				menu();
				
			} else {
				System.out.println("> Incorrect input, try again.");
				System.out.println();
//				continue;
			}
		}

	}

	public String banter() {

		String[] banter = { "> 'Talk to me, Goose.'", "> 'Let's turn and burn!'",
				"> 'You're not going to be happy unless you're going Mach 2 with your hair on fire.'",
				"> 'I feel the need... the need for speed!'", "> 'Remember, boys, no points for second place.'",
				"> 'It's classified. I could tell you, but then I'd have to kill you.'", "> 'Great balls of fire!'" };

		Random rand = new Random();
		String bant = banter[rand.nextInt(banter.length)];
		System.out.println(bant);
		return bant;
	}

	public String farewell() {

		String[] farewell = { "> Cya next time, Maverick.", "> Until next time, Ace.",
				"> Come back when you've got some sorties under your belt.", "> Stay sharp, Cadet.",
				"> Smell ya later, Rookie.", "> You can be my wingman anytime." };

		Random rand = new Random();
		String bye = farewell[rand.nextInt(farewell.length)];
		System.out.println(bye);
		return bye;
	}

}
