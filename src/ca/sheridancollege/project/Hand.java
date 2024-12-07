/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
/**
 * player's hand  
 * @author Yue Hou, Dec 06, 2024 
 * 
 */
public class Hand {
    
    private ArrayList<Card> hand; 
    
    /**
    * constructor for creating a empty hand
    */
    public Hand() {
        this.hand = new ArrayList<>(); 
    }
    
    /**
    * constructor for creating hands, each hand get 26 cards to start 
    * @param cards the half deck of 26 cards 
    */
    public Hand(ArrayList<Card> cards) {
        this.hand = cards; 
    }
    
    /**
    * Getter for the size of the hands
    * @return the int 
    */
    public int getSize() {
        return this.hand.size();   // ArrayList method of getting the size
    }
    
    /**
    * play the top card from the hand 
    * @return Card 
    */
    public Card playTopCard() {
        return this.hand.size() > 0 ? this.hand.remove(0) : null;
    }
    
    /**
    * play the top cards from the hand 
    * @param numberOfCards the number of cards to play in one go 
    * @return ArrayList Card, or null if not enough card to play 
    */
    public ArrayList<Card> playCards(int numberOfCards) {
        
        if (this.hand.size() < numberOfCards) {
            return null; 
        }
        
        ArrayList<Card> playedCards = new ArrayList<>(); // local variable oto hold the list of played cards 
        
        for (int i=0; i < numberOfCards; i++){
            playedCards.add(this.hand.remove(0)); 
        }
        return playedCards; 
    }
    
    
    /**
    * collect and add cards to the hands  
    * @param wonCards the player win cards for one round 
    */
    public void addCards(ArrayList<Card> wonCards){
        this.hand.addAll(wonCards); 
    }
    
    /**
    * printing and testing the result  
    * @return hand the array list of hand cards 
    */
    public ArrayList<Card> getHands() {
        return this.hand; 
    }
    
}
