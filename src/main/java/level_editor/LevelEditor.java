/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package level_editor;

import core.Level;
import core.LevelPoint;
import core.*;
import don_aman.CommonWeapons;
import don_aman.NPCs;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Code level and than run the saveLevel class to serialize it. It is highly 
 * recommended to save your code here into a text file, cause you would have to 
 * serialize it again if you change the implementation of serialized fields.
 * @author Ronald
 */
class LevelEditor implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 4576631203254040344L;
	private final int sizex = 5;
    private final int sizey = 12;
    private ArrayList<NPC> characters;
    
    private LevelPoint[][] MadsHouseMap(){
        LevelPoint[][] madsHouse = new LevelPoint[sizex][sizey];
        LevelPoints LevelPoints = new LevelPoints();
        madsHouse[1][0] = LevelPoints.createLevelPointWall();
        madsHouse[0][1] = LevelPoints.createLevelPointWall();
        madsHouse[1][1] = new LevelPoint(null, true, "Entrance to Mads mansion, "
                + "you see short hallway leading to a jagged wooden door", true);
        madsHouse[2][1] = LevelPoints.createLevelPointWall();
        madsHouse[0][2] = LevelPoints.createLevelPointWall();
        madsHouse[1][2] = LevelPoints.createLevelPointaa();
        madsHouse[2][2] = LevelPoints.createLevelPointWall();
        madsHouse[0][3] = LevelPoints.createLevelPointWall();
        madsHouse[1][3] = LevelPoints.createLevelPointEmpty();
        madsHouse[2][3] = LevelPoints.createLevelPointWall();
        madsHouse[0][4] = LevelPoints.createLevelPointWall();
        madsHouse[1][4] = LevelPoints.createLevelPointMadsDoor();
        madsHouse[2][4] = LevelPoints.createLevelPointWall();
        madsHouse[3][4] = LevelPoints.createLevelPointWall();
        madsHouse[0][5] = LevelPoints.createLevelPointWall();
        madsHouse[1][5] = new LevelPoint(null, true, "You are entering Mad's small kitchen, "
                + "it looks like he doesn't care about hygiene or order at all, but what "
                + "would you expect from such psycho guy.. at first look, you see nothing much"
                + "of an interest, the door out are right at your eyes", false);
        madsHouse[2][5] = LevelPoints.createLevelPointKitchen();
        madsHouse[3][5] = LevelPoints.createLevelPointKitchen();
        madsHouse[4][5] = LevelPoints.createLevelPointWall();
        madsHouse[0][6] = LevelPoints.createLevelPointWall();
        madsHouse[1][6] = LevelPoints.createLevelPointKitchen();
        madsHouse[2][6] = LevelPoints.createLevelPointKitchen();
        ArrayList<GameObject> p36 = new ArrayList<>();
        p36.add(CommonWeapons.LIGHTSABRE.getWeapon());
        
        madsHouse[3][6] = new LevelPoint(p36, true, "Kitchen in Mad's House. You notice something weird lying on the floor.", false);
        madsHouse[4][6] = LevelPoints.createLevelPointWall();
        madsHouse[0][7] = LevelPoints.createLevelPointWall();
        madsHouse[1][7] = LevelPoints.createLevelPointMadsDoor();
        madsHouse[2][7] = LevelPoints.createLevelPointWall();
        madsHouse[3][7] = LevelPoints.createLevelPointWall();
        madsHouse[0][8] = LevelPoints.createLevelPointWall();
        madsHouse[1][8] = new LevelPoint(null, true, "You are entering small hallway in mad's house"
                + " ,on the end, you see Mad himself", false);
        madsHouse[2][8] = LevelPoints.createLevelPointWall();
        madsHouse[0][9] = LevelPoints.createLevelPointWall();
        madsHouse[1][9] = LevelPoints.createLevelPointEmpty();
        madsHouse[2][9] = LevelPoints.createLevelPointWall();
        madsHouse[0][10] = LevelPoints.createLevelPointWall();
        madsHouse[1][10] = LevelPoints.createLevelPointEmpty();
        madsHouse[2][10] = LevelPoints.createLevelPointWall();
        madsHouse[1][11] = LevelPoints.createLevelPointWall();
        
        
        
        
        
        return madsHouse;       
    }
    private ArrayList<NPC> initCharacters(){
        characters = new ArrayList<>();
        NPCs npcs = new NPCs();
        NPC mad = npcs.getMAD_TWATTER();
        NPC madbutler = npcs.gatMADS_BUTLER();
        mad.setCoordinates(new int[]{1,9});
        characters.add(mad);
        return characters;
    }
    public Level MadsHouse = new Level(MadsHouseMap(), new int[]{3,0,0},initCharacters());
}
