package kermisV2;

class Spookhuis extends Attraction {
	String name = "Spookhuis";
	float ticketPrice = (float)3.20;
	
	Spookhuis() {
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
