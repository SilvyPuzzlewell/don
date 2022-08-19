/*;
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import don_aman.CommonWeapons;
import don_aman.CreateCharacterData;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Storing and computational model for character creation screen
 * @author Ronald
 */
public class CreateMainCharacterModel {

    private Level level;
    private final int startAbilityValue;
    private final int minAbilityValue;
    private final int maxAbilityValue;
    private final int[] startCoordinates;
    private int pointsToSpend;
    private static int strength;
    private static int finesse;
    private static int endurance;
    private static int intelligence;
    private static int charisma;
    private final Gender gender;
    private MainCharacter mainCharacter;
    private ArrayList<Item> startEquipment;



    /**
     *
     * @return strength value
     */
    public int getStrength() {
        return strength;
    }

    /**
     *
     * @return finesse value
     */
    public int getFinesse() {
        return finesse;
    }

    /**
     *
     * @return  endurance value
     */
    public int getEndurance() {
        return endurance;
    }

    /**
     *
     * @return intelligence value
     */
    public int getIntelligence(){ 
        return intelligence;
    }

    /**
     *
     * @return charisma value
     */
    public int getCharisma() {
        return charisma;
    }

    /**
     * Constructor for the model, it all important data from class CreateCharacterData,
     * which is located in package outside of the game core package, create it with same
     * name in your own interpretation r use the one in don_aman package 
     */
    public CreateMainCharacterModel() {
        CreateCharacterData cd = new CreateCharacterData();

        startAbilityValue = CreateCharacterData.getStartAbilityValue();
        pointsToSpend = CreateCharacterData.getPointsToSpend();
        minAbilityValue = CreateCharacterData.getMinAbilityValue();
        maxAbilityValue = CreateCharacterData.getMaxAbilityValue();
        startEquipment = CreateCharacterData.getStartEquipment();
        startCoordinates = CreateCharacterData.getStartCoordinates();
        gender = CreateCharacterData.getGender();
        strength = startAbilityValue;
        finesse = startAbilityValue;
        endurance = startAbilityValue;
        intelligence = startAbilityValue;
        charisma = startAbilityValue;
    }

    /**
     * recommended to call when finishing work with character creation GUI, this returns the 
     * character with chosen values
     * @return 
     */
    public MainCharacter returnCharacter() {
      

        Inventory inventory = new Inventory(20, strength * 4);
        for (Item item : startEquipment) {
            inventory.add(item);
        }
        return new MainCharacter(CreateCharacterData.getName(),CreateCharacterData.getDescription(),
                CreateCharacterData.getGender(),strength, finesse, endurance, intelligence,
                charisma,inventory, CreateCharacterData.getStartCoordinates(),CreateCharacterData.getId());
    }

    /**
     * increments value of selected ability
     * @param ability
     */
    public void incrementPoints(DefinedAbility ability) {
        if (pointsToSpend <= 0) {
            return;
        }
        switch (ability) {
            case STRENGTH:
                if (strength < maxAbilityValue) {
                    strength++;
                } else {
                    return;
                }
                break;
            case FINESSE:
                if (finesse < maxAbilityValue) {
                    finesse++;
                } else {
                    return;
                }
                break;
            case ENDURANCE:
                if (endurance < maxAbilityValue) {
                    endurance++;
                } else {
                    return;
                }
                break;
            case INTELLIGENCE:
                if (intelligence < maxAbilityValue) {
                    intelligence++;
                } else {
                    return;
                }
                break;
            case CHARISMA:
                if (charisma < maxAbilityValue) {
                    charisma++;
                } else {
                    return;
                }
                break;
        }
        pointsToSpend--;
    }

    /**
     * decrements value of selected ability
     * @param ability
     */
    public void decrementPoints(DefinedAbility ability) {
        switch (ability) {
            case STRENGTH:
                if (strength > minAbilityValue) {
                    strength--;
                } else {
                    return;
                }
                break;
            case FINESSE:
                if (finesse > minAbilityValue) {
                    finesse--;
                } else {
                    return;
                }
                break;
            case ENDURANCE:
                if (endurance > minAbilityValue) {
                    endurance--;
                } else {
                    return;
                }
                break;
            case INTELLIGENCE:
                if (intelligence > minAbilityValue) {
                    intelligence--;
                } else {
                    return;
                }
                break;
            case CHARISMA:
                if (charisma > minAbilityValue) {
                    charisma--;
                } else {
                    return;
                }
                break;
        }
        pointsToSpend++;
    }

    /**
     *
     * @return available points to use for incrementing abilities
     */
    public int getPointCounter() {
        return pointsToSpend;
    }

    /**
     *
     * @return
     */
    public int getStartingCharacteristics() {
        return startAbilityValue;
    }

}
