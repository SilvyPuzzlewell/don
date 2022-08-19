/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Singleton design class which holds the game's actual core (usually representing current
 * level) and encapsulates methods for accessing it
 * @author Ronald
 */
public class GameCore {

    private static final Logger LOG = Logger.getLogger(GameCore.class.getName());
    private static Core gameCore = new Core();

    /**
     *
     * @return actual level
     */
    public static Level getLevel() {
        return gameCore.getLevel();
    }

    /**
     * @param aGameCore the gameCore to set
     */
    public static void setGameCore(Core aGameCore) {
        gameCore = aGameCore;
    }

    /**
     *
     * @return NPCs in actual core
     */
    public static ArrayList<NPC> getCharacters() {
        return gameCore.getCharacters();
    }

    private GameCore() {
    }

    /**
     * sets npcs in actual core
     * @param npcs
     */
    public static void setNpcs(ArrayList<NPC> npcs) {
        gameCore.setNpcs(npcs);
    }

    /**
     *
     * @param gcharacter
     * @return Objects on specific character's level point
     */
    public static ArrayList<GameObject> getActualLevelPointObjects(GameCharacter gcharacter) {
        int[] position = getPosition(gcharacter);
        return getObjectsOnLevelPoint(position[0], position[1]);
    }

    /**
     *
     * @param gcharacter
     * @param type
     * @return Objects of specific quaility on specific object's level point
     */
    public static ArrayList<GameObject> getObjectsWithSpecificQualityFromLevelPoint(ObjectWithInventory gcharacter, DefinedObjectQualities type) {
        ArrayList<GameObject> ret = new ArrayList<>();
        ArrayList<GameObject> cur= null;
        if(gcharacter instanceof GameCharacter){
        cur = getActualLevelPointObjects((GameCharacter)gcharacter);
        }
        if (cur == null) {
            return null;
        }
        int exceptionIndex = 0;
        switch (type) {
            case PORTABLE:
                try {
                    for (GameObject o : cur) {
                        if (o.isPortable()) {
                            ret.add(o);
                        }
                        exceptionIndex++;
                    }
                } catch (ClassCastException e) {
                    LOG.log(java.util.logging.Level.WARNING, "Object: {0} is wrongly defined as item(portable object).", cur.get(exceptionIndex).getName());
                }
                break;
            case DESTROYABLE:
                try {
                    for (GameObject o : cur) {
                        if (o.isDestroyable()) {
                            ret.add(o);
                        }
                        exceptionIndex++;
                    }
                } catch (ClassCastException e) {
                    LOG.log(java.util.logging.Level.WARNING, "Object: {0} is wrongly defined as item(portable object).", cur.get(exceptionIndex).getName());
                }
                break;
            case OBSTACLE:
                try {
                    for (GameObject o : cur) {
                        if (o.isObstacle()) {
                            ret.add((Obstacle) o);
                        }
                        exceptionIndex++;
                    }
                } catch (ClassCastException e) {
                    LOG.log(java.util.logging.Level.WARNING, "Object: {0} is wrongly defined as item(portable object).", cur.get(exceptionIndex).getName());
                }
                break;
            case PORTABLE_CONTAINER:
                try {
                    for (GameObject o : cur) {
                        if (o.hasInventory()) {
                            ret.add(o);
                        }
                        exceptionIndex++;
                    }
                } catch (ClassCastException e) {
                    LOG.log(java.util.logging.Level.WARNING, "Object: {0} is wrongly defined as item(portable object).", cur.get(exceptionIndex).getName());
                }
                break;
            case LOCKABLE:
                try {
                    for (GameObject o : cur) {
                        if (o.isLockable()) {
                            ret.add(o);
                        }
                        exceptionIndex++;
                    }
                } catch (ClassCastException e) {
                    LOG.log(java.util.logging.Level.WARNING, "Object: {0} is wrongly defined as item(portable object).", cur.get(exceptionIndex).getName());
                }
                break;
        }
        return ret;
    }

    /**
     *
     * @param gcharacter
     * @param type
     * @return list of specific Item type from specific character's inventory
     */
    public static ArrayList<Item> getSpecificObjectsFromInventory(ObjectWithInventory gcharacter, ObjectType type) {
        ArrayList<Item> ret = new ArrayList<>();
        ArrayList<Item> cur= null;
        if(gcharacter instanceof GameCharacter){
        GameCharacter character = (GameCharacter) gcharacter;
        cur = character.getInventory().getInventoryList();
        }
        if (cur == null) {
            return null;
        }
        int exceptionIndex = 0;
        switch (type) {
            case MELEEWEAPON:
                try {
                    for (Item o : cur) {
                        if (o.getItemType() == ObjectType.MELEEWEAPON) {
                            ret.add(o);
                        }
                        exceptionIndex++;
                    }
                } catch (ClassCastException e) {
                    LOG.log(java.util.logging.Level.WARNING, "Object: {0} is wrongly defined as item(portable object).", cur.get(exceptionIndex).getName());
                }
                break;
            case KEY:
                try {
                    for (Item o : cur) {
                        if (o.getItemType() == ObjectType.KEY) {
                            ret.add(o);
                        }
                        exceptionIndex++;
                    }
                } catch (ClassCastException e) {
                    LOG.log(java.util.logging.Level.WARNING, "Object: {0} is wrongly defined as item(portable object).", cur.get(exceptionIndex).getName());
                }
                break;
            case COMDEVICE:
                try {
                    for (Item o : cur) {
                        if (o.getItemType() == ObjectType.COMDEVICE) {
                            ret.add(o);
                        }
                        exceptionIndex++;
                    }
                } catch (ClassCastException e) {
                    LOG.log(java.util.logging.Level.WARNING, "Object: {0} is wrongly defined as item(portable object).", cur.get(exceptionIndex).getName());
                }
                break;
            case RANGEDWEAPON:
                try {
                    for (Item o : cur) {
                        if (o.getItemType() == ObjectType.RANGEDWEAPON) {
                            ret.add(o);
                        }
                        exceptionIndex++;
                    }
                } catch (ClassCastException e) {
                    LOG.log(java.util.logging.Level.WARNING, "Object: {0} is wrongly defined as item(portable object).", cur.get(exceptionIndex).getName());
                }
                break;
        }
        return ret;
    }

