package kermisV2;

class Spin extends HighRiskAttraction {
	Spin(String name) {
		this.name = name;
		this.ticketPrice = 2.25;
		
	}
	
	// override
	void rideAttraction(){
		ticketsSold++;
		currentEarnings += ticketPrice;
		System.out.println("=> riding " + name);
	}	
	
}