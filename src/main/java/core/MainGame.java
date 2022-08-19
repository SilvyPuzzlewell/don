/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import don_aman.CreateCharacterData;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class which realizes MainGame screen events, including NPC actions
 * @author Ronald
 */
public class MainGame implements Serializable {
	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 2863086861104189683L;
	
	private GameCharacter gcharacter;
    
    private final String EQUIP_WEAPON_MESSAGE = "equip weapon to strike!\n";
    private final String THINGS_ON_LEVELPOINT_MESSAGE = "Things you found here: \n";
    private String createCharacterHitObstacleMessage(int relativeXCoordinate, int relativeYCoordinate) {
    	if (getObstacleOrientation(relativeXCoordinate, relativeYCoordinate) != null) {
    		return "You hit " + getObstacleOrientation(relativeXCoordinate, relativeYCoordinate).getDescription() + "\n";
    	}
    	else {
    		return "You hit " + getDescription(relativeXCoordinate, relativeYCoordinate) + "\n";
    	}
    	
    }
    
    public final String CANT_RUN_WHILE_FIGHTING_MESSAGE = "You can't run away from combat!\n";
    
    private String getDescription(int x, int y) {
        return GameCore.getLevelPoint(GameCore.getCoordinateIndex1(gcharacter) + x, GameCore.getCoordinateIndex2(gcharacter) + y).getDescription();
    }

    private String getPosition(int x, int y) {
        return (GameCore.getCoordinateIndex1(gcharacter) + " " + GameCore.getCoordinateIndex2(gcharacter));
    }
    
    public String getDescription() {
        return ("Point " + getPosition(0, 0) + ": " + getDescription(0, 0) + "\n");
    }

    /**
     * attack method used by NPC characters
     * @return attack information
     */
    public String attack() {
        String ret = gcharacter.equippedWeapon.attackCharacter(gcharacter, GameCore.getMainCharacter());
        return ret;

    }

    /**
     * attack method for the main character
     * @param npc who you are going to attack
     * @return attack information message, returns warning for attacking without weapon
     */
    public String mainCharacterAttacs(NPC npc) {
        if (GameCore.getMainCharacter().getEquippedWeapon() == null) {
            return EQUIP_WEAPON_MESSAGE;
        }
        String ret = gcharacter.equippedWeapon.attackCharacter(gcharacter, npc);
        return ret;
    }

    /**
     *
     * @return list of hostile characters on main characters actual level point, on which you can attack.
     */
    public ArrayList<NPC> getHostiles() {
        ArrayList<NPC> npcs = GameCore.getCharacters();
        ArrayList<NPC> ret = new ArrayList<>();
        if (npcs == null) {
            return null;
        }
        for (NPC c : npcs) {
            if (Arrays.equals(c.getCoordinates(), GameCore.getMainCharacter().getCoordinates())
                    && c.getFriendliness() == Friendliness.HOSTILE && c.isAlive()) {
                ret.add(c);
            }
        }
        return ret;
    }

    /**
     * tba for NPCs
     * @return list of portable items on your main characters actual level point
     */
    public ArrayList<Item> pick() {
        ArrayList<GameObject> cur = GameCore.getActualLevelPointObjects(GameCore.getMainCharacter());
        if (cur == null) {
            return null;
        }
        if (cur.isEmpty()) {
            return null;
        }
        ArrayList<Item> ret = new ArrayList<>();
        for (GameObject item : cur) {
            if (item.isPortable()) {
                Item o = (Item) item;
                ret.add(o);
            }
        }
        if (ret.isEmpty()) {
            return null;
        }
        return ret;
    }

    /**
     *
     * @return MainCharacter's equipped weapon
     */
    public Weapon getMainCharEqWeapon() {
        return GameCore.getMainCharacter().getEquippedWeapon();
    }


    /**
     * constructor
     * @param gcharacter character for which this model is specified, NPCs 
     * can create their own instances to use
     */
    public MainGame(GameCharacter gcharacter) {
        this.gcharacter = gcharacter;
    }

    /**
     * Main character searches the level point (use usually to show found objects in GUI)
     * @return found GameObjects
     */
    public ArrayList<String> examine() {
        ArrayList<String> ret = new ArrayList<>();
        ret.add(getDescription());
        if (GameCore.getActualLevelPointObjects(GameCore.getMainCharacter()) != null) {
            for (int i = 0; i < GameCore.getActualLevelPointObjects(GameCore.getMainCharacter()).size(); i++) {
                if (i == 0) {
                    ret.add(THINGS_ON_LEVELPOINT_MESSAGE);
                }
                GameObject object = GameCore.getActualLevelPointObjects(GameCore.getMainCharacter()).get(i);
                ret.add(GameCore.getActualLevelPointObjects(GameCore.getMainCharacter()).get(i).getDescription() + "\n");

            }
        }
        return ret;
    }
    private static final Logger LOG = Logger.getLogger(GameObject.class.getName());

    
    /**
     * move method for main character
     * @param direction
     * @return move message(description of new level point or cause failure to pass on)
     */
    public String move(int direction) { // 1-north,2-west,3-east,4-south
        try {
            switch (direction) {
                case 1:
                    if (getMoveDirection(0, 1).isWalkable()) {
                        GameCore.setCoordinateIndex2(GameCore.getCoordinateIndex2(gcharacter) + 1, gcharacter);
                        return getDescription();
                    } else {
                    	return createCharacterHitObstacleMessage(0, 1);
                    }

                case 2:
                    if (getMoveDirection(1, 0).isWalkable()) {
                        GameCore.setCoordinateIndex1(GameCore.getCoordinateIndex1(gcharacter) + 1, gcharacter);
                        return getDescription();
                    } else {
                    	return createCharacterHitObstacleMessage(1, 0);
                    }
                case 3:
                    if (getMoveDirection(0, -1).isWalkable()) {
                        GameCore.setCoordinateIndex2(GameCore.getCoordinateIndex2(gcharacter) - 1, gcharacter);
                        return getDescription();
                    } else {
                    	return createCharacterHitObstacleMessage(0, -1);
                    }
                case 4:
                    if (getMoveDirection(-1, 0).isWalkable()) {
                        GameCore.setCoordinateIndex1(GameCore.getCoordinateIndex1(gcharacter) - 1, gcharacter);
                        return getDescription();
                    } else
                    	return createCharacterHitObstacleMessage(-1, 0);                    
            		}
        } catch (NullPointerException e) {
            LOG.warning("exception - Moving through null levelpoint");
        } catch (ArrayIndexOutOfBoundsException e) {
            LOG.warning("exception - Moving out of level map");
        }
        return null;
    }

