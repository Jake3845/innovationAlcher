package innovationAlcher.jobs.antiban;

import innovationAlcher.container.Variables;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Tabs;
import org.powerbot.game.api.methods.Widgets;

public class CheckMagicXP extends Node {
	
	@Override
	public void execute() {
		if (Tabs.STATS.isOpen()) {
			Widgets.get(320, 66).hover();
			sleep(1500,3000);
			Variables.activateHoverOverSkill = false;
		} else {
			Tabs.STATS.open();
			sleep(500,700);
		}
	}
	
	@Override
	public boolean activate() {
		return Variables.activateHoverOverSkill;
	}


}
