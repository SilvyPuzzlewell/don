/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package level_editor;

import core.Door;
import core.GameObject;
import core.Item;
import don_aman.CommonWeapons;
import core.LevelPoint;
import don_aman.AvailableKeyAttachments;
import java.util.ArrayList;
import java.io.Serializable;

/**
 *
 * @author Ronald
 */
public class LevelPoints implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -6679457552052420992L;
	private static ArrayList<GameObject> LevelPointaa(){
       ArrayList<GameObject> LevelPoint = new ArrayList<>();
       LevelPoint.add(CommonWeapons.MACHETTE.getWeapon());
       return LevelPoint;
    }
     private static ArrayList<GameObject> LevelPointMadsDoor(){
       ArrayList<GameObject> LevelPoint = new ArrayList<>();
       LevelPoint.add(CommonWeapons.DAGGER.getWeapon());
       LevelPoint.add(new Door("Mad's hallway door", "Ugly, old wooden door",
               AvailableKeyAttachments.MADS_DOOR, new int[]{0,1},false, true));
       return LevelPoint;
     }
    public  LevelPoint createLevelPointaa(){
        return new LevelPoint(LevelPointaa(), true,"You are at the beginning of small house hallway",false);
    }
    public LevelPoint createLevelPointWall(){
        return new LevelPoint(null, false, "old, rusty wall",false);
    }
    public LevelPoint createLevelPointKitchen(){
        return new LevelPoint(null, true, "Kitchen in Mad's House",false);
    }
    public LevelPoint createLevelPointEmpty(){
    return new LevelPoint(null, true, "old, rusty hallway",false);
    }
    public LevelPoint createLevelPointMadsDoor(){
    return  new LevelPoint(LevelPointMadsDoor(), true, "old, rusty hallway", true);
}

    
}
