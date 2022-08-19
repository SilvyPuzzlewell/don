/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package level_editor;
import core.Level;
import java.io.*;
/**
 *
 * @author Ronald
 */
public class SaveLevel {
    public static void main(String[] args){
        LevelEditor level = new LevelEditor();
        Level MadsHouse = level.MadsHouse;
        try{
            FileOutputStream out = new FileOutputStream("MadsHouse.ser");
            ObjectOutputStream Out = new ObjectOutputStream(out);
            Out.writeObject(MadsHouse);
            Out.close();
            out.close();
            System.out.print("Success!");
        } catch(IOException i){
            i.printStackTrace();
        }
    }
}
