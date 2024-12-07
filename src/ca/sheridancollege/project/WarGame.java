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
    private boolean hasWinner = false;
    
    //variable for cards wagered in war tie
    private ArrayList<Card> pool;
    
    //card variable to compare each round
    private Card p1Card;
    private Card p2Card;
    
    //variables for the two players, not sure if overlap with list?
    private Player player1;
    private Player player2;
    private Player winner;

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
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * @param players the players of this game
     */
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    /**
     * Play the game. This might be one method or many method calls depending on your game.
     */
    public void play(){
        prepGame();
        //loop of while game not won
        while (hasWinner = false) {
            hasWinner();
            playRound();
            
        }
        //display end of game text
        declareWinner(winner);
    }

    public void prepGame(){
    
    //get the names of the two players
    //might need function in GameView class

    //create fresh deck and shuffle
        deck = new GroupOfCards(52);
        deck.shuffle();
        
    // Create Hands for players
    player1.setHand(new Hand());
    player2.setHand(new Hand());
    
    //deal cards from deck to the players
    deck1.addAll(cardDeck.subList(0, 25));              //26 cards for p1       
    deck2.addAll(cardDeck.subList(26, cardDeck.size()));//26 cards for p2

    }

    //function that represents one round of the game being played
    public void playRound() {
        
    //draws a card from each player's hand
    p1Card = player1.playTopCard();
    p2Card = player2.playTopCard();
    
    //case for scenarios of win, loss, tie-war
    if (pool == null) {
        pool = new Hand();
    }
    
    //check if win conditions are met
    
    //print round information
    GameView.roundText(counter, player1, p1card, p2card);
    
    //update counter variable
    counter++;
    }
    
    //function that represents the logic when war occurs
    
    //function compares the two drawn cards
    public Player compare(Card p1card, Card p2card){
    return player1;
    }
    
    /**
     * Function checks if the game has a winner or reached max rounds
     */
    public Boolean hasWinner(){
        if (counter = 100) {
        System.out.println("Maximum number of rounds reached.");
        
        } 
    }
    
    /**
     * When the game is over, use this method to declare and display a winning player.
     */
    public void declareWinner(winner){
        GameView.messageWinner(winner);
    }

}//end class
