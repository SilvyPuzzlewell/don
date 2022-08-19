/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package don_aman;

import core.Weapon;
import java.io.Serializable;

/**
 * represent constant "common" weapons
 * @author Ronald
 */
public enum CommonWeapons implements Serializable {

    DAGGER(new Weapon("Dagger", "common dagger", 0.2, 3, 5, true)),
    MACHETTE(new Weapon("Machette", "common machette", 0.5, 4, 7, true)),
    LIGHTSABRE(new Weapon("Lightsabre", "common lightsabre", 0.5, 100, 200, true)),
    WEIRD_ENERGETIC_THING(new Weapon("Weird energetic thing", "something awfully"
            + " dangerously looking",1, 7, 18,false));
    private Weapon weapon;

    private CommonWeapons(Weapon weapon) {
        this.weapon = weapon;
    }

    /**
     * @return the weapon
     */
    public Weapon getWeapon() {
        return weapon;
    }
}
