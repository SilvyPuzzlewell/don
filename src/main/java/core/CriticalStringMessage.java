/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

/**
 * Store of important String messages
 * @author Ronald
 */
public enum CriticalStringMessage {

    /**
     * Message sent to determine the death of your character
     */
    MAIN_CHARACTER_KILLED("Critical failure - you have been killed");
    private final String message;
    private CriticalStringMessage(String message){
        this.message = message;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }
}
