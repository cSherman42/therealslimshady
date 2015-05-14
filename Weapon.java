package therealslimshady;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author s447335
 */
public class Weapon {
    
    private String name;
    private int strength;
    private int cost;
  //private int durability;
    public Weapon() {
        name = "defualt";
        strength = 1;
    }
    public Weapon(String nm, int str, int cst) {
        name = nm;
        strength = str;
        cost=cst;
    }
    @Override
    public String toString() {
        return name + ", " + strength + " strength, -->" + cost + " gold";
    }
    public int getCost() {
        return this.cost;
    }
    public String getName() {
        return this.name;
    }
    public int getStrengthBonus() {
        return this.strength;
    }
}
