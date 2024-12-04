/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author clair
 */
public enum Suit {
    CLUB(1, "Club", '\u2663'),
    HEART(2, "Heart", '\u2661'),
    DIAMOND(3, "Diamond", '\u2662'),
    SPADE(4, "Spade", '\u2660');

    private int num;
    private String suitName;
    private char suitUnicode;

    public int num(){
        return this.num;
    }

    public String suitName(){
        return this.suitName;
    }

    public char suitUnicode(){
        return this.suitUnicode;
    }

    private Suit(int num, String suitName, char suitUnicode){
        this.num = num;
        this.suitName = suitName;
        this.suitUnicode = suitUnicode;
    }

    @Override
    public String toString(){
        return this.suitName;
    }
}
