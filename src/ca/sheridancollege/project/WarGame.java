/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * The class that models your game. You should create a more specific child of this class and instantiate the methods
 * given.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public class WarGame {

    private final String name;//the title of the game
    private ArrayList<Player> players;// the players of the game
    private GroupOfCards deck;
    private int counter = 0;
    
    //variable for cards wagered in war tie
    private ArrayList<Card> pool;
    
    //variables for the two players, not sure if overlap with list?
    private WarPlayer player1;
    private WarPlayer player2;
    private WarPlayer winner;
    private WarPlayer roundWinner;

    public WarGame(String name) {
        this.name = name;
        players = new ArrayList();
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the players of this game
     */
    public ArrayList<WarPlayer> getPlayers() {
        return players;
    }

    /**
     * @param players the players of this game
     */
    public void setPlayers(ArrayList<WarPlayer> players) {
        this.players = players;
    }

    /**
     * Create deck and prepare hands for the two players
     */
    public void prepCards(){
        //create fresh deck and shuffle
        deck = new GroupOfCards(52);
        deck.shuffle();
        
        //split the deck into halves
        List<Card> cards1 = deck.getCards().subList(0, 26);
        List<Card> cards2 = deck.getCards().subList(26, 52);
        
        //create two hands with the split deck of cards
        Hand player1Hand = new Hand(cards1);
        Hand player2Hand = new Hand(cards2);
        
        // Create Hands for players
        player1.setHand(player1Hand);
        player2.setHand(player2Hand);
    }
    
    /**
     * Play the game. This might be one method or many method calls depending on your game.
     */
    public void play(){
        prepGame();
        //loop of while game not won
        while (hasWinner() == false) {
            //check if game has ended
            hasWinner();
            
            //the two players play a round of the game
            playRound();
            
        }
        //display end of game text
        winner = isWinner();
        declareWinner(winner);
    }

    public void prepGame(){
    
    //get the names of the two players
    //might need function in GameView class
        GameView.openingMessage();
        prepCards();
    }

    //function that represents one round of the game being played
    public void playRound() {
        
    //draws a card from each player's hand
    p1Card = player1.getHand().playTopCard();
    p2Card = player2.getHand().playTopCard();
    
    roundWinner = compare(p1Card, p2Card);

    //print round information
    GameView.roundText(counter, roundWinner, p1card, p2card);
    
    //update counter variable
    counter++;
    }
    
    //function that represents the logic when war occurs
    
    //function compares the two drawn cards
    public WarPlayer compare(Card p1card, Card p2card){
        //place the two cards into pool
        pool.add(p1card);
        pool.add(p2card);
        
        //compare card values and add won cards to player deck
        if (p1card.getRank() > p2card.getRank()) {
            player1.getHand().addCards(pool);
        return player1
        }
        else if (p1card.getRank() < p2card.getRank()) {
            player2.getHand().addCards(pool);
        return player2
        }
        //if there is a tie
        else {
            //add more cards to the pool
            pool.add(player1.getHand().playCards(3));
            pool.add(player2.getHand().playCards(3));
            
            Card p1War = player1.getHand().playTopCard();
            Card p2War = player2.getHand().playTopCard();
            
            return compare(p1War, p2War);
        }
    }
    
    public Boolean hasWinner(){
    if (counter == 100 || player1.getHand().getSize()==0 || player2.getHand().getSize()==0) {
    return true
    }
    return false;
    }
    
    /**
     * Function checks if the game has a winner or reached max rounds
     */
    public WarPlayer Boolean isWinner(){
        if (counter == 100) {
        System.out.println("Maximum number of rounds reached.");
            if (player1.getHand().getSize() > player2.getHand().getSize()) {
            return player1;
            }
            else if (player1.getHand().getSize() < player2.getHand().getSize()) {
            return player2;
            }
            else {
            GameView.announceDraw();
            break;
            }
        }
        else if (player1.getHand().getSize() == 0){
        return player2;
        }
        else if (player2.getHand().getSize() == 0){
        return player1;
        }
        else return null;
    }
    
    /**
     * When the game is over, use this method to declare and display a winning player.
     */
    public void declareWinner(winner){
        GameView.messageWinner(winner);
    }

}//end class
