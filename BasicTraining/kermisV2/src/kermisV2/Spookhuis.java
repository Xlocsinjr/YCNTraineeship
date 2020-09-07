package kermisV2;

class Spookhuis extends Attraction {
	Spookhuis(String name) {
		this.name = name;
		this.ticketPrice = 3.20;
	}
	
	// override
	void rideAttraction(){
		ticketsSold++;
		currentEarnings += ticketPrice;
		System.out.println("=> riding " + name);
	}	
	
}
