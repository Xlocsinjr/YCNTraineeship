package kermisV2;

abstract class HighRiskAttraction extends Attraction{
	int ridesLimit;
	int rideCount;
	
	void maintenance() {
		rideCount = 0;
	}
	
	void checkForMaintenance() {
		rideCount++;
		if (this.rideCount > this.ridesLimit) {
			maintenance();
			System.out.println("===== " + this.name + " underwent maintenance. =====");
		}
	}
}
