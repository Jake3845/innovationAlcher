package innovationAlcher.container;

import java.awt.Image;

import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.util.Timer;
import org.powerbot.game.api.wrappers.widget.WidgetChild;

public class Variables {


	/*
	 * Misc Variables
	 */
	public static boolean debug;
	public static boolean logout;
	
	/*
	 * Paint variables
	 */
	public static final Timer RUNTIME = new Timer(0);
	public static int totalAlches = 0;
	public static int totalXpGain = 0;
	public static boolean highAlch = false;
	public final static Image chatboxCover = Paint.getImage("http://puu.sh/1mSeR");
	public final static Image konvictBadge = Paint.getImage("http://puu.sh/1mQtI");
	
	/*
	 * GUI Variables
	 */
	public static boolean runScript = false;
	
	/*
	 * Alchemy Variables
	 */
	public static final int FIRE_RUNE = 554;
	public static final int NATURE_RUNE = 561;
	public static int ALCH_ITEM = 0;
	public static final WidgetChild highAlchemySpell = Widgets.get(192, 59);
	public static final WidgetChild lowAlchemySpell = Widgets.get(192, 38);
	
	/*
	 * Antiban Variables
	 */
	public static boolean rotateScreen = false;
	public static boolean hoverOverSkill = false;
	public static boolean randomWait = false;
	public static boolean activateRotateScreen = false;
	public static boolean activateHoverOverSkill = false;
	public static boolean activateRandomWait = false;
}
