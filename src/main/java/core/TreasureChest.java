/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import don_aman.AvailableKeyAttachments;

/**
 *
 * @author Ronald
 */
public class TreasureChest extends GameObject implements LockableObject {

    private AvailableKeyAttachments unlockedBy;
    private Inventory inventory;
    private ObjectType objectType;

    public TreasureChest(String name, String description, boolean obstacle,
                        boolean lockable, boolean portable, boolean destroyable, boolean locked,
                        AvailableKeyAttachments unlockedBy, Inventory inventory) {
        super(name, description, obstacle, lockable, true, portable, destroyable, locked);
        this.unlockedBy = unlockedBy;
        this.inventory = inventory;
        this.locked = locked;       
    }

    @Override
    public String lock(Key key, GameCharacter gcharacter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String unlock(Key key, GameCharacter gcharacter) {
        if (key.whatThisOpens() == unlockedBy && locked) {
            locked = false;
            return ("Success, the " + name + " is now unlocked!\n");
        }
        if (!locked) {
            return ("Already unlocked..\n");
        } else {
            return ("oops, wrong key..\n");
        }
    }

    @Override
    public boolean isUnlocked() {
        return super.isLocked();
    }

}
