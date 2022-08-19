/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Abstract class from which is inherited by every other class of inherited
 * objects of entities interacting with the world in "intelligent" way
 *
 * @author Ronald
 */
public abstract class GameCharacter implements DestroyableObject, ObjectWithInventory, Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3241662368403617634L;

	/**
     * Maximum amount of hitpoints of the character
     */
    protected int maxHitpoints;

    /**
     * Current hitpoints of the character, drop below zero means death
     */
    protected int curHitpoints;

    /**
     * Currently equiped weapon, only equiped weapon can be used for attack 
     */
    protected Weapon equippedWeapon;
    /**
     * Character's strength, see description in enum DefinedAbility
     */
    protected Ability strength;

    /**
     * Character's finesse, see description in enum DefinedAbility
     */
    protected Ability finesse;

    /**
     * Character's endurance, see description in enum DefinedAbility
     */
    protected Ability endurance;

    /**
     * Character's intelligence, see description in enum DefinedAbility
     */
    protected Ability intelligence;

    /**
     * Character's charisma, see description in enum DefinedAbility
     */
    protected Ability charisma;

    /**
     * Character's inventory
     */
    protected Inventory inventory;

    /**
     * Description of character
     */
    protected String description;

    /**
     * Characters current location on level map, value[0] is coordinate x and
     * value [1] is coordinate y
     */
    protected int[] coordinates;

    /**
     * Characters Gender
     */
    protected Gender gender;
    /**
     * Create unique id for every character! There would be high probability of
     * unexpected behavior if you did otherwise.
     */
    protected final String id;

    /**
     * Character's name
     */
    protected String name;

    /**
     * constructor for GameCharacter
     * @param name
     * @param inventory
     * @param strength
     * @param maxHitpoints
     * @param curHitpoints
     * @param finesse
     * @param endurance
     * @param intelligence
     * @param charisma
     * @param description
     * @param coordinates
     * @param gender
     * @param id
     */
    public GameCharacter(String name, String description, Gender gender, 
            int maxHitpoints, int curHitpoints,int strength, int finesse, int endurance, int intelligence, 
            int charisma, Inventory inventory, String id, int[] coordinates) {
        this.strength = new Ability(DefinedAbility.STRENGTH, strength);
        this.finesse = new Ability(DefinedAbility.FINESSE, finesse);
        this.endurance = new Ability(DefinedAbility.ENDURANCE, endurance);
        this.intelligence = new Ability(DefinedAbility.INTELLIGENCE, intelligence);
        this.charisma = new Ability(DefinedAbility.CHARISMA, charisma);
        this.description = description;
        this.coordinates = coordinates;
        this.inventory = inventory;
        this.gender = gender;
        this.id = id;
        this.name = name;
        this.maxHitpoints = maxHitpoints;
        this.curHitpoints = curHitpoints;
    }
    
    /**
     *
     * @param obj
     * @return attack message
     */
    public abstract String attack(DestroyableObject obj);

    /**
     *
     * @param damage
     * @return message about taken damage
     */
    @Override
    public abstract String takeDamage(int damage);
        
    /**
     * Add's Item to characters Inventory, if he has place for it
     * @param item
     */
    @Override
    public void addToInventory(Item item) {
        if (getInventory().size() >= getInventory().getCapacity() || getInventory().getInventoryWeight() + item.getWeight() >= getInventory().getWeightCapacity()) {
            System.out.println("Inventory is currently full, please drop something.");
            return;
        }
        getInventory().add(item);
    }
    
    public boolean hasWeapons() {
        ArrayList<Item> weapons = GameCore.getSpecificObjectsFromInventory(this, ObjectType.MELEEWEAPON);
        if (weapons == null || weapons.isEmpty()) {
            return false;
        }
        else {
        	return true;
        }
    }
    
    /**
     * Equips (usually) NPC character with strongest weapon from inventory,
     * decided by sum of minimum and maximum damage of the weapon
     * @return false if unsuccessful equiping(NPC doesn't have any weapon?)
     */
    
    public boolean equipStrongestWeapon() {
        ArrayList<Item> weapons = GameCore.getSpecificObjectsFromInventory(this, ObjectType.MELEEWEAPON);
        if (weapons == null || weapons.isEmpty()) {
            return false;
        }
        int prevStrength = 0;
        Weapon selectedWeapon = null;
        for (Item o : weapons) {
            Weapon weapon = (Weapon) o;
            int strength = weapon.getMinDamage() + weapon.getMaxDamage();
            if (strength > prevStrength) {
                selectedWeapon = weapon;
                prevStrength = strength;
            }
        }
        if (selectedWeapon == null) {
            return false;
        }
        this.equipWeapon(selectedWeapon);
        return true;
    }

    /**
     * removes Item from character's inventory to his actual LevelPoint
     * @param item
     * @return
     */
    @Override
    public Item removeFromInventory(Item item) {
        Item ret = getInventory().drop(item);
        return ret;
    }

    /**
     * tba
     * @return
     */
    public String communicate() {
        return "";
    }

    /**
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the strength
     */
    public int getStrength() {
        return strength.getValue();
    }

    /**
     * @param strength the strength to set
     */
    public void setStrength(Ability strength) {
        this.strength = strength;
    }

    /**
     * @return the finesse
     */
    public int getFinesse() {
        return finesse.getValue();
    }

    /**
     * @param finesse the finesse to set
     */
    public void setFinesse(Ability finesse) {
        this.finesse = finesse;
    }

    /**
     * @return the endurance
     */
    public int getEndurance() {
        return endurance.getValue();
    }

    /**
     * @param endurance the endurance to set
     */
    public void setEndurance(Ability endurance) {
        this.endurance = endurance;
    }

    /**
     * @return the intelligence
     */
    public int getIntelligence() {
        return intelligence.getValue();
    }

    /**
     * @param intelligence the intelligence to set
     */
    public void setIntelligence(Ability intelligence) {
        this.intelligence = intelligence;
    }

    /**
     * @return the charisma
     */
    public int getCharisma() {
        return charisma.getValue();
    }

    /**
     * @param charisma the charisma to set
     */
    public void setCharisma(Ability charisma) {
        this.charisma = charisma;
    }

    /**
     * @return the coordinates
     */
    public int[] getCoordinates() {
        return coordinates;
    }

    /**
     * character equipes selected weapon, so he can attack with it
     * @param weapon
     */
    public void equipWeapon(Weapon weapon) {
        equippedWeapon = weapon;
    }

    /**
     * @param coordinates the coordinates to set
     */
    public void setCoordinates(int[] coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * @return the inventory
     */
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the equippedWeapon
     */
    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    /**
     * @return the maxHitpoints
     */
    public int getMaxHitpoints() {
        return maxHitpoints;
    }

    /**
     * @return the curHitpoints
     */
    public int getCurHitpoints() {
        return curHitpoints;
    }

    /**
     * @return the gender
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

}
