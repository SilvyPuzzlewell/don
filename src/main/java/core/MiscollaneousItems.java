/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

/**
 * extend from here to create unique Items which doesn't belong to any defined category.
 * @author Ronald
 */
public abstract class MiscollaneousItems extends Item {

    public MiscollaneousItems(String name, String description, double weight, boolean destroyable) {
        super(name, description, weight, destroyable);
    }
    
    
}
