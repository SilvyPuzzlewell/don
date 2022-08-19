/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package don_aman;

import core.Key;

/**
 *
 * @author Ronald
 */
public enum Keys {

    MADS_DOOR(new Key("Mad's key", "Key to stuff in Mad's House, he uses one"
            + " for everything", 0.1, false, AvailableKeyAttachments.MADS_DOOR)),
    RAFTAL_HEQDQUARTERS_KEY(new Key("Raftal Headquarters key","Your key to"
            + " raftal's stuff inc. headquarters it's shaped in like the "
            + "mysterious raftal's eye", 0.1, false, AvailableKeyAttachments.
            RAFTALS_HEADQUARTERS));
    private final Key key;
    
    private Keys(Key key) {
        this.key = key;
    }

    /**
     * @return the key
     */
    public Key getKey() {
        return key;
    }
}