    /**
     *
     * @param coordinatex
     * @param coordinatey
     * @return description of specific level point
     */
    public static String getLevelPointDescription(int coordinatex, int coordinatey) {
        return gameCore.getLevelPointDescription(coordinatex, coordinatey);
    }

    /**
     *
     * @param gcharacter
     * @return return level point on which specific character stands
     */
    public static LevelPoint getActualLevelPoint(GameCharacter gcharacter) {
        int[] position = getPosition(gcharacter);
        return getLevelPoint(position[0], position[1]);
    }

    /**
     *
     * @param coordinatex
     * @param coordinatey
     * @return Objects on specific levelpoint
     */
    public static ArrayList<GameObject> getObjectsOnLevelPoint(int coordinatex, int coordinatey) {
        return gameCore.getObjectsOnLevelPoint(coordinatex, coordinatey);
    }

    /**
     *
     * @param x
     * @param y
     * @param gcharacter
     * @return level point in which specific character can move, use x, y = 0 or 1.
     */
    public static LevelPoint getMoveDirection(int x, int y, GameCharacter gcharacter) {
        return gameCore.getMoveDirection(x, y, gcharacter);
    }

    /**
     *
     * @param x
     * @param y
     * @param gcharacter
     * @return
     */
    public static String getPosition(int x, int y, GameCharacter gcharacter) {
        return gameCore.getPosition(x, y, gcharacter);
    }

    /**
     *
     * @param gcharacter
     * @return position of specific character
     */
    public static int[] getPosition(GameCharacter gcharacter) {
        return gameCore.getPosition(gcharacter);
    }

    /**
     *
     * @return Core instance, use to serialize it
     */
    public static Core getGameCore() {

        return gameCore;
    }

    /**
     *
     * @param coordinatex
     * @param coordinatey
     * @return specific level point
     */
    public static LevelPoint getLevelPoint(int coordinatex, int coordinatey) {
        return gameCore.getLevelPoint(coordinatex, coordinatey);
    }

    /**
     * set actual level
     * @param level
     */
    public static void setGameCoreLevel(Level level) {
        gameCore.setLevel(level);
    }
    

    /**
     *
     * @param gcharacter
     * @return
     */
    public static int getCoordinateIndex1(GameCharacter gcharacter) {
        return gameCore.getCoordinateIndex1(gcharacter);
    }

    /**
     *
     * @param gcharacter
     * @return
     */
    public static int getCoordinateIndex2(GameCharacter gcharacter) {
        return gameCore.getCoordinateIndex2(gcharacter);
    }

    /**
     *
     * @param coordinateIndex1
     * @param gcharacter
     */
    public static void setCoordinateIndex1(int coordinateIndex1, GameCharacter gcharacter) {
        gameCore.setCoordinateIndex1(coordinateIndex1, gcharacter);
    }

    /**
     *
     * @param coordinateIndex2
     * @param gcharacter
     */
    public static void setCoordinateIndex2(int coordinateIndex2, GameCharacter gcharacter) {
        gameCore.setCoordinateIndex2(coordinateIndex2, gcharacter);
    }

    /**
     *
     * @param mainCharacter
     */
    public static void setMainCharacter(MainCharacter mainCharacter) {
        gameCore.setMainCharacter(mainCharacter);
    }

    /**
     *
     * @return
     */
    public static MainCharacter getMainCharacter() {
        return gameCore.getMainCharacter();
    }

    /**
     *
     * @return main character's inventory
     */
    public static Inventory getYourInventory() {
        return gameCore.getMainCharInventory();
    }

    /**
     *
     * @return list of main character's inventory Items
     */
    public static ArrayList<Item> getYourInventoryList() {
        return getYourInventory().getInventoryList();
    }
    
    public static boolean isFighting() {
    	return !gameCore.getFightingNPCs().isEmpty();
    }
    
    public static boolean isNPCfighting(NPC npc) {
    	return gameCore.getFightingNPCs().contains(npc);
    }
    
    public static void addFightingNPC(NPC npc) {
    	gameCore.getFightingNPCs().add(npc);
    }
    
    public static void removeFightingNPC(NPC npc) {
    	gameCore.getFightingNPCs().remove(npc);
    }
    
    public static void setFightingNPC(ArrayList<NPC> npcs) {
    	gameCore.setFightingNPCs(npcs);
    }
}
