/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import don_aman.AvailableKeyAttachments;
import java.io.Serializable;


/**
 * Key is item used to manipulate lockable objects
 * @author Ronald
 */
public class Key extends Item implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -5890740048226049837L;
	private AvailableKeyAttachments whatThisOpens;
    
    /**
     *
     * @param name
     * @param description
     * @param weight
     * @param destroyable
     * @param whatThisOpens
     */
    public Key(String name, String description, double weight,boolean destroyable, AvailableKeyAttachments whatThisOpens) {
        super(name, description, weight, destroyable);
        this.itemType=ObjectType.KEY;
        this.whatThisOpens = whatThisOpens;
    }

    /**
     * lItem is object a
     * @param lObject is object to unlock
     * @param user is character trying to unlock it
     * @return message about his success
     */
    public String unlock(LockableObject lObject, GameCharacter user){
        return lObject.unlock(this,user);
    }

    /**
     * tba
     * @param lItem
     * @param user
     * @return message about his success
     */
    public String lock(LockableObject lItem, GameCharacter user){
        return lItem.lock(this, user);
    }

    /**
     * 
     * @return specific attachment determining what is opened with the key
     */
    public AvailableKeyAttachments whatThisOpens(){
        return whatThisOpens;
    }
    
}
