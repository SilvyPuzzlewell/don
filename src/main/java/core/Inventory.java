/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Inventory represents Items which specific Object own
 * @author Ronald
 */
public class Inventory implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 5655189687463595056L;

	/**
     *
     * @param capacity
     * @param weightCapacity
     */
    public Inventory(int capacity, int weightCapacity) {
        this.capacity = capacity;
        this.weightCapacity = weightCapacity;
        inventory = new ArrayList<>(capacity);
    }
    private ArrayList<Item> inventory = new ArrayList<>();
    private int numberOfItems;
    private int capacity;
    private double inventoryWeight;
    private int weightCapacity;

    /**
     * adds object to inventory
     * @param item
     * @return message about succesfulness of adding Item, remember, Inventory has limited capacity
     */
    public String add(Item item) {
        if (inventory.size() >= getCapacity() || getInventoryWeight() + item.getWeight() >= getWeightCapacity()) {
            return("Inventory is currently full, please drop something.\n");
        }
        getInventoryList().add(item);
        numberOfItems++;
        inventoryWeight += item.getWeight();
        return ("Item " + item.getName()+ " added to inventory\n");
    }
    
    /**
     * adds object to inventory
     * @param item
     * @return value of succesfulness of adding
     */
    public boolean addBool(Item item) {
        if (inventory.size() >= getCapacity() || getInventoryWeight() + item.getWeight() >= getWeightCapacity()) {
            return false;
        }
        getInventoryList().add(item);
        numberOfItems++;
        inventoryWeight += item.getWeight();
        return true;
    }

    /**
     *
     * @param index
     * @return Item on specific index
     */
    public Item get(int index){
        return inventory.get(index);
    }
    
     /**
      * drops item
     * @param item
     * @return Item dropped from inventory
     */
    public Item drop(Item item) {
        Item itemret = item;
        inventory.remove(item);
        inventoryWeight -= item.getWeight();
        return itemret;
    }

    /**
     * drops item at specific index
     * @param index
     * @return Item dropped from inventory
     */
    public Item drop(int index){
        Item ret = inventory.get(index);
        inventory.remove(index);
        inventoryWeight -= ret.getWeight();
        return ret;
    }

    /**
     * @return the inventory objects
     */
    public ArrayList<Item> getInventoryList() {
        return inventory;
    }

    /**
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * @return the inventoryWeight
     */
    public double getInventoryWeight() {
        return inventoryWeight;
    }

    /**
     * @return the weightCapacity
     */
    public int getWeightCapacity() {
        return weightCapacity;
    }

    /**
     *
     * @return number of Items stored in inventory
     */
    public int size(){
        return inventory.size();
    }
    
}
