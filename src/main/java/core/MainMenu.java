/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import don_aman.CreateCharacterData;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * Class for handling Main Menu events
 * @author Ronald
 */
public class MainMenu {

    private final String startLevel = "MadsHouse.ser";
    private final String savedGame = "SaveGame.ser";

     

    //   private Core gameCore;

    /**
     * initiates new game, sets main character, loads start level
     * @param mainCharacter
     */
        public void newGame(MainCharacter mainCharacter) {
        CreateCharacterData cd = new CreateCharacterData();
        Level StartLevel = null;
        try {
            FileInputStream in = new FileInputStream(startLevel);
            ObjectInputStream In = new ObjectInputStream(in);
            StartLevel = (Level) In.readObject();
            In.close();
            in.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException i) {
            i.printStackTrace();
        }
//       gameCore = new Core(StartLevel, Don);
        GameCore.setGameCoreLevel(StartLevel);
        GameCore.setMainCharacter(mainCharacter);
        if(StartLevel.getNPCs() != null){
        GameCore.setNpcs(StartLevel.getNPCs());
        GameCore.setFightingNPC(new ArrayList<NPC>());
        }
    }
  
    /**
     *loads game from default file "SaveGame.ser"
     */
    public void loadGame(){
        Core gameCore = null;
        try {
            FileInputStream in = new FileInputStream(savedGame);
            ObjectInputStream In = new ObjectInputStream(in);
            gameCore = (Core) In.readObject();
            In.close();
            in.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException i) {
            i.printStackTrace();
        }
        GameCore.setGameCore(gameCore);
        MainGameScreen mdc = new MainGameScreen();
        mdc.setVisible(true);
    }

}
