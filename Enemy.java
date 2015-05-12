/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package therealslimshady;

/**
 *
 * @author s447335
 */
public class Enemy extends Player{
   

    public Enemy() {
        super();
    }
    public Enemy(String nm, int hp, int lvl, int str) {
        super(nm,hp,lvl,str);
    }

    
    
    @Override
    public void setHealth(int change) {
        //Add negative values for when you lose health
        this.health += change;
        if(this.health <= 0) {
            System.out.println("The " + this.getName() + " has died!");
            
        }
    }

}
