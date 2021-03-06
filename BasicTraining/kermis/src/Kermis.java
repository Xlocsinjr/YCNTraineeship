/**
 * 
 * @author Xander Locsin
 *
 **/

import java.util.Scanner;

public class Kermis {
	public static void main(String[] args) {
		// make all the attractions
		BotsAutos bumper = new BotsAutos();
		Spin spider = new Spin();
		Spiegelpaleis mirrors = new Spiegelpaleis();
		Spookhuis haunt = new Spookhuis();
		Hawaii hawaii = new Hawaii();
		Ladderklimmen ladders = new Ladderklimmen();

		Attraction[] attractionArray = {bumper, spider, mirrors, haunt, hawaii, ladders};
		
		
		KermisBalance kBalance = new KermisBalance(attractionArray);		
        
		
		while (!KermisBalance.quitBool) {
			while (KermisBalance.rideOptions) {
				KermisBalance.rideOptionsCommand();
				System.out.println("=========================================");
			}
			while (kBalance.adminOptions) {
				KermisBalance.balanceOptionsCommand();
				System.out.println("=========================================");
			}		
		} // quitbool while loop
	} // main
} // public class



// ==============================================================


class KermisBalance {
	public static boolean quitBool = false;
	public static boolean rideOptions = true;
	public static boolean adminOptions = false;
	
	static float balance = 0;
	public static Attraction[] attractionArray;
	
	KermisBalance(Attraction[] attractionArrayArg) {
		attractionArray = attractionArrayArg;
	}
	
	
	// prints a list of the attractions names and the earnings per attraction
	static void balancePerAttraction() {
		float totalEarnings = 0;
		System.out.println("________________________________________________");
		System.out.println(padStringToLength("Attraction:", 15)  
				+ "earnings:");

		for (int i = 0; i < attractionArray.length; i++) {
			Attraction thisAttraction = attractionArray[i];
			totalEarnings += thisAttraction.currentEarnings;
			System.out.println(
				padStringToLength(thisAttraction.name, 15) 
				+ padStringToLength(String.valueOf(thisAttraction.currentEarnings), 15));
		}
		
		System.out.println("total balance:     " + totalEarnings);
		System.out.println("________________________________________________");
		balance = totalEarnings;
	}
	
	// prints a list of the attractions names and the tickets sold per attraction
	static void ticketsPerAttraction() {
		System.out.println("________________________________________________");
		System.out.println(padStringToLength("Attraction:", 15)  
				+ padStringToLength("tickets sold:", 15));

		for (int i = 0; i < attractionArray.length; i++) {
			Attraction thisAttraction = attractionArray[i];
			System.out.println(
				padStringToLength(thisAttraction.name, 15) 
				+ padStringToLength(String.valueOf(thisAttraction.ticketsSold), 15));
		}
		System.out.println("________________________________________________");
	}
	
	// pads a string to a given length with spaces
	public static String padStringToLength(String stringArg, int padArg) {
		int oldStringLength = stringArg.length();
		String newString = stringArg;
		
		if (padArg > oldStringLength){
			newString = String.format("%-" + padArg  + "s", newString);			
		}
		return newString;
	}
	
	static void formAttractionsList() {
		String attractionsString = "";
		for (int i = 0; i < attractionArray.length; i++) {
			Attraction thisAttraction = attractionArray[i];
			int attNum = i + 1;
			attractionsString += attNum + ". " + thisAttraction.name + "   ";
		}
		System.out.println(attractionsString);
	}
	
	
	
	// asks user for input when having the option to ride attractions
	public static void rideOptionsCommand() {
		boolean validCommand = false;
		Scanner scanner = new Scanner(System.in);
		
		// prints instructions for the user
		System.out.println("Enter a number to ride an attraction or enter a command letter:");
		formAttractionsList();		
		System.out.println("b: to check balances and ticket sales   q: to quit.");
		
		String userInput = scanner.nextLine(); 
		int inputAsInt = 0;
		
		// tries parsing the input to an integer
		// if possible; the user will ride corresponding attraction
		try {
			inputAsInt = Integer.parseInt(userInput);
			if (inputAsInt <= attractionArray.length && inputAsInt > 0) {
				attractionArray[inputAsInt - 1].rideAttraction();
			}
			else {
				System.out.println("***** Please enter a valid command. *****");
			}
		}
		// if not possible to parse input to int: check if one of the other commands were given
		catch (Exception e){
			if (userInput.equals("q")) {
				System.out.println("***** quitting ... *****");
				quitBool = true;
				rideOptions = false;
				adminOptions = false;
			}
			else if (userInput.equals("b")) {
				System.out.println("***** balances and ticket sales *****");
				rideOptions = false;
				adminOptions = true;
			}
			else {
				System.out.println("***** Please enter a valid command. *****");
			}
		}
	}
	
	// asks user for input when having the option to check balance and ticket sales
	public static void balanceOptionsCommand() {
		boolean validCommand = false;
		Scanner scanner = new Scanner(System.in);
		
		// prints instructions for the user
		System.out.println("Enter a number to check an attraction's balance and ticet sales or enter a command letter:");
		formAttractionsList();		
		System.out.println("a: to ride attractions   o: check total revenue   k: all ticket sales   q: to quit.");
		
		String userInput = scanner.nextLine(); 
		int inputAsInt = 0;
		
		// tries parsing the input to an integer
		// if possible; checks corresponding attraction's balance and ticket sales
		try {
			inputAsInt = Integer.parseInt(userInput);
			if (inputAsInt <= attractionArray.length && inputAsInt > 0) {
				attractionArray[inputAsInt - 1].declareRevenue();
			}
			else {
				validCommand = false;
				System.out.println("***** Please enter a valid command. *****");
			}
		}
		// if not possible to parse input to int: check if one of the other commands were given
		catch (Exception e){
			if (userInput.equals("q")) {
				System.out.println("***** quitting ... *****");
				quitBool = true;
				rideOptions = false;
				adminOptions = false;
			}
			else if (userInput.equals("a")) {
				System.out.println("***** Ride attractions *****");
				rideOptions = true;
				adminOptions = false;
			}
			else if (userInput.equals("o")) {
				System.out.println("***** checking revenue *****");
				balancePerAttraction();
			}
			else if (userInput.equals("k")) {
				System.out.println("***** checking ticket sales *****");
				ticketsPerAttraction();
			}
			else {
				System.out.println("***** Please enter a valid command. *****");
			}
		}
	}
	
	
}

class Attraction {	
	String name;
	float surfaceArea;
	float ticketPrice;
	int ticketsSold;
	float currentEarnings;
	
	void rideAttraction() {}
	
	void declareRevenue() {
		System.out.println("name: " + name);
		System.out.println("tickets sold: " + ticketsSold);
		System.out.println("revenue: " + currentEarnings);
	}
}

class BotsAutos extends Attraction {
	String name = "Botsautos";
	float ticketPrice = (float)2.50;
	
	// overwrite the name and ticketPrice of the parent object
	BotsAutos() {
		super.name = this.name;
		super.ticketPrice = this.ticketPrice;
	}
	
	// override
	void rideAttraction(){
		super.ticketsSold++;
		super.currentEarnings += ticketPrice;
		System.out.println("=> riding " + name);
	}
}

class Spin extends Attraction {
	String name = "Spin";
	float ticketPrice = (float)2.25;
	
	Spin() {
		super.name = this.name;
		super.ticketPrice = this.ticketPrice;
	}
	
	// override
	void rideAttraction(){
		ticketsSold++;
		currentEarnings += ticketPrice;
		System.out.println("=> riding " + name);
	}	
	
}

class Spiegelpaleis extends Attraction {
	String name = "Spiegelpaleis";
	float ticketPrice = (float)2.75;
	
	Spiegelpaleis() {
		super.name = this.name;
		super.ticketPrice = this.ticketPrice;
	}
	
	// override
	void rideAttraction(){
		ticketsSold++;
		currentEarnings += ticketPrice;
		System.out.println("=> riding " + name);
	}	
	
}

class Spookhuis extends Attraction {
	String name = "Spookhuis";
	float ticketPrice = (float)3.20;
	
	Spookhuis() {
		super.name = this.name;
		super.ticketPrice = this.ticketPrice;
	}
	
	// override
	void rideAttraction(){
		ticketsSold++;
		currentEarnings += ticketPrice;
		System.out.println("=> riding " + name);
	}	
	
}

class Hawaii extends Attraction {
	String name = "Hawaii";
	float ticketPrice = (float)2.90;
	
	Hawaii() {
		super.name = this.name;
		super.ticketPrice = this.ticketPrice;
	}
	
	// override
	void rideAttraction(){
		ticketsSold++;
		currentEarnings += ticketPrice;
		System.out.println("=> riding " + name);
	}
	
}

class Ladderklimmen extends Attraction {
	String name = "Ladderklimmen";
	float ticketPrice = (float)5.00;
	
	Ladderklimmen() {
		super.name = this.name;
		super.ticketPrice = this.ticketPrice;
	}
	
	// override
	void rideAttraction() {
		ticketsSold++;
		currentEarnings += ticketPrice;
		System.out.println("=> riding " + name);
	}
}


