
import java.util.Random;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Blackjack {
  public static void main(String[] args) {
    // defines arrays for card array initialisation
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

    // Duplicate the initial (unshuffled array), then shuffles the original 
    Card cardArrayInit[] = cardArray;
    cardArray = Card.shuffleDeck(cardArrayInit);
    Card handArray[] = {};

    boolean gameOver = false;
    int points = 0;

    while (!gameOver) {
      System.out.println("Enter a command");
      System.out.println("k: hit    p: pass    r: restart    q: quit");
     
      boolean isValid = false;
      String userInput = "initInput";

      // ask for user input until a valid command has been entered
      while (!isValid) {
        isValid = true;
        Scanner scanner = new Scanner(System.in);
        userInput = scanner.nextLine();  // Read user input

        // if hit:
        // remove the first element in the list of cards
        // add that card to the hand list
        if (userInput.equals("k")){
          Card hitCard = cardArray[0];
          hitCard.declareCard();

          // Updates the hand array: 
          // creates a new array that's one element longer and adds the new card at the end.
          int handArrayLength = handArray.length;
          int newHandLength = handArray.length + 1;
          Card newHandArray[] = new Card[newHandLength];
          newHandArray[handArrayLength] = hitCard;
          handArray = newHandArray;

          // Updates the card array
          List<Card> newCardList = new ArrayList<Card>(Arrays.asList(cardArray));
          newCardList.remove(0);	
          Card[] newCardArray = new Card[newCardList.size()];
          newCardArray = newCardList.toArray(newCardArray);
          cardArray = newCardArray;

          System.out.println(handArray.length);
          System.out.println(cardArray.length);

          
        } 
        else if (userInput.equals("p")){

        }
        // if restarted:
        // remake the card array to a shuffled list from the initial card array
        // set points back to 0
        else if (userInput.equals("r")){
          cardArray = Card.shuffleDeck(cardArrayInit);
          points = 0;
          System.out.println("restarting ...");
          System.out.println("===============================");
        } 
        // if quit:
        // end game and code
        else if (userInput.equals("q")){
          System.out.println("quitting ... To play again, run the code again.");
          System.out.println("===============================");
          gameOver = true;
        }
        else {
          isValid = false;
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

  static Card[] shuffleDeck(Card[] cardArrayArg){
    // Shuffle deck https://www.programcreek.com/2012/02/java-method-to-shuffle-an-int-array-with-random-order/
    //  turns array into list, shuffles, then turns back into an array
    // returns shuffled card array
    List<Card> cardList = Arrays.asList(cardArrayArg);
    Collections.shuffle(cardList);
    
    Card[] cardArrayNew = new Card[cardList.size()];
    cardArrayNew = cardList.toArray(cardArrayNew);

    return cardArrayNew;
  }

  static int determinePoints(List<Card> handListArg){
    int handPoints = 0;

    for (int i = 0; i < handListArg.size(); i++){
      int CardValue = Integer.parseInt(handListArg.get(i).value);
      
    }

    return handPoints;
  }

}



		 
