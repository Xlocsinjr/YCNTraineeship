
import java.util.Random;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Blackjack {
  public static void main(String[] args) {
    // defines arrays for card array initialisation
    String[] suit = {"Hearts", "Diamonds", "Spades", "Clubs"};
    String[] value = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    Card[] cardArray = new Card[suit.length * value.length];

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
    Card[] cardArrayInit = cardArray;
    cardArray = Card.shuffleDeck(cardArrayInit);
    Card[] handArray = {};

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
          handArray = Card.updateHandArray(handArray, hitCard);

          // Updates the card array:
          // create list from card array, remove first element, update card array with new array made from list
          List<Card> newCardList = new ArrayList<Card>(Arrays.asList(cardArray));
          newCardList.remove(0);	
          Card[] newCardArray = new Card[newCardList.size()];
          newCardArray = newCardList.toArray(newCardArray);
          cardArray = newCardArray;

          // determine hand points
          int prePoints = points;
          points = Card.showHand(handArray);
          System.out.println(prePoints + " + " + hitCard.value + " = " + points);
          System.out.println("===============================");

          
        } 
        else if (userInput.equals("p")){

        }
        // if restarted:
        // remake the card array to a shuffled list from the initial card array,
        // empties hand, set points back to 0
        else if (userInput.equals("r")){
          cardArray = Card.shuffleDeck(cardArrayInit);
          handArray = new Card[]{};
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

  static Card[] updateHandArray(Card[] handArrayArg, Card hitCardArg){
    // declare new array with one more element than current hand
    int newHandLength = handArrayArg.length + 1;
    Card[] newHandArray = new Card[newHandLength];

    // copy previous hand
    for (int i = 0; i < handArrayArg.length; i++){
      newHandArray[i] = handArrayArg[i];
    }

    // add the latest card received
    newHandArray[handArrayArg.length] = hitCardArg;
    return newHandArray;
  }

  static int showHand(Card[] handArrayArg){
    // determines the points value of the hand
    // returns the points value of the hand
    int handPoints = 0;

    for (int k = 0; k < handArrayArg.length; k++){
      String cVal = handArrayArg[k].value;

      if (cVal.equals("Jack") || cVal.equals("Queen") || cVal.equals("King")){
        handPoints += 10;
      }
      else if(cVal.equals("Ace")){
        handPoints += 11;
        if (handPoints > 21){
          handPoints -= 10;
        }
      }
      else {
        handPoints += Integer.parseInt(cVal);
      }      
    }

    return handPoints;
  }

}



		 
