package kermisV2;

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
