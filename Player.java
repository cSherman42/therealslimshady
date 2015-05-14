/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package therealslimshady;

import java.util.ArrayList;

/**
 *
 * @author s447335
 */
public class Player {
    protected String name;
    protected int health;
    protected int level;
    protected int exp;
    protected int strength;
    protected int money;
    private int exp_needed;
    private ArrayList<Weapon> inventory = new ArrayList<Weapon>();

    public Player() {
        name = "Defualt Player";
        health = 10;
        level = 3;
        exp = 0;
        strength = 2;
        exp_needed = 10;
        money = 10;
    }
    public Player(String nm) {
        name = nm;
        health = 10;
        level = 3;
        exp = 0;
        strength = 2;
        exp_needed = 10;
        money = 10;
    }
    public Player(String nm, int hp, int lvl, int str) {
        name = nm;
        health = hp;
        level = lvl;
        strength = str;
        exp_needed = 10;
        money = 10;
    }
    public void addMoney(int add) {
        this.money += add;
    }
    public int getMoney() {
        return this.money;
    }
    public int getHealth() {
        return this.health;
    }
    public int getLevel() {
        return this.level;
    }
    public int getExp() {
        return this.exp;
    }
    public String getName() {
        return this.name;
    }
    public int getStrength() {
        return this.strength;
    }
    public void setHealth(int change) {
        //Add negative values for when you lose health
        this.health += change;
        if(this.health <= 0) {
            System.out.println("You have died!");
            System.exit(0);
        }
    }
    public int getNextExp() {
        return this.exp_needed;
    }
    public void bumpExp() {
        this.exp_needed *= 2;
    }
    public void capHealth() {
        this.setHealth((int) Math.round(this.level * 3.33) - this.getHealth()) ;
    }
    
    public void addExp(int change) throws InterruptedException {
        this.exp += change;
        if(this.exp > this.getNextExp()) {
            levelUp(1);
        }
    }
    public boolean hasWeapon() {
        return inventory.size() >=1;
    }
    public void addWeapon(Weapon wep) {
        inventory.add(wep);
    }
    
    public void startFight(Player opponent) throws InterruptedException {

        int player_strength = this.strength;
        if(this.hasWeapon()) {
            player_strength += inventory.get(0).getStrengthBonus();
        }
        boolean alive = true;
        int expGain = opponent.getLevel() * opponent.getHealth();

        System.out.println("You have encountered a " + opponent.getName() + "!");
        Thread.sleep(500);
        System.out.println("You get ready to fight...");
        Thread.sleep(500);
        while(alive){
            if(this.hasWeapon()) {
                System.out.println("You attack the " + opponent.getName() + " with your " + inventory.get(0).getName());
                Thread.sleep(500);
            }else {
                System.out.println("You attack the " + opponent.getName());
                Thread.sleep(500);
            }
            opponent.setHealth((-1) * player_strength);
            //check if crab is dead to exit loop
            //dont have to check if player died becuase setHealth() exits if you die
            if(opponent.getHealth() <= 0) {
                alive = false;
                break;
            }
            System.out.println("The " + opponent.getName() + " attacks you!");
            this.setHealth((-1) * opponent.getStrength());
            Thread.sleep(500);
        }
        System.out.println("You have defeated the " + opponent.getName() + "!");
        Thread.sleep(500);
        System.out.println("The " + opponent.getName() + " dropped " + opponent.getMoney() + " gold!");
        addMoney(opponent.getMoney());
        addExp(expGain);
        Thread.sleep(500);
    }
    public void levelUp(int levels) throws InterruptedException {
        System.out.println("You have leveled up!");
        this.level += levels;
        this.exp %= 10;
        this.strength++;
        this.capHealth();
        this.bumpExp();
        this.printStats();

    }
    public void printStats() throws InterruptedException {
        System.out.println("___*YOUR LEVELS*___");
        Thread.sleep(500);
        System.out.println("Your level : " + this.getLevel());
        System.out.println("Your Health : " + this.getHealth());
        System.out.println("Your Strength : " + this.getStrength());
        System.out.println("Your EXP : " + this.getExp());
        System.out.println("");
    }
}
