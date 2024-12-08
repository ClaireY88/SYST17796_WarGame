/**
 * SYST 17796 Project.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The class that models your game. You should create a more specific child of this class and instantiate the methods
 * given.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @author Claire Yao 2024-12-07
 */
public class WarGame {

    private final String name;//the title of the game
    private ArrayList<WarPlayer> players;// the players of the game
    private GroupOfCards deck;
    private int counter = 1;
    
    //variable for cards wagered in war tie
    private final Hand pool = new Hand();
    
    private WarPlayer player1;
    private WarPlayer player2;
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
        deck.createDeck();
        deck.shuffle();
        
        //split the deck into halves
        ArrayList<StandardPlayingCard> cards1 = new ArrayList<StandardPlayingCard>(deck.getCards().subList(0, 26));
        ArrayList<StandardPlayingCard> cards2 = new ArrayList<StandardPlayingCard>(deck.getCards().subList(26, 52));
        
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
        declareWinner(isWinner());
    }

    public void prepGame(){
    
    //might need function in GameView class
        GameView.openingMessage();
        
        //get player names and assign to variable
        player1 = createPlayer(1);
        player2 = createPlayer(2);
        players.add(player1);
        players.add(player2);
        System.out.println("\n");
        System.out.println("============================");
        prepCards();
    }

    //function that represents one round of the game being played
    public void playRound() {
        
    //draws a card from each player's hand
    StandardPlayingCard p1Card = player1.getHand().playTopCard();
    StandardPlayingCard p2Card = player2.getHand().playTopCard();
    
    roundWinner = compare(p1Card, p2Card);

    //print round information
    GameView.roundText(counter, roundWinner, p1Card, p2Card);
    
    //update counter variable
    counter++;
    }
    
    //function compares the two drawn cards
    public WarPlayer compare(StandardPlayingCard p1card, StandardPlayingCard p2card){
        //place the two cards into pool
        if (p1card == null){
        return player2;
        }
        else if (p2card == null){
        return player1;
        }
        else {
        pool.getHands().add(p1card);
        pool.getHands().add(p2card);
        }
        
        //compare card values and add won cards to player deck
        if (p1card.getRank().rankValue() > p2card.getRank().rankValue()) {
            player1.getHand().addCards(pool.getHands());
            pool.getHands().clear();
        return player1;
        }
        else if (p1card.getRank().rankValue() < p2card.getRank().rankValue()) {
            player2.getHand().addCards(pool.getHands());
            pool.getHands().clear();
        return player2;
        }
        //if there is a tie
        else {
            //add more cards to the pool
            pool.addCards(player1.getHand().playCards(3));
            pool.addCards(player2.getHand().playCards(3));
            
            StandardPlayingCard p1War = player1.getHand().playTopCard();
            StandardPlayingCard p2War = player2.getHand().playTopCard();
            
            return compare(p1War, p2War);
        }
    }
    
    public Boolean hasWinner(){
    return counter == 100 || player1.getHand().getSize()==0 || player2.getHand().getSize()==0;
    }
    
    /**
     * Function checks if the game has a winner or reached max rounds
     * @return 
     */
    public WarPlayer isWinner(){
        if (counter == 100) {
        System.out.println("Maximum number of rounds reached.");
        System.out.println(player1.getName()+ ": " + player1.getHand().getSize() + " Cards");
        System.out.println(player2.getName()+ ": " + player2.getHand().getSize() + " Cards");
        
            if (player1.getHand().getSize() > player2.getHand().getSize()) {
            return player1;
            }
            else if (player1.getHand().getSize() < player2.getHand().getSize()) {
            return player2;
            }
            else {
            GameView.announceDraw();
            return null;
            }
        }
        else if (player1.getHand().getSize() == 0){
        return player2;
        }
        else if (player2.getHand().getSize() == 0){
        return player1;
        }
        else {
            return null;
        }
    }
    
    /**
     * When the game is over, use this method to declare and display a winning player.
     * @param winner
     */
    public void declareWinner(WarPlayer winner){
        GameView.messageWinner(winner);
    }
    
    public WarPlayer createPlayer(int number) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Player " + number + " Name : ");
        String playerName = scanner.nextLine();
        return new WarPlayer(playerName);
    }
    
}//end class
