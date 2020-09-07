package kermisV2;

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