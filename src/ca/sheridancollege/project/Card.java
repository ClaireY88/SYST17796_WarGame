/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @author dancye
 */
public abstract class Card {
    //default modifier for child classes

    /**
     * Students should implement this method for their specific children classes
     *
     * @return a String representation of a card. Could be an UNO card, a regular playing card etc.
     */
    
    private Rank rank;
    private Suit suit;

    public Card(){

    }
    public Card(Rank rank, Suit suit){
    this.rank = rank;
    this.suit = suit;
    }

    public void setRank(Rank rank){
        this.rank = rank;
    }
    public Rank getRank(){
        return this.rank;
    }

    public void setSuit(Suit suit){
        this.suit = suit;
    }
    public Suit getSuit(){
        return this.suit;
    }

    public String shortString(){
        return rank.rankShort() + suit.suitUnicode();
    }

    @Override
    public String toString(){
        return rank.rankName() + " of " + suit.suitName();
    }

}
