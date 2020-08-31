
import java.util.Random;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Blackjack {
  public static void main(String[] args) {
    /*
    System.out.println(kaarten.length);
		Random r = new Random();    // LET OP IMPORTEREN
		int a = r.nextInt(4);
    System.out.println(kaarten[a]);
    */
    
    String suit[] = {"Hearts", "Diamonds", "Spades", "Clubs"};
    String value[] = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    Card cardArray[] = new Card[suit.length * value.length];

    // generate the array of cards
    int indexCounter = 0;
    for (int i = 0; i < suit.length; i++){
      for (int j = 0; j <value.length; j++){
        // loop over all possible combinations of suit and value and adds it to the array
        Card cardGenerate = new Card(suit[i], value[j]);
        cardArray[indexCounter] = cardGenerate;
        indexCounter++;
      }
    }


    boolean gameOver = false;
    Scanner scanner = new Scanner(System.in);  // Create a Scanner object
    while (!gameOver) {
      // asks for user input
      // returns the user given input

      System.out.println("Enter a command");
      System.out.println("k: hit    p: pass    r: restart    q: quit");

      
      boolean isValid = false;
      String userInput = "temp";

      // ask for user input until a valid command has been entered
      while (!isValid) {
        userInput = scanner.nextLine();  // Read user input

        if (userInput.equals("k")){
          isValid = true;
        } 
        else if (userInput.equals("p")){
          isValid = true;
        } 
        else if (userInput.equals("r")){
          isValid = true;
        } 
        else if (userInput.equals("q")){
          isValid = true;
        }
        else {
          System.out.println("Please enter a valid command.");
          System.out.println("k: hit    p: pass    r: restart    q: quit");
        }
      }
    }

  
  



  }
}

class Card {
  // defines value and suit
  String suit;
  String value;
  
  // sets value and suit of generated card
  Card(String suitArg, String valueArg){
    this.suit = suitArg;
    this.value = valueArg;
  }

  void declareCard(){
    System.out.println(value + " of " + suit);
  }


  static List<Card> shuffleDeck(Card[] cardArrayArg){
    // Shuffle deck https://www.programcreek.com/2012/02/java-method-to-shuffle-an-int-array-with-random-order/
    //  turns array into list, then shuffles
    // returns shuffled card list
    List<Card> cardList = Arrays.asList(cardArrayArg);
    Collections.shuffle(cardList);
    
    //Card[] cardArrayNew = new Card[cardList.size()];
    //cardArrayNew = cardList.toArray(cardArrayNew);

    return cardList;
  }

  static List<Card> hit(List<Card> cardListArg){
    // removes the first element in a list of cards
    // returns the list with the first element removed
    System.out.println(cardListArg.get(0));
    cardListArg.remove(0);	
    
    return cardListArg;
  }
}



		 
