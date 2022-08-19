/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.io.Serializable;

/**
 * Main class to represents non player characters
 * @author Ronald
 */
public class NPC extends GameCharacter {

    private Friendliness friendliness;
    private int armor;
    private boolean alive;
    private Weapon equippedWeapon;
    private AIinterface AIinterface;
    
    /**
     *
     * @param name
     * @param description
     * @param gender
     * @param maxHitpoints
     * @param curHitpoints
     * @param friendliness how npc react to maoin character, see friendliness enum
     * @param strength
     * @param finesse
     * @param endurance
     * @param intelligence
     * @param charisma
     * @param inventory
     * @param AIinterface Artificial intelligence set for NPC
     * @param coordinates
     * @param id Unique identification, use unique one for every instance!
     */
    public NPC(String name, String description,Gender gender, int maxHitpoints,
            int curHitpoints, Friendliness friendliness, int strength, int finesse, 
            int endurance, int intelligence, int charisma,Inventory inventory,AIinterface AIinterface, int[] coordinates, String id) {
        super(name, description,gender,maxHitpoints, curHitpoints, strength, finesse, endurance, intelligence, charisma,inventory,id, coordinates);
        this.friendliness = friendliness;
        this.inventory = inventory;
        this.AIinterface = AIinterface;
        alive = true;
    }
    
    /**
     * tba
     * @param item
     */
    public void interact(Item item){
        
    }

    @Override
    public String takeDamage(int damage) {
        curHitpoints -= damage;
        if(curHitpoints <= 0){
    		String ret = die();
    		return ret;
        }
        return(name +" losts " + damage + " hitpoints. "+ " he now has " + curHitpoints + " hitpoints");
    }
    @Override
    public String attack(DestroyableObject obj){
        return (name + " attacks with " + equippedWeapon);
    }
    
    private String die() {
        setAlive(false);
        if (GameCore.isNPCfighting(this)){
        	GameCore.removeFightingNPC(this);
        }
        return("You killed " + getName() +".");
    }

    /**
     *
     * @return friendliness
     */
    public Friendliness getFriendliness() {
        return friendliness;
    }

    /**
     * tba
     * @return
     */
    public int getArmor() {
        return armor;
    }

 

    /**
     * @return is alive
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     * @return the AIinterface
     */
    public AIinterface getAIinterface() {
        return AIinterface;
    }

    /**
     * @param alive the alive to set
     */
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    /**
     * @param AIinterface the AIinterface to set
     */
    public void setAIinterface(AIinterface AIinterface) {
        this.AIinterface = AIinterface;
    }
    
}
