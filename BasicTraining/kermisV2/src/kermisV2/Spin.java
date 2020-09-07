package kermisV2;

class Spin extends HighRiskAttraction {
	Spin(String name) {
		this.name = name;
		this.ticketPrice = 2.25;
		this.ridesLimit = 5;
		
	}
	
	// override
	void rideAttraction(){
		checkForMaintenance();
		rideCount++;

		ticketsSold++;
		currentEarnings += ticketPrice;
		System.out.println("=> visiting " + name);
	}	
	
}