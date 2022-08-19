/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.io.Serializable;

/**
 * Items is object that you can carry and usually use for something, it is defautly portable
 * @author Ronald
 */
public abstract class Item extends GameObject implements ObjectOnLevelPoint, Serializable{
 
    /**
	 * 
	 */
	private static final long serialVersionUID = -940254686946503567L;

	/**
     *
     */
    protected double weight;

    /**
     *Specifies type of the item, usually determining for what is it used.
     */
    protected ObjectType itemType;

    /**
     *
     * @return
     */
    public ObjectType getItemType() {
        return itemType;
    }
   
    /**
     *
     * @param name
     * @param description
     * @param weight
     * @param destroyable
     */
    public Item(String name, String description, double weight, boolean destroyable){
   
       super(name, description,false, false,false, true, destroyable, false);
       this.weight = weight;      
   }

    /**
     * @return the weight
     */
    public double getWeight() {
        return weight;
    }
}
