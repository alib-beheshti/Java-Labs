/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;

public class SimpleUI implements UserInterface {
    private BlackjackGame game;
    private Scanner user = new Scanner(System.in);

    public void setGame(BlackjackGame game) {
        this.game = game;
    }

    public void display() {
        //FIX THIS
    }

    public boolean hitMe() {
        //FIX THIS
        return false;
    }

    public void gameOver() {
        //FIX THIS
    }

}