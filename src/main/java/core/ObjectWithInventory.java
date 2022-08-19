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
public interface ObjectWithInventory {
    public Item removeFromInventory(Item item);
    public void addToInventory(Item item);
}
