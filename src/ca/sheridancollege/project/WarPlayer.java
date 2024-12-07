/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 * Represent player for War Game. This is a subclass extend from abstract Player() class 
 * @author Yue Hou Dec 06, 2024 
 */
public class WarPlayer extends Player{
    
    private Hand hand; // Relation to the Hand class
     
    /**
    * A constructor that allows you to set the player's unique ID
    * @param name the unique ID to assign to this player.
    */
    public WarPlayer(String name) {
       super(name); // reading the name from super class Player() 
    }

    /**
    * get the player's hand
    * @return hand fetch the hand object 
    */
    public Hand getHand() {
        return hand;
    }
    
    /**
    * assign the hand to this player
    * @param hand receive the hand object 
    */
    public void setHand(Hand hand) {
        this.hand = hand;
    }
    
    /**
    * override the abstract method from  PLayer() class 
    * TO UPDATE
    */
    @Override 
    public void play() {
        
    };

}
