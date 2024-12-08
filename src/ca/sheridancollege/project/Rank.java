/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author claire yao
 */
public enum Rank {
        TWO(2, "Two", "2"),
    THREE(3, "Three", "3"),
    FOUR(4, "Four", "4"),
    FIVE(5, "Five", "5"),
    SIX(6, "Six", "6"),
    SEVEN(7, "Seven", "7"),
    EIGHT(8, "Eight", "8"),
    NINE(9, "Nine", "9"),
    TEN(10, "Ten", "10"),
    JACK(11, "Jack", "J"),
    QUEEN(12, "Queen", "Q"),
    KING(13, "King", "K"),
    ACE(1, "Ace", "A");

    private int rankValue;
    private String rankName;
    private String rankShort;

    public int rankValue(){
        return this.rankValue;
    }

    public String rankName(){
        return this.rankName;
    }

    public String rankShort(){
        return this.rankShort;
    }

    private Rank(int rankValue, String rankName, String rankShort){
        this.rankValue = rankValue;
        this.rankName = rankName;
        this.rankShort = rankShort;
    }

    @Override
    public String toString(){
        return this.rankName;
    }
    
}
