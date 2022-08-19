/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

/**
 *
 * @author Ronald
 */
public class InventoryScreenModel {

    public String getEquippedWeaponText() {
        if(GameCore.getMainCharacter().getEquippedWeapon() == null){
            return ("");
        }
        return("Equipped weapon: " + GameCore.getMainCharacter().getEquippedWeapon().getName());
    }
    public String getEquippedWeaponDAmage(){
        if(GameCore.getMainCharacter().getEquippedWeapon() == null){
            return ("");
        }
        return("Min damage: " + GameCore.getMainCharacter().getEquippedWeapon().getMinDamage()
                + "Max damage: " + GameCore.getMainCharacter().getEquippedWeapon().getMaxDamage());
    }
    public String initText(int index) {
        if (GameCore.getYourInventory().size() > index && GameCore.getYourInventory().get(index) != null) {
            return (GameCore.getYourInventory().get(index).getName());
        } else {
            return ("empty");
        }
    }
}
//    public String getDescription()
//    }
//}
