package kermisV2;

class Ladderklimmen extends Attraction implements GamblingAttraction{
	Ladderklimmen(String name) {
		this.name = name;
		this.ticketPrice = 5.00;
	}
	
	// override
	void rideAttraction() {
		ticketsSold++;
		currentEarnings += ticketPrice;
		System.out.println("=> visiting " + name);
	}
	
	public void reserveForTax() {
		currentEarnings *= 0.3; 
	}
}
