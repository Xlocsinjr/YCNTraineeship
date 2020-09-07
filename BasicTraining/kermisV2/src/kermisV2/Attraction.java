package kermisV2;

class Attraction {	
	String name;
	float surfaceArea;
	float ticketPrice;
	int ticketsSold;
	float currentEarnings;
	
	void rideAttraction() {}
	
	void declareRevenue() {
		System.out.println("name: " + name);
		System.out.println("tickets sold: " + ticketsSold);
		System.out.println("revenue: " + currentEarnings);
	}
}



