package innovationAlcher.container;

import org.powerbot.game.api.util.Random;

public class Methods {

	public static final void debug(String text) {
		if (Variables.debug) {
			System.out.println("[InnovationAlcher]: " + text);
		}
	}
	
	public static void antiban() {
		int randNum = Random.nextInt(0, 700);
		int randNum2 = Random.nextInt(0, 3);
		
		debug("Random number 1: " + randNum + "; Random number 2: " + randNum2);
		
		if (randNum >= 325 && randNum <= 350) {
			if (randNum2 == 0 && Variables.rotateScreen) {
				Variables.activateRotateScreen = true;
				Methods.debug("antiban: rotating screen.");
			} else if (randNum2 == 1 && Variables.hoverOverSkill) {
				Variables.activateHoverOverSkill = true;
				Methods.debug("antiban: checking magic skill xp.");
			} else if (randNum2 == 2 && Variables.randomWait) {
				Variables.activateRandomWait = true;
				Methods.debug("antiban: Randomly waiting a few seconds...");
			}
		}
	}
	
}
