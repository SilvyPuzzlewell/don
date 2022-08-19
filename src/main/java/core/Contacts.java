/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;


import java.util.HashMap;

/**
 *
 * @author Ronald
 */
public class Contacts {
    private static Contact KajaSulin = new Contact("745186298");    

    /**
     *
     */
    public static HashMap contactsMap = new HashMap();
    private static HashMap communicationDevicesMap = new HashMap();
    private static void setContacts(){
        contactsMap.put(KajaSulin.getID(), KajaSulin);
    }
}
