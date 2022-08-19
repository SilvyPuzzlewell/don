/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package don_aman;

import core.Gender;
import core.Item;
import java.util.ArrayList;

/**
 *
 * @author Ronald
 */
public class CreateCharacterData {
    private static final int minAbilityValue = 6;
    private static final int maxAbilityValue = 18;
    private static final int startAbilityValue = 9;
    private static final int pointsToSpend = 9;
    private static final int[] startPosition = new int[]{1,1};
    private static final Gender gender = Gender.MALE;
    private static ArrayList<Item> startEquipment;
    private static final String description = ("Here will be your characters history, personality, etc.");
    private static final String name = ("Don Aman");
    private static final String id = ("MAIN_CHARACTER");

    /**
     * @return the startEquipment
     */
    public static ArrayList<Item> getStartEquipment() {
        return startEquipment;
    }

    /**
     * @return the gender
     */
    public static Gender getGender() {
        return gender;
    }

    /**
     * @return the description
     */
    public static String getDescription() {
        return description;
    }

    /**
     * @return the name
     */
    public static String getName() {
        return name;
    }

    /**
     * @return the id
     */
    public static String getId() {
        return id;
    }
    
    public CreateCharacterData(){
        startEquipment = new ArrayList<>();
        startEquipment.add(CommonWeapons.MACHETTE.getWeapon());
        startEquipment.add(Keys.MADS_DOOR.getKey());
        startEquipment.add(Keys.RAFTAL_HEQDQUARTERS_KEY.getKey());
    }
    /**
     * @return the minAbilityValue
     */
    public static int getMinAbilityValue() {
        return minAbilityValue;
    }

    /**
     * @return the maxAbilityValue
     */
    public static int getMaxAbilityValue() {
        return maxAbilityValue;
    }

    /**
     * @return the startAbilityValue
     */
    public static int getStartAbilityValue() {
        return startAbilityValue;
    }

    /**
     * @return the pointsToSpend
     */
    public static int getPointsToSpend() {
        return pointsToSpend;
    }

    /**
     * @return the startPosition
     */
    public static int[] getStartCoordinates() {
        return startPosition;
    }
   
}
