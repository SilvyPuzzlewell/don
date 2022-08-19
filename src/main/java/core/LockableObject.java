/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;



/**
 * Define interface for lockable object
 * @author Ronald
 */
public interface LockableObject {
    public String lock(Key key, GameCharacter user);
    public String unlock(Key key, GameCharacter user);
    public boolean isUnlocked();
}
