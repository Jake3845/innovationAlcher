package innovationAlcher.jobs;


import innovationAlcher.container.Variables;
import innovationAlcher.container.Methods;

import org.powerbot.core.event.events.MessageEvent;
import org.powerbot.core.event.listeners.MessageListener;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Game;
import org.powerbot.game.api.methods.Tabs;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.tab.Skills;
import org.powerbot.game.bot.Context;

public class HighAlchemy extends Node implements MessageListener {

	@Override
	public void execute() {
		Methods.antiban();
		if (Tabs.MAGIC.isOpen()) {
			if (Variables.highAlchemySpell != null) {
				Variables.highAlchemySpell.click(true);
				sleep(500,700);
				if (Inventory.getCount(true, Variables.ALCH_ITEM) >= 1) {
					Inventory.getItem(Variables.ALCH_ITEM).getWidgetChild().click(true);
					sleep(1500,1700);
				} else {
					Context.get().getScriptHandler().stop();
				}
			}
		} else {
			Tabs.MAGIC.open();
			sleep(500,700);
		}
	}

	@Override
	public void messageReceived(MessageEvent arg0) {
		String message = arg0.getMessage().toLowerCase();
		String sender = arg0.getSender();
		if (sender.isEmpty()) {
			if (message.contains("added to your money")) {
				Variables.totalAlches++;
				Variables.totalXpGain += 65;
			} else if (message.contains("you do not have enough")) {
				Game.logout(true);
				Context.get().getScriptHandler().stop();
			}
		}
	}
	
	@Override
	public boolean activate() {
		return Skills.getLevel(6) >= 55 && Game.isLoggedIn()
				&& Variables.runScript && Variables.highAlch
				&& !Variables.activateRotateScreen
				&& !Variables.activateHoverOverSkill
				&& !Variables.activateRandomWait;
	}

}
