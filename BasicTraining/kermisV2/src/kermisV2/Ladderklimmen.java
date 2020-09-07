package kermisV2;

class Ladderklimmen extends Attraction {
	Ladderklimmen(String name) {
		this.name = name;
		this.ticketPrice = 5.00;
	}
	
	// override
	void rideAttraction() {
		ticketsSold++;
		currentEarnings += ticketPrice;
		System.out.println("=> riding " + name);
	}
}
