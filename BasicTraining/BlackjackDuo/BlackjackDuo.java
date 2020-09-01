/* ==================================================================
* Blackjack.java
*
* Implements a simple single player blackjack game.
* The user is asked for input to keep the game going.
*
* Xander Locsin
** ==================================================================*/ 


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

        Card hitCard = cardArray[0];

        // if hit:
        if (userInput.equals("k")){
          System.out.println("New card: " + hitCard.declareCard());
          
          // Updates the hand array to include the new card
          handArray = Card.updateHandArray(handArray, hitCard);
          Card.showHand(handArray);

          // Updates the card array to remove the new card
          cardArray = Card.updateCardArray(cardArray);

          // determine card points
          int hitCardPoints = hitCard.calcCardPoints();
          points += hitCardPoints;

          // if points exceed 21 and the card was an Ace, turn card value to 1
          if (points > 21 && hitCard.value.equals("Ace")){
            hitCardPoints = 1;
            points -= 10;
          }

          // blackjack if points = 21, quits game
          if (points == 21){
            System.out.println("***Blackjack!***");
            System.out.println("To play again, run the code again.");
            gameOver = true;
          }

          // busts if points over 21, quits game
          if (points > 21){
            System.out.println("***Bust! Game over***");
            System.out.println("To play again, run the code again.");
            gameOver = true;
          }

          System.out.println("+ " + hitCardPoints + "      points: " + points);
          System.out.println("===============================");
        } 

        // if passed:
        else if (userInput.equals("p")){
          // Updates the card array to remove the new card
          cardArray = Card.updateCardArray(cardArray);
          Card.showHand(handArray);
          System.out.println("passed      points: " + points);
          System.out.println("===============================");
        }
        // if restarted:
        // remake the card array to a shuffled list from the initial card array,
        // empties hand, set points back to 0
        else if (userInput.equals("r")){
          cardArray = Card.shuffleDeck(cardArrayInit);
          handArray = new Card[]{};
          points = 0;
          System.out.println("***restarting ...***");
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

  String declareCard(){
    // declares the card's value and suit
    // returns a string of the declaration
    String declaration = value + " of " + suit;
    return declaration;
  }

  int calcCardPoints(){
    // calculates the numerical value of the card
    // returns an int of the value
    int cardPoints = 0;
    String cVal = value;

    if (cVal.equals("Jack") || cVal.equals("Queen") || cVal.equals("King")){
      cardPoints = 10;
    }
    else if(cVal.equals("Ace")){
      cardPoints = 11;
    }
    else {
      cardPoints = Integer.parseInt(cVal);
    } 
    return cardPoints;
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
    // declare new array with one more element than current hand, copy previous hand, add new card
    // returns the updated hand array
    int newHandLength = handArrayArg.length + 1;
    Card[] newHandArray = new Card[newHandLength];

    for (int i = 0; i < handArrayArg.length; i++){
      newHandArray[i] = handArrayArg[i];
    }
    newHandArray[handArrayArg.length] = hitCardArg;

    return newHandArray;
  }

  static Card[] updateCardArray(Card[] cardArrayArg){
    // create list from card array, remove first element, update card array with new array made from list
    // returns the updated card array
    List<Card> newCardList = new ArrayList<Card>(Arrays.asList(cardArrayArg));
    newCardList.remove(0);	
    Card[] newCardArray = new Card[newCardList.size()];
    newCardArray = newCardList.toArray(newCardArray);
    
    return newCardArray;
  }

  static void showHand(Card[] handArrayArg){
    // determines the points value of the hand
    // returns the points value of the hand
    int handPoints = 0;
    String handString = "";

    for (int k = 0; k < handArrayArg.length; k++){
      handString += "|";
      handString += handArrayArg[k].declareCard();
      handString += "|";
    }
    System.out.println("Current hand: " + handString);
  }
}



		 
