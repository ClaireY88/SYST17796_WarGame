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
    
    public static void openingMessage() {
        System.out.println("Game of War\n" +
                "This Game is automated and will play until one deck is empty or the game reaches 50 rounds.");
        System.out.println("Indicate that you are ready by hitting enter.");
    }
    
    //function to enter player names, check if in array?
    
    //function to print results from one round
    public static void roundText(int counter, WarPlayer player, Card p1card, Card p2card) {
    System.out.println("Round: " + counter);
    //shows what card each player drew toString?
    System.out.println(p1card.toString() + " VS " + p2card.toString());
    System.out.println(player.getName() + " wins the round.");
    System.out.println("=================================================================");
    }
    
    //print war round
    public void announceWar() {
        System.out.println("There was a tie! WAR!");
    }
    //another function for the rest of text for war? preparing the three cards

    public static void messageWinner(WarPlayer player) {
        System.out.printf("The winner of the game is %s!", player.getName());
    }

    public static void announceDraw() {
        System.out.printf("The game ended in a draw.");
    }
}
