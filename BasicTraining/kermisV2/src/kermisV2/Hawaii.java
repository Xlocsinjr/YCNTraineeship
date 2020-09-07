package kermisV2;

class Hawaii extends HighRiskAttraction {
	Hawaii(String name) {
		this.name = name;
		this.ticketPrice = 2.90;
		this.ridesLimit = 10;
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
