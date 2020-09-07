package kermisV2;

import java.util.Scanner;

public class KermisBalance {
	public boolean quitBool = false;
	public boolean rideOptions = true;
	public boolean adminOptions = false;
	
	double balance = 0;
	public static Attraction[] attractionArray;
	int taxCount = 0;
	
	KermisBalance(Attraction[] attractionArrayArg) {
		attractionArray = attractionArrayArg;
	}
	
	void updateBalance() {
		int totalEarnings = 0;
		for (int i = 0; i < attractionArray.length; i++) {
			totalEarnings += attractionArray[i].currentEarnings;
		}
		balance = totalEarnings;
	}
	
	// prints a list of the attractions names and the earnings per attraction
	void balancePerAttraction() {
		double totalEarnings = 0;
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
	void ticketsPerAttraction() {
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
	
	void formAttractionsList() {
		String attractionsString = "";
		for (int i = 0; i < attractionArray.length; i++) {
			Attraction thisAttraction = attractionArray[i];
			int attNum = i + 1;
			attractionsString += attNum + ". " + thisAttraction.name + "   ";
		}
		System.out.println(attractionsString);
	}
	
	
	
	// asks user for input when having the option to ride attractions
	public void rideOptionsCommand() {
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
		boolean inputIsInt = false;
		try {
			inputAsInt = Integer.parseInt(userInput);
			inputIsInt = true;
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
		
		// if input is int:
		if (inputIsInt && inputAsInt <= attractionArray.length && inputAsInt > 0) {
			attractionArray[inputAsInt - 1].rideAttraction();
		}
		else {
			System.out.println("***** Please enter a valid command. *****");
		}
	}
	
	// asks user for input when having the option to check balance and ticket sales
	public void balanceOptionsCommand() {
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