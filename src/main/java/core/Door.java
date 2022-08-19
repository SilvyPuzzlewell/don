/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import don_aman.AvailableKeyAttachments;
import java.io.Serializable;

/**
 * Door is class of Obstacle which is usually opened by unlocking
 * @author Ronald
 */
public class Door extends Obstacle implements LockableObject, Serializable  {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -6696048745041844419L;
	private final AvailableKeyAttachments unlockedBy;

    /**
     * 
     * @param name
     * @param description
     * @param unlockedBy
     * @param orientation
     * @param destroyable
     * @param locked
     */
    public Door(String name, String description, AvailableKeyAttachments unlockedBy,int[] orientation,boolean destroyable,boolean locked) {
        super(name, description,true,false,destroyable,orientation,!locked, locked);
        this.unlockedBy = unlockedBy;
        this.locked = locked;
    }
     
    /**
     * Opener is subject trying the key on the door
     * @param key
     * @param Locker
     * @return String message determining success
     */
    @Override
    public String lock(Key key, GameCharacter Locker) {
        if(key.whatThisOpens() == unlockedBy && locked){
            locked = false;
            return ("Success, the door is now locked!\n");
        }
        if(!locked){
            return ("Already locked..\n");
        }
        else{
            return("oops, wrong key..\n");
        }
    }

    /**
     *
     * @return true if the door is unlocked
     */
    @Override
    public boolean isUnlocked() {
        return locked;
    }

    /**
     * Opener is subject trying the key on the door
     * @param key
     * @param Opener
     * @return String message of his succes
     */
    @Override
    public String unlock(Key key, GameCharacter Opener) {
         if(key.whatThisOpens() == unlockedBy && locked){
            locked = true;
            int coordinatex = GameCore.getCoordinateIndex1(Opener);
            int coordinatey = GameCore.getCoordinateIndex2(Opener);
            GameCore.getLevelPoint(coordinatex + ORIENTATION[0] , coordinatey+ ORIENTATION[1]).setWalkable(true);
            locked = false;
            passable = true;
            return ("Success, the door is now unlocked!\n");
        }
        if(!locked){
            return ("Already unlocked..\n");
        }
        else{
            return("oops, wrong key..\n");
        }
    }

}
