/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author clair
 */
public class GameView {
    //all the text that appears in the command line
    
    public void openingMessage() {
        System.out.println("Game of War\n" +
                "This Game is automated and will play until one deck is empty or the game reaches 50 rounds.");
        System.out.println("Indicate that you are ready by hitting enter.");
    }
    
    //function to enter player names, check if in array?
    
    //function to print results from one round
    public void roundText(int counter, WarPlayer player) {
    System.out.println("Round: " + counter);
    //shows what card each player drew toString?
    System.out.println("Card1 VS Card2");
    System.out.println(player.getName() + " wins the round.");
    System.out.println("=================================================================");
    }
    
    //print war round
    public void announceWar() {
        System.out.println("There was a tie! WAR!");
    }
    //another function for the rest of text for war? preparing the three cards

    public void declareWinner(WarPlayer player) {
        System.out.printf("The winner of the game is %s!", player.getName());
    }

    public void announceDraw() {
        System.out.printf("The game ended in a draw.");
    }
}