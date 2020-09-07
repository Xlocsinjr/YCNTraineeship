package kermisV2;

class Hawaii extends HighRiskAttraction {
	Hawaii(String name) {
		this.name = name;
		this.ticketPrice = 2.90;
	}
	
	// override
	void rideAttraction(){
		ticketsSold++;
		currentEarnings += ticketPrice;
		System.out.println("=> visiting " + name);
	}
	
}
