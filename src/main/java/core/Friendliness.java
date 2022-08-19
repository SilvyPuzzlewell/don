/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.io.Serializable;

/**
 * Structure holding identidfiers of determination how others perceive main character
 * @author Ronald
 */
public enum Friendliness implements Serializable {

    /**
     * Character is ally in main characters cause, though that shouldn't generally mean he will
     * do anything he wants
     */
    ALLIED,

    /**
     * Character likes main character
     */
    FRIENDLY,

    /**
     * Character doesn't care about the main character
     */
    NEUTRAL,

    /**
     * Character doesn't like the main character, is unwilling to cooperate with him
     */
    DISLIKING,

    /**
     * Main character's enemy, given the chance, he/she/it attacks
     */
    HOSTILE
};
