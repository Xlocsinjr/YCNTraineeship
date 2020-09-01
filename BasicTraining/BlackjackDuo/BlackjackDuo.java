/* ==================================================================
* BlackjackDuo.java
*
* 
* 
*
* Xander Locsin
** ==================================================================*/ 
import java.util.Random;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class BlackjackDuo {
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
    Card[] handArrayDealer = {};

    boolean gameOver = false;
    int points = 0;
    int dealerPoints = 0;
    boolean playerStand = false;
    boolean dealerStand = false;



    while (!gameOver) {
      System.out.println("Enter a command");
      System.out.println("k: hit    p: pass    s: stand    r: restart    q: quit");
     
      boolean isValid = false;
      String userInput = "initInput";

      Card hitCard = cardArray[0];

      String endTurnStatement = "";

      // ========= Player's turn =================
      String playerPointStatement = "";

      // ask for user input until a valid command has been entered if not standing
      if (!playerStand){
        while (!isValid) {
          isValid = true;
          Scanner scanner = new Scanner(System.in);
          userInput = scanner.nextLine();  // Read user input

          String playerCardVal = hitCard.value;

          // if hit:
          if (userInput.equals("k")){          
            // Updates the hand array to include the new card
            // Updates the card array to remove the new card
            handArray = Card.updateHandArray(handArray, hitCard);
            cardArray = Card.updateCardArray(cardArray);
            hitCard = cardArray[0]; // so the dealer hits a new card

            // calculate hand value and prints cards in hand
            points = Card.showHand(handArray, "player's hand: ", false);

            // blackjack if points = 21, quits game
            if (points == 21){
              endTurnStatement = "***Blackjack, you win! To play again, run the code again. ***";
              gameOver = true;
            }

            // busts if points over 21, quits game
            if (points > 21){
              endTurnStatement = "***You bust! Game over. To play again, run the code again.***";
              gameOver = true;
            }

            playerPointStatement = "+ " + playerCardVal + "      points: " + points;
          } 

          // if passed:
          else if (userInput.equals("p")){
            playerPointStatement = "passed      points: " + points;
          }

          // if standing:
          else if (userInput.equals("s")){
            playerStand = true;
            playerPointStatement = "standing      points: " + points;
          }

          // if restarted:
          else if (userInput.equals("r")){
            // remake the card array to a shuffled list from the initial card array,
            // empties hand, set points back to 0
            cardArray = Card.shuffleDeck(cardArrayInit);
            handArray = new Card[]{};
            handArrayDealer = new Card[]{};
            points = 0;
            dealerPoints = 0;
            endTurnStatement = "***** restarting ...*****";
          } 

          // if quit:
          // end game and code
          else if (userInput.equals("q")){
            endTurnStatement = "***** quitting ... To play again, run the code again. *****";
            gameOver = true;
          }

          else {
            isValid = false;
            System.out.println("Please enter a valid command.");
            System.out.println("k: hit    p: pass    s: stand    r: restart    q: quit");
          }
        }
      }
      else{
        playerPointStatement = "standing      points: " + points;
      }

      Card.showHand(handArray, "player's hand: ", true);
      System.out.println(playerPointStatement);
      System.out.println("");

      // ========= Dealer's turn =================
      String dealerPointStatement = "";
      String dealerCardVal = hitCard.value;

      if (!dealerStand && !gameOver && !userInput.equals("r") && !userInput.equals("q")){
        if (dealerPoints >= 17){
          dealerStand = true;
          dealerPointStatement = "standing      points: " + dealerPoints;;
        }
        else{
          // Update dealer hand array and card array
          handArrayDealer = Card.updateHandArray(handArrayDealer, hitCard);
          cardArray = Card.updateCardArray(cardArray);

          // calculate hand value and prints cards in hand
          dealerPoints = Card.showHand(handArrayDealer, "dealer's hand: ", false);

          // blackjack if points = 21, quits game
          if (dealerPoints == 21){
            endTurnStatement = "***Blackjack! The dealer wins***";
            endTurnStatement += " To play again, run the code again.";
            gameOver = true;
          }

          // busts if points over 21, quits game
          if (dealerPoints > 21){
            endTurnStatement = "***The dealer busts! You win!***";
            endTurnStatement += " To play again, run the code again.";
            gameOver = true;
          }

          dealerPointStatement = "+ " + dealerCardVal + "      points: " + dealerPoints;
        }
      }
      else{
        dealerPointStatement = "standing      points: " + dealerPoints;;
      }
      
      Card.showHand(handArrayDealer, "dealer's hand: ", true);
      System.out.println(dealerPointStatement);

      // ========= end of turn ============
      if (dealerStand && playerStand){
        if (points > dealerPoints){
          endTurnStatement = "***** You win! To play again, run the code again. *****";
        }
        else if (points == dealerPoints){
          endTurnStatement = "***** Tie! To play again, run the code again. *****";
        }
        gameOver = true;
      }

      if (!endTurnStatement.isEmpty()){
        System.out.println("");
        System.out.println(endTurnStatement);
      }
      System.out.println("===============================");
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

  static int showHand(Card[] handArrayArg, String handIdentity, boolean printBool){
    // determines the points value of the hand and prints a string of the cards
    // returns the points value of the hand
    int handPoints = 0;
    String handString = "";

    int aceCount = 0;

    for (int k = 0; k < handArrayArg.length; k++){
      String cardString = handArrayArg[k].declareCard();
      handString += "|";
      handString += cardString;
      handString += "|";

      int cardValue = handArrayArg[k].calcCardPoints();
      handPoints += cardValue;

      if (handArrayArg[k].value.equals("Ace")){
        aceCount++;
      }
    }
    // subtract 10 for every ace in hand, as long as handpoints is over 21
    while (handPoints > 21 && aceCount > 0){
      aceCount--;
      handPoints -= 10;
    }

    if (printBool){
      System.out.println(handIdentity + handString);
    }
    
    return handPoints;
  }
}



		 
