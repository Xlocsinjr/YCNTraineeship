package kermisV2;

class Hawaii extends Attraction {
	String name = "Hawaii";
	float ticketPrice = (float)2.90;
	
	Hawaii() {
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
