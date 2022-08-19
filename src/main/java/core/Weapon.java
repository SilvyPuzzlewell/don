/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.Random;


/**
 *
 * @author Ronald
 */
import java.io.Serializable;
public class Weapon extends Item implements ObjectsForAttacking, Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7778882869080619451L;

	public ObjectType getItemType() {
        return itemType;
    }
    private int maxDamage;
    private int minDamage;
    private final ObjectType itemType;
    Random rand = new Random();

    public Weapon(String name, String description, double weight, int minDamage, int maxDamage, boolean destroyable) {
        super(name, description, weight,destroyable);
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.itemType = ObjectType.MELEEWEAPON;
    }

   

    public String attackCharacter(GameCharacter source, GameCharacter victim) {
        int strike = rand.nextInt(getMaxDamage() - getMinDamage()) + getMinDamage();//throws new attack value
        String retAppend = victim.takeDamage(strike);
        if(retAppend.equals(CriticalStringMessage.MAIN_CHARACTER_KILLED.getMessage())){
            return retAppend;
        }
        return (source.getName() + " attacks and deals " + strike + " damage to "  + victim.getName()+ " " + retAppend + "\n");
    }

    /**
     * @return the maxDamage
     */
    public int getMaxDamage() {
        return maxDamage;
    }

    /**
     * @return the minDamage
     */
    public int getMinDamage() {
        return minDamage;
    }

    @Override
    public String attack(DestroyableObject obc, GameCharacter character) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


   
}

   