    /**
     * method which initiates turn for all alive NPCs in the level in their own
     * Callable thread, which return Strinnpg information about what they have done
     * @return list of informations about NPCs actions
     */
    public ArrayList<String> opponentTurn() {
        ArrayList<NPC> cur = GameCore.getCharacters();
        ArrayList<String> ret = new ArrayList<>();
        for (NPC npc : cur) {
            String retS = null;
            if (npc.isAlive()) {
                try {
                    retS = npc.getAIinterface().call();
                } catch (Exception ex) {
                    Logger.getLogger(MainGame.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (retS != null) {
                    ret.add(retS);
                }
            }
        }
        return ret;
    }

    /**
     * Closes game if you die
     */
    public void exitGameDead() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(MainGameScreen.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            System.exit(1);
        }

    }
    
    /**
     * move method for NPCs
     * @param direction 1-north,2-west,3-east,4-south
     * @return 2 = succesful movement, 1 = run into obstacle, 0 = run into unpassable level point
     */
    public int NPCmove(int direction) { // 1-north,2-west,3-east,4-south
        try {
            switch (direction) {
                case 1:
                    if (getMoveDirection(0, 1).isWalkable()) {
                        GameCore.setCoordinateIndex2(GameCore.getCoordinateIndex2(gcharacter) + 1, gcharacter);
                        return 2;
                    } else if (getObstacleOrientation(0, 1) != null) {
                        return 1;
                    }
                    return 0;

                case 2:
                    if (getMoveDirection(1, 0).isWalkable()) {
                        GameCore.setCoordinateIndex1(GameCore.getCoordinateIndex1(gcharacter) + 1, gcharacter);
                        return 2;
                    } else if (getObstacleOrientation(1, 0) != null) {
                        return 1;
                    }
                    return 0;
                case 3:
                    if (getMoveDirection(0, -1).isWalkable()) {
                        GameCore.setCoordinateIndex2(GameCore.getCoordinateIndex2(gcharacter) - 1, gcharacter);
                        return 2;
                    } else if (getObstacleOrientation(0, -1) != null) {
                        return 1;
                    }
                    return 0;
                case 4:
                    if (getMoveDirection(-1, 0).isWalkable()) {
                        GameCore.setCoordinateIndex1(GameCore.getCoordinateIndex1(gcharacter) - 1, gcharacter);
                        return 2;
                    } else if (getObstacleOrientation(-1, 0) != null) {
                        return 1;
                    }
                    return 0;
            }
        } catch (NullPointerException e) {
            LOG.warning("exception - Moving through null levelpoint");
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            LOG.warning("exception - Moving out of level map");
        }
        return -1;
    }

    /**
     * adds Item to inventory
     * @param item
     * @return message information
     */
    public String pick(Item item) {
        String ret = gcharacter.getInventory().add(item);
        GameCore.getActualLevelPointObjects(gcharacter).remove(item);
        return ret;
    }

    /**
     * saves the actual game to default file "SaveGame.ser". tba - more savegame slots;
     */
    public void saveGame() {
        try {
            FileOutputStream out = new FileOutputStream("SaveGame.ser");
            ObjectOutputStream Out = new ObjectOutputStream(out);
            Out.writeObject(GameCore.getGameCore());
            Out.close();
            out.close();
            System.out.print("Success!");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    /**
     *
     * @return Description of your characters position(levelpoint description + coordinates).
     */


    private Obstacle getObstacleOrientation(int index1, int index2) {
        ArrayList<GameObject> list = GameCore.getObjectsWithSpecificQualityFromLevelPoint(gcharacter, DefinedObjectQualities.OBSTACLE);
        if (list == null) {
            return null;
        }
        for (GameObject o : list) {
            Obstacle O = (Obstacle) o;
            if (O.getORIENTATION()[0] == index1 && O.getORIENTATION()[1] == index2) {
                return O;
            }
        }
        return null;
    }

    private LevelPoint getMoveDirection(int x, int y) {
        LevelPoint ret = GameCore.getLevelPoint(GameCore.getCoordinateIndex1(gcharacter) + x, GameCore.getCoordinateIndex2(gcharacter) + y);
        return GameCore.getLevelPoint(GameCore.getCoordinateIndex1(gcharacter) + x, GameCore.getCoordinateIndex2(gcharacter) + y);
    }


}
