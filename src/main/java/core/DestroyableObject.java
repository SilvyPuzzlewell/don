/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

/**
 * Interface to identify destroyable objects
 * @author Ronald
 */
public interface DestroyableObject {

    /**
     *
     * @param damage
     * @return damage taken
     */
    public String takeDamage(int damage);
}
