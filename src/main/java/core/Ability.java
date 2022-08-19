/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.io.Serializable;

/**
 *
 * @author Ronald
 */
public class Ability implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7714364739979053580L;
	private final DefinedAbility ability;
    private int value;

    /**
     *
     * @param ability
     * @param value
     */
    public Ability(DefinedAbility ability, int value){
       this.ability = ability;
       this.value = value;
   } 

    /**
     *
     * @return
     */
    public DefinedAbility getAbility() {
        return ability;
    }


    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(int value) {
        this.value = value;
    }
}
