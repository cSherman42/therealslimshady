/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package therealslimshady;

import java.util.Scanner;

/**
 *
 * @author s447335
 */
public class Game {

    static Scanner asdf = new Scanner(System.in);

    public static void main(String[] args) {
        //I love Mrs. Coots

        GeneralStore store = new GeneralStore("Anthony's");
        Player player = new Player("Gilgamesh");
        Enemy enemy = new Enemy("Berserker", 8, 2, 1);
        player.startFight(enemy);
        store.prompt(player);



    }

    public static boolean evaluateResponse(String response) {
        //come back to this
        response = response.toLowerCase().trim();
        if (response.equals("yes") || response.equals("y") || response.equals("ok") || response.equals("1")) {
            return true;
        } else {
            return false;
        }
    }
}
