/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Template for individual level points
 * @author Ronald
 */
public class LevelPoint implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 8813738689460233951L;
	private ArrayList<GameObject> ItemsOnPoint = new ArrayList<>();
    private boolean walkable;
    private boolean isEntrance;
    private String description;
    
    /**
     *
     * @param ObjectsOnPoint 
     * @param walkable you cannot pass through unwalkable points
     * @param description
     * @param isEntrance place where you can leave the level
     */
    public LevelPoint(ArrayList<GameObject> ObjectsOnPoint, boolean walkable, String description, boolean isEntrance) {
        this.ItemsOnPoint = ObjectsOnPoint;
        this.walkable = walkable;
        this.description = description;
        this.isEntrance = isEntrance;
        if(ObjectsOnPoint == null){
            ObjectsOnPoint = new ArrayList<>();
        }
    }

    /**
     *
     * @return
     */
    public boolean IsEntrance() {
        return isEntrance;
    }

    /**
     * @return the ItemsOnPoint
     */
    public ArrayList<GameObject> getObjectsOnPoint() {
        return ItemsOnPoint;
    }

    /**
     * @return the walkable
     */
    public boolean isWalkable() {
        return walkable;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param walkable the walkable to set
     */
    public void setWalkable(boolean walkable) {
        this.walkable = walkable;
    }

    /**
     * @param ItemsOnPoint the ItemsOnPoint to set
     */
    public void setItemsOnPoint(ArrayList<GameObject> ItemsOnPoint) {
        this.ItemsOnPoint = ItemsOnPoint;
    }
 
}
