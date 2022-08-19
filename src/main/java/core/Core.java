/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Crucial class of the game core, it represents the centre of it's data structure,
 * instance it only once in class GameCore, through which are it's data accesible
 * @author Ronald
 */
public class Core implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -932078179224137933L;
	private Level level;
    private MainCharacter mainCharacter;
    private ArrayList<NPC> npcs;
    //list of npcs fighting the main character
    private ArrayList<NPC> fightingNPCs;
    
    /**
     *
     * @param level
     * @param mainCharacter
     */
    


	/**
     *
     * @return actual level
     */
    public Level getLevel(){
        return level;
    }

    public ArrayList<NPC> getFightingNPCs() {
		return fightingNPCs;
	}

	public void setFightingNPCs(ArrayList<NPC> fightingNPCs) {
		this.fightingNPCs = fightingNPCs;
	}

	/**
     *
     * @return actual level map, which means all actual levelpoints
     */
    public LevelPoint[][] getLevelMap() {
        return level.getLevelMap();
    }

    /**
     *
     * @param coordinatex
     * @param coordinatey
     * @return specific levelpoint
     */
    public LevelPoint getLevelPoint(int coordinatex, int coordinatey){
        return level.getLevelMap()[coordinatex][coordinatey];
    }

    /**
     *
     * @param coordinatex
     * @param coordinatey
     * @return specific levelpoint description
     */
    public String getLevelPointDescription(int coordinatex, int coordinatey){
        return level.getLevelMap()[coordinatex][coordinatey].getDescription();
    }

    /**
     *
     * @param coordinatex
     * @param coordinatey
     * @return ArrayList of Objects on actual LevelPoint
     */
    public ArrayList<GameObject> getObjectsOnLevelPoint(int coordinatex, int coordinatey){
        return getLevelPoint(coordinatex, coordinatey).getObjectsOnPoint();
    }

    /**
     *
     * @param gcharacter
     * @return coordinate x of specific character
     */
    public int getCoordinateIndex1(GameCharacter gcharacter) {
        return gcharacter.getCoordinates()[0];
    }

    /**
     *
     * @param x
     * @param y
     * @param gcharacter
     * @return LevelPoint to in specific direction, use x,y = 0 or 1;
     */
    public LevelPoint getMoveDirection(int x, int y,GameCharacter gcharacter){
        return getLevelPoint(getCoordinateIndex1(gcharacter) +x, getCoordinateIndex2(gcharacter) + y);
    }

    /**
     *
     * @param x
     * @param y
     * @param gcharacter
     * @return get Description of LevelPoint on which specific character stands
     */
    public String getDescription(int x, int y,GameCharacter gcharacter){
        return getLevelPoint(getCoordinateIndex1(gcharacter) + x, getCoordinateIndex2(gcharacter)+ y).getDescription();  
    }

    /**
     *
     * @param x
     * @param y
     * @param gcharacter
     * @return return String specifing position of specific character
     */
    public String getPosition(int x, int y,GameCharacter gcharacter){
      return (getCoordinateIndex1(gcharacter) + ""+ getCoordinateIndex2(gcharacter));  
    }

    /**
     *
     * @param gcharacter
     * @return specific character's coordinates
     */
    public int[] getPosition(GameCharacter gcharacter){
        return new int[]{getCoordinateIndex1(gcharacter),getCoordinateIndex2(gcharacter)}; 
    }

    /**
     *
     * @param gcharacter
     * @return return specific characters coordinate y
     */
    public int getCoordinateIndex2(GameCharacter gcharacter) {
        return gcharacter.getCoordinates()[1];
    }

    /**
     *
     * @param coordinateIndex1
     * @param gcharacter set x position for specific character
     */
    public void setCoordinateIndex1(int coordinateIndex1, GameCharacter gcharacter) {
        if(gcharacter.getId().equals(mainCharacter.getId())){
            gcharacter.setCoordinates(new int[]{coordinateIndex1,getCoordinateIndex2(gcharacter)});
        }
        for(GameCharacter gch: getCharacters()){
            if(gch.getId().equals(gcharacter.getId())){
                gch.setCoordinates(new int[]{coordinateIndex1,getCoordinateIndex2(gcharacter)});
            }
        }
        gcharacter.setCoordinates(new int[]{coordinateIndex1,getCoordinateIndex2(gcharacter)});
    }

    /**
     *
     * @param coordinateIndex2
     * @param gcharacter set y position for specific character
     */
    public void setCoordinateIndex2(int coordinateIndex2, GameCharacter gcharacter) {
        if(gcharacter.getId().equals(mainCharacter.getId())){
            gcharacter.setCoordinates(new int[]{getCoordinateIndex1(gcharacter),coordinateIndex2});
        }
        for(GameCharacter gch: getCharacters()){
            if(gch.getId().equals(gcharacter.getId())){
                gch.setCoordinates(new int[]{getCoordinateIndex1(gcharacter),coordinateIndex2});
            }
        }
        gcharacter.setCoordinates(new int[]{getCoordinateIndex1(gcharacter),coordinateIndex2});
    }

    /**
     * Set actual Level
     * @param level 
     */
    public void setLevel(Level level) {
        this.level = level;
    }

    /**
     *
     * @param mainCharacter
     * set Main character
     */
    public void setMainCharacter(MainCharacter mainCharacter){
        this.mainCharacter = mainCharacter;
    }

    /**
     *
     * @return main character
     */
    public MainCharacter getMainCharacter() {
        return mainCharacter;
    }

    /**
     *
     * @return Main character's inventory
     */
    public Inventory getMainCharInventory(){
        return mainCharacter.getInventory();
    }

    /**
     * @return the NPCs in actual Core (usually in actual level)
     */
    public ArrayList<NPC> getCharacters() {
        return npcs;
    }

    /**
     * @param npcs the npcs to set
     */
    public void setNpcs(ArrayList<NPC> npcs) {
        this.npcs = npcs;
    }
    
    
}
