package kermisV2;

abstract class HighRiskAttraction extends Attraction{
	int ridesLimit;
	int rideCount;
	
	void maintenance() {
		rideCount = 0;
		System.out.println("===== " + this.name + " underwent maintenance. =====");
	}
	
	// check if rideCount exceeds ridesLimit. Throws exception if it does.
	void checkForMaintenance() {
		if (this.rideCount > this.ridesLimit) {
			throw new ArithmeticException("===== " + this.name + "has exceeded its ride limit! ====="); 
		}
		System.out.println("===== " + this.name + " has run " + this.rideCount + " times since last maintenance. =====");
	}
}
