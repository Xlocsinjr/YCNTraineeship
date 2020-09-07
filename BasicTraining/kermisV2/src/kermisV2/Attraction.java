package kermisV2;

class Attraction {	
	String name;
	double surfaceArea;
	double ticketPrice;
	int ticketsSold;
	double currentEarnings;
	
	void rideAttraction() {}
	
	void declareRevenue() {
		System.out.println("name: " + name);
		System.out.println("tickets sold: " + ticketsSold);
		System.out.println("revenue: " + currentEarnings);
	}
}



