package kermisV2;

class Spiegelpaleis extends Attraction {
	Spiegelpaleis(String name) {
		this.name = name;
		this.ticketPrice = 2.75;
	}
	
	// override
	void rideAttraction(){
		ticketsSold++;
		currentEarnings += ticketPrice;
		System.out.println("=> visiting " + name);
	}	
	
}
