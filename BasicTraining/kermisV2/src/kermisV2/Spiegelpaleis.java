package kermisV2;

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
