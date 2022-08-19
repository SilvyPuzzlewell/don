/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Ronald
 */
public class Level implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6173193331788868071L;
	private LevelPoint[][] levelMap;
    private int[] entrances;
    private ArrayList<NPC> npcs;

    /**
     * sets the level map, including which level points are temporarily unpassable due to obstacle Objects
     * @param levelMap
     * @param entrances
     * @param npcs
     */
    public Level(LevelPoint[][] levelMap, int[] entrances, ArrayList<NPC> npcs) {
        this.levelMap = levelMap;
        this.npcs = npcs;
        for (int row = 0; row < levelMap.length; row++) {
            for (int col = 0; col < levelMap[row].length; col++) {
                LevelPoint point = levelMap[row][col];
                if (point != null && point.getObjectsOnPoint() != null) {
                    for (int i = 0; i < point.getObjectsOnPoint().size(); i++) {
                        if (point.getObjectsOnPoint().get(i).isObstacle()) {
                            Obstacle o = (Obstacle) point.getObjectsOnPoint().get(i);
                            if (!o.isPassable()) {
                                int[] block = o.getORIENTATION();
                                int coordinatex = block[0];
                                int coordinatey = block[1];
                                levelMap[row + coordinatex][col + coordinatey].setWalkable(false);
                            }
                        }
                    }
                }
            }

        }
        this.entrances  = entrances;
    }
     
    /**
     *
     * @return coordinates of levelpoints through which you can leave the level
     */
    public int[] getEntrances() {
        return entrances;
    }

    /**
     * @return the level map
     */
    public LevelPoint[][] getLevelMap() {
        return levelMap;
    }

    /**
     * @return the NPCs in level
     */
    public ArrayList<NPC> getNPCs() {
        return npcs;
    }

    /**
     * @param NPCs the NPCs to set
     */
    public void setNPCs(ArrayList<NPC> characters) {
        this.npcs = npcs;
    }

}
