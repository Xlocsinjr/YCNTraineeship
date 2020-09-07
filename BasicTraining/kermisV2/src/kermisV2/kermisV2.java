package kermisV2;

/**
 * 
 * @author Xander Locsin
 *
 **/


public class kermisV2 {
	public static void main(String[] args) {
		// make all the attractions
		BotsAutos bumper = new BotsAutos("bumper");
		Spin spider = new Spin("Spin");
		Spiegelpaleis mirrors = new Spiegelpaleis("mirrors");
		Spookhuis haunt = new Spookhuis("haunt");
		Hawaii hawaii = new Hawaii("hawaii");
		Ladderklimmen ladders = new Ladderklimmen("ladders");

		Attraction[] attractionArray = {bumper, spider, mirrors, haunt, hawaii, ladders};
		
		
		KermisBalance kBalance = new KermisBalance(attractionArray);		
        
		
		while (!kBalance.quitBool) {
			while (kBalance.rideOptions) {
				kBalance.rideOptionsCommand();
				kBalance.updateBalance();
				System.out.println("=========================================");
			}
			while (kBalance.adminOptions) {
				kBalance.balanceOptionsCommand();
				System.out.println("=========================================");
			}		
		} // quitbool while loop
	} // main
} // public class



// ==============================================================












