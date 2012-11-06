package innovationAlcher.container;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.powerbot.game.api.methods.Tabs;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.tab.Inventory;

public class Paint  {

	
	
	public final static void drawPaint(final Graphics render) {
		
	String alchMode = (Variables.highAlch) ? "High Alchemy" : "Low Alchemy";
	String antiBanMode = (Variables.rotateScreen || Variables.hoverOverSkill || Variables.randomWait) ? "Enabled" : "Disabled";
	int alchesPerHr = (int)(Variables.totalAlches * 3600000D / Variables.RUNTIME.getElapsed());
	int xpPerHr = (int)(Variables.totalXpGain * 3600000D / Variables.RUNTIME.getElapsed());
		
	Graphics2D g = (Graphics2D) render;
	g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	g.setStroke(new BasicStroke(2.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
	g.setColor(Color.GREEN);
	g.drawLine(Mouse.getX() - 6, Mouse.getY(), Mouse.getX() + 6, Mouse.getY());
	g.drawLine(Mouse.getX(), Mouse.getY() - 6, Mouse.getX(), Mouse.getY() + 6);
		
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 12));
        g.drawImage(Variables.chatboxCover, 1, 387, null);
        g.drawImage(Variables.konvictBadge, 441, 312, null);
        g.drawString(Variables.RUNTIME.toElapsedString(), 348, 435);
        g.drawString(alchMode + ".", 325, 450);
		
	if (antiBanMode.contains("Enabled")) {
		g.setColor(Color.GREEN);
	} else {
        	g.setColor(Color.RED);
	}
		
        g.drawString(antiBanMode + ".", 309, 464);
        g.setColor(Color.WHITE);
        g.drawString(Variables.totalAlches + ".", 437, 483);
        g.drawString(Variables.totalXpGain + ".", 256, 485);
        g.drawString(alchesPerHr + ".", 437, 505);
        g.drawString(xpPerHr + ".", 257, 506);
		
	if (Tabs.INVENTORY.isOpen() && Inventory.getCount(Variables.ALCH_ITEM) != 0) {
        	g.setColor(new Color(0, 255, 0, 100));
        	g.fillRect(Inventory.getItem(Variables.ALCH_ITEM).getWidgetChild().getAbsoluteX(), Inventory.getItem(Variables.ALCH_ITEM).getWidgetChild().getAbsoluteY(), Inventory.getItem(Variables.ALCH_ITEM).getWidgetChild().getWidth(), Inventory.getItem(Variables.ALCH_ITEM).getWidgetChild().getHeight());
	}
       if (Tabs.MAGIC.isOpen()) {
        	if (!Variables.highAlch && Variables.lowAlchemySpell != null) {
        		g.setColor(new Color(0,255,0,100));
        		g.fillRect(Variables.lowAlchemySpell.getAbsoluteX(), Variables.lowAlchemySpell.getAbsoluteY(), Variables.lowAlchemySpell.getWidth(), Variables.lowAlchemySpell.getHeight());
        	} else if (Variables.highAlch && Variables.highAlchemySpell != null) {
        		g.setColor(new Color(0,255,0,100));
        		g.fillRect(Variables.highAlchemySpell.getAbsoluteX(), Variables.highAlchemySpell.getAbsoluteY(), Variables.highAlchemySpell.getWidth(), Variables.highAlchemySpell.getHeight());
        	}
       }
	}
		
    public static Image getImage(String url) {
        try {
            return ImageIO.read(new URL(url));
        } catch(IOException e) {
            return null;
        }
    }

}
