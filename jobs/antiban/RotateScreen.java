package innovationAlcher.jobs.antiban;

import innovationAlcher.container.Variables;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.util.Random;

public class RotateScreen extends Node {

	@Override
	public void execute() {
		Camera.setAngle(Random.nextInt(300, 700));
		Variables.activateRotateScreen = false;
	}
	
	@Override
	public boolean activate() {
		return Variables.activateRotateScreen;
	}

	
}
