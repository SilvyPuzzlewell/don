/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.io.Serializable;

/**
 * Types of ordinary objects, each with unique usage.
 * @author Ronald
 */
public enum ObjectType implements Serializable {

    /**
     *Weapons for fighting in fixed level point
     */
    MELEEWEAPON("Melee weapon"),

    /**
     *tba
     */
    RANGEDWEAPON("Ranged weapon"),

    /**
     *tba
     */
    COMDEVICE("Communication device"),

    /**
     *Item for interacting with lockable objects
     */
    KEY("key"),

    /**
     *lockable obstacle
     */
    DOOR("door"),

    /**
     *lockable container  of items
     */
    TREASURE_CHEST("container of portable items");
    private final String name;
    private ObjectType(String name){
        this.name=name;
    }
}
