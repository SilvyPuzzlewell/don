/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.io.Serializable;

/**
 * DefinedAbility is structure holding characters main characteristics
 * @author Ronald
 */
public enum DefinedAbility implements Serializable {
   
    /**
     *
     */
    STRENGTH("Strength is your character's physical power, it determines the"
            + " power of your melee attacks, how much weight you can carry.. "),

    /**
     *
     */
    FINESSE("Finesse is your character's ability to do precise work, it"
            + " influences variable amount of skills ranging from silent"
            + " movement to repairing computers. "),

    /**
     *
     */
    ENDURANCE("Endurance is your character's ability to endure hard physical"
            + " and psychical burden, hitpoints and various resistances. "),

    /**
     *
     */
    INTELLIGENCE("Intelligence is your character's ability to think, it is crucial"
            + " for any intellectual activity including interactions with NPCs. Hint"
            + ": You do not want to play with retarded character!. "),

    /**
     *
     */
    CHARISMA("Charisma determines charm of your personality, it is crucial for your"
            + " ability to convince others of importance of your goals...");
    private final String description;
    private DefinedAbility(String description){
        this.description = description;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }
}
