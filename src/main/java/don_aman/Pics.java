/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package don_aman;

import java.net.URL;

import javax.swing.ImageIcon;

/**
 * pics used in your game (paths to them)
 * MAIN_MENU and END_GAME cannot be deleted! But you can use whatever picture you desire for them.
 * @author Ronald
 */

public class Pics {
	public ImageIcon getMainMenuPic() {
		URL resource = getClass().getClassLoader().getResource("large.jpg");
		ImageIcon MAIN_MENU = new javax.swing.ImageIcon(resource);
		return MAIN_MENU;
	}

}
