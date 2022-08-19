/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package don_aman;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 *
 * @author Ronald
 */
public class DialogueScript {

    private String characterName;

    public void runDialogue(String characterName) {
        try {
            FileReader dialogueReader = new FileReader(characterName + ".txt");
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
