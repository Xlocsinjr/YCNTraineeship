package kermisV2;

class BotsAutos extends Attraction {
	// overwrite the name and ticketPrice of the parent object
	BotsAutos(String name) {
		this.name = name;
		this.ticketPrice = 2.50;
	}
	
	// override
	void rideAttraction(){
		super.ticketsSold++;
		super.currentEarnings += ticketPrice;
		System.out.println("=> visiting " + name);
	}
}
