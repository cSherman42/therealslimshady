/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package therealslimshady;

/**
 *
 * @author s447335
 */

public class GeneralStore {
    /*
     * Owner
     * Gold
     * inventory
     * buy/sell options
     * maybe in future add a clerk who extends Player class, give play option to kill and loot store clerk
     */
    private int gold;
    private String name;
    private Weapon[] predefined_inventory = {new Weapon("dagger",2,10), new Weapon("sword",3,15)};

    public GeneralStore(String nm) {
        name = nm;
        gold = 100;
    }

    public void prompt(Player p1) throws InterruptedException {
        //Make this a loop so if you dont have enough money you can still browse
        System.out.println("Hello and Welcome to the " + name + " General Store!");
        Thread.sleep(500);
        System.out.println("Would you like to browse our goods?");
        boolean response = Game.evaluateResponse(Game.asdf.nextLine());
        if(response) {
            displayInventory();
        } else {
            exit();
            return;
        }
        System.out.println("You have " + p1.getMoney() + " gold.");
        Thread.sleep(500);
        System.out.println("What would you like?");
        int buyNum = Game.asdf.nextInt();
        Game.asdf.nextLine();
        System.out.println(predefined_inventory[buyNum-1] + " costs " + predefined_inventory[buyNum-1].getCost() + " gold");
        System.out.println("Are you sure you want to buy this?");
        if(Game.evaluateResponse(Game.asdf.nextLine())) {
            if(p1.getMoney() >= predefined_inventory[buyNum-1].getCost()) {
                System.out.println("You buy the " + predefined_inventory[buyNum-1].getName());
                p1.addMoney((-1) * predefined_inventory[buyNum-1].getCost());
                System.out.println("You now have " + p1.getMoney() + " gold.");
                p1.addWeapon(predefined_inventory[buyNum-1]);
            } else {
                System.out.println("You do not have enough money for this!");
                Thread.sleep(500);
                System.out.println("You only have " + p1.getMoney());
            }
        }
    }

    public void displayInventory() {
        int i=1;
        for(Weapon wep : predefined_inventory) {
            System.out.println(i + ". " + wep);
            i++;
        }
    }
    public void exit() throws InterruptedException {
        System.out.println("Thank you for visiting the " + name + " General Store!");
        Thread.sleep(500);
        System.out.println("Have a wonderful day!");
    }

}
