/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.io.Serializable;
import java.util.logging.Logger;

/**
 * Abstract class representing supertype for all objects which are not "subjects"
 * or "active intities" of the game
 * @author Ronald
 */
public abstract class GameObject implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -3624089525327147481L;

	private static final Logger LOG = Logger.getLogger(GameObject.class.getName());

    /**
     * Object which is defined as lockable can be locked
     */
    protected boolean locked;

    /**
     *
     */
    protected String name;

    /**
     *
     */
    protected String description;

    /**
     *contains qualities of the object
     */
    protected DefinedObjectQualities[] objectQualities;

    /**
     *
     * @param name
     * @param description
     * @param obstacle
     * @param lockable
     * @param hasInventory
     * @param portable
     * @param destroyable
     * @param locked
     */
    public GameObject(String name, String description, boolean obstacle, boolean lockable, boolean hasInventory, boolean portable, boolean destroyable, boolean locked) {
        this.name = name;
        this.description = description;
        objectQualities = new DefinedObjectQualities[5];
        if (obstacle) {
            objectQualities[DefinedObjectQualities.OBSTACLE.getIndex()] = DefinedObjectQualities.OBSTACLE;
        }
        if (lockable) {
            objectQualities[DefinedObjectQualities.LOCKABLE.getIndex()] = DefinedObjectQualities.LOCKABLE;
        }
        if (hasInventory) {
            objectQualities[DefinedObjectQualities.PORTABLE_CONTAINER.getIndex()] = DefinedObjectQualities.PORTABLE_CONTAINER;
        }
        if (portable) {
            objectQualities[DefinedObjectQualities.PORTABLE.getIndex()] = DefinedObjectQualities.PORTABLE;
        }
        if (destroyable) {
            objectQualities[DefinedObjectQualities.DESTROYABLE.getIndex()] = DefinedObjectQualities.DESTROYABLE;
        }
        if(!lockable && locked){
            LOG.warning("Trying to set locked to object defined as unlockable");
        } else{
            this.locked = locked;
        }

    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return true if the object is obstacle
     */
    public boolean isObstacle() {
        return getObjectQualities()[DefinedObjectQualities.OBSTACLE.getIndex()] != null;
    }

    /**
     * @return true if the object is lockable
     */
    public boolean isLockable() {
        return getObjectQualities()[DefinedObjectQualities.LOCKABLE.getIndex()] != null;
    }

    /**
     * @return if the object has it's own inventory
     */
    public boolean hasInventory() {
        return getObjectQualities()[DefinedObjectQualities.PORTABLE_CONTAINER.getIndex()] != null;

    }

    /**
     * @return true if the object can be carried in inventory
     */
    public boolean isPortable() {
        return getObjectQualities()[DefinedObjectQualities.PORTABLE.getIndex()] != null;

    }
    
    /**
     *
     * @return true if the object is destroyable
     */
    public boolean isDestroyable() {
        return getObjectQualities()[DefinedObjectQualities.DESTROYABLE.getIndex()] != null;

    }

    /**
     * @return if the object is locked
     */
    public boolean isLocked() {
        return locked;
    }

    /**
     * @param locked the locked to set
     */
    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    /**
     * @return the objectQualities
     */
    public DefinedObjectQualities[] getObjectQualities() {
        return objectQualities;
    }
}
