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
public abstract class Obstacle extends GameObject {
    protected final int[] ORIENTATION;
    protected boolean passable;
    public Obstacle(String name, String description, boolean lockable,boolean hasInventory, boolean destroyable, int[] ORIENTATION, boolean passable, boolean locked) {
        super(name, description,true,lockable,hasInventory,false, destroyable, locked);
        this.ORIENTATION = ORIENTATION;
        this.passable = passable;
        
    }

    /**
     * @return the passable
     */
    public boolean isPassable() {
        return passable;
    }

    /**
     * @param passable the passable to set
     */
    public void setPassable(boolean passable) {
        this.passable = passable;
    }

    /**
     * @return the ORIENTATION
     */
    public int[] getORIENTATION() {
        return ORIENTATION;
    }
     
      
}
