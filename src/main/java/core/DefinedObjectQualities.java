/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

/**
 *
 * @author Ronald
 */
public enum DefinedObjectQualities {

    /**
     * Object quality lockable means that you can unlock the object in case it is locked,
     * and to do that you need the right key
     */
    LOCKABLE(0),

    /**
     * Object quality portable simply means any game entitis ability to add it to its inventory
     */
    PORTABLE(1),

    /**
     * Object quality portable container defines object with it's own inventory
     */
    PORTABLE_CONTAINER(2),

    /**
     * Destroyable means that you can destroy the object by attacking
     */
    DESTROYABLE(3),

    /**
     * Obstacle is object which's main purpose is to block movement until it's
     *  unlocked or destroyed
     */
    OBSTACLE(4);
    private final int index;
    private DefinedObjectQualities(int index){
        this.index = index;
    }

    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }
}
