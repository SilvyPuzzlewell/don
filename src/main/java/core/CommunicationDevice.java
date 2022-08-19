/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Ronald
 */
public class CommunicationDevice extends Item implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -1808475497081283157L;
	private ArrayList<Contact> DeviceContacts = new ArrayList<>();
    private String deviceID;
    private  ObjectType itemType;
    private double weight;

    /**
     *
     * @param name
     * @param description
     * @param weight
     * @param deviceID
     * @param takable
     */
    public CommunicationDevice(String name, String description, double weight, String deviceID,boolean takable) {
        super(name, description, weight, takable);
        this.deviceID = deviceID; 
        this.itemType = ObjectType.COMDEVICE;
        this.weight = weight;
    }
    
    /**
     *
     * @param ID
     */
    public void makeCall(String ID){
    if(Contacts.contactsMap.containsKey(ID)){
        
    }    
}
}
