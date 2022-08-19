/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * MainCharacter represents, well, your main character
 * @author Ronald
 */
public class MainCharacter extends GameCharacter {

    private int experience;
    private Level level;

    /**
     * id is unique representation String, coordinates are two item integer array, [0] is x coordinate
     * [1] y coordinate; get values from your implementation of game
     * @param name
     * @param description
     * @param gender
     * @param strength
     * @param finesse
     * @param endurance
     * @param intelligence
     * @param charisma
     * @param inventory
     * @param coordinates 
     * @param id
     */
    public MainCharacter(String name, String description,Gender gender, int strength, int finesse, int endurance,
            int intelligence, int charisma,Inventory inventory,int[] coordinates, String id) {
        super(name, description,gender,(20+ endurance * 4), (20+endurance*4), strength, finesse, endurance, intelligence, charisma,inventory,id, coordinates);
        experience = 0;
    }
    
    @Override
    public String attack(DestroyableObject obj){
        return ("You attacks with "+ equippedWeapon.getDescription());
    }
    
   @Override
    public String takeDamage(int damage) {
        curHitpoints -= damage;
        if (curHitpoints <= 0) {
            return (CriticalStringMessage.MAIN_CHARACTER_KILLED.getMessage());
        }
        return("You lost " + damage + " hitpoints. Now you have " + curHitpoints + " hitpoints");
    }
//
//    public void take(ArrayList<ObjectOnLevelPoint> ItemsOnPoint, int i){
//       
//    }

    /**
     * @return the level
     */
    public Level getLevel() {
        return level;
    }

    /**
     * @param maxHitpoints the maxHitpoints to set
     */
    public void setMaxHitpoints(int maxHitpoints) {
        this.maxHitpoints = maxHitpoints;
    }

   
    /**
     * @param curHitpoints the curHitpoints to set
     */
    public void setCurHitpoints(int curHitpoints) {
        this.curHitpoints = curHitpoints;
    }


}
