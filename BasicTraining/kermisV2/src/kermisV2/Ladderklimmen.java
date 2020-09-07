package kermisV2;

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
