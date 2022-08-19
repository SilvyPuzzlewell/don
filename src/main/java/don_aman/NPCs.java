/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package don_aman;

import core.AI_Dumb;
import core.CommunicationDevice;
import core.Friendliness;
import core.Gender;
import core.Inventory;
import core.NPC;
import java.io.*;
import java.util.logging.Logger;

/**
 *
 * @author Ronald
 */
public class NPCs implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8552177611492767077L;
	private static final Logger LOG = Logger.getLogger(NPCs.class.getName());
    private static boolean MadTwatterInstanced;
    private static boolean KajaSulinInstanced;
    private String warningMoreInstances;

    public NPCs() {
        KajaSulinInstanced = false;
        MadTwatterInstanced = false;
        warningMoreInstances = "Trying to make instance of already instanced NPC; NPCs"
                + " class is meant to provide only one unique instance of NPC";
    }

    public NPC getMAD_TWATTER() {
        if (MadTwatterInstanced == true) {
            LOG.warning(warningMoreInstances);
            return null;
        }
        Inventory madsInventory = new Inventory(20, 100);
        madsInventory.add(CommonWeapons.DAGGER.getWeapon());
        madsInventory.add(CommonWeapons.WEIRD_ENERGETIC_THING.getWeapon());
        CommunicationDevice madsPhone = new CommunicationDevice("Mad's Phone", "Mad Twatter's mobile phone, some old Nokia", 0.15, "789631425", true);
        madsInventory.add(madsPhone);
        NPC mad = new NPC("Mad Twatter", "You owe him"
                + " money for the weed, he is going to cut your balls off!", Gender.MALE, 100, 100,
                Friendliness.HOSTILE, 14, 14, 12, 11, 9, madsInventory, null, null, "MAD_TWATTER");
        mad.setAIinterface(new AI_Dumb(mad));
        return mad;
    }

    public NPC gatMADS_BUTLER() {
        Inventory madsInventory = new Inventory(20, 100);
        madsInventory.add(CommonWeapons.DAGGER.getWeapon());
        NPC madsbutler = new NPC("Mad's Butler", " , angry looking dwarf ", Gender.MALE, 100, 100,
                Friendliness.HOSTILE, 14, 14, 12, 11, 9, madsInventory, null, null, "MAD_TWATTER");
        madsbutler.setAIinterface(new AI_Dumb(madsbutler));
        return madsbutler;
    }

    public NPC getKAJA_SULIN() {
        if (KajaSulinInstanced == true) {
            LOG.warning(warningMoreInstances);
            return null;
        }
        KajaSulinInstanced = true;
        NPC Kaja = new NPC("Kaja Sulin", "Don's best friend and the"
                + " founder of Raftal's stuff, the three member organization, which "
                + "raison d'etre is investigation of all the weird shit that started "
                + "happening after Pilsen tower appeared", Gender.MALE, 80, 80, Friendliness.ALLIED,
                13, 13, 12, 14, 14, null, null, null, "KAJA_SULIN");
        return Kaja;
    }
}
