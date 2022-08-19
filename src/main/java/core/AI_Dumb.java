/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * most basic artificial intelligence class usable specially for
 * monsters(defaultly hostila npcs)
 * 
 * @author Ronald
 */
public class AI_Dumb implements Callable, AIinterface, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4529947306772458574L;
	private static final Logger LOG = Logger.getLogger(AI_Dumb.class.getName());
	private MainGame mainGame;
	private Random rand;
	private int prevDirection;
	private NPC npc;
	private boolean inCombat;
	boolean closed;

	/**
	 * 
	 * @param npc sets attachment with NPC
	 */
	public AI_Dumb(NPC npc) {
		this.npc = npc;
		mainGame = new MainGame(npc);
		closed = false;
		inCombat = false;
	}

	private void move() {
		if (closed) {
			return;
		}
		int movement = mainGame.NPCmove(prevDirection);
		if (movement == 2) {
			return;
		} else {
			prevDirection = chooseDirection();
		}
	}

	private int chooseDirection() {
		int movement;
		int direction;
		int loopCounter = 0;// if loopcounter is larger than 1000, character decides that there is no way to
							// move, so he/she/it just stands
		rand = new Random();
		do {
			direction = rand.nextInt(3) + 1;
			movement = mainGame.NPCmove(direction);
			loopCounter++;
		} while (movement != 2 || loopCounter == 1000);
		if (loopCounter == 1000) {
			closed = true;
		}
		return direction;
	}

	private boolean isAtSamePointAsMainCharacter() {
		return Arrays.equals(npc.getCoordinates(), GameCore.getMainCharacter().getCoordinates());
	}

	private boolean equipWeapon() {
		return npc.equipStrongestWeapon();
	}

	// these are not really part of the ai and should be moved somewhere else
	private String createRunMessage() {
		return npc.getDescription() + " is running away!\n";
	}

	private String createEquipMessage() {
		return npc.getDescription() + " equipped " + npc.getEquippedWeapon().getDescription();
	}

	private String createPeaceMessage() {
		return "You just encountered " + npc.getDescription() + " who seems to mean no harm to you\n";
	}
	
	private String createAttackMessage() {
		return npc.getDescription() + " attacks you!\n";
	}

	private void initiateCombat() {
		GameCore.addFightingNPC(npc);
		inCombat = true;
	}

	/**
	 * initiates callable thread, NPC moves in fixed direction, if it become
	 * blocked, it randomly changes direction until it founds passable one, if
	 * hostile, equips strongest weapon in it's inventory and attacks you, if it
	 * doesn't have a weapon, it runs away. It does one action a round
	 * 
	 * @return iformation about action
	 * @throws Exception
	 */
	@Override
	public String call() throws Exception {
		String retMessage = null;

		// check before npc moves, if the character got into the npc's point or if they
		// are already fighting
		if (isAtSamePointAsMainCharacter()) {
			if (npc.getFriendliness() == Friendliness.HOSTILE) {
				// in this case the player character went into npc's point
				if (!inCombat) {
					if (npc.getEquippedWeapon() == null && npc.hasWeapons()) {
						equipWeapon();
						initiateCombat();
						retMessage = createEquipMessage();
					} else {
						move();
						retMessage = createRunMessage();
					}

				} else {
					if (npc.getEquippedWeapon() == null) {
						equipWeapon();
						retMessage = createEquipMessage();
					} else {
						retMessage = mainGame.attack();
					}
				}
			} else {
				retMessage = createPeaceMessage();
			}

		} else {
			move();
			if (isAtSamePointAsMainCharacter() && npc.hasWeapons()) {
				initiateCombat();
				retMessage = createAttackMessage();
			}
			LOG.log(Level.INFO, "{0} is now at point {1}{2}", new Object[] { npc.getName(),
					GameCore.getCoordinateIndex1(npc), GameCore.getCoordinateIndex2(npc) });
		}

		return retMessage;
	}
}
