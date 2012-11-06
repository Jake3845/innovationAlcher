package innovationAlcher.jobs.antiban;

import innovationAlcher.container.Variables;

import org.powerbot.core.script.job.state.Node;

public class RandomWait extends Node {
	
	@Override
	public void execute() {
		sleep(5000,30000);
		Variables.activateRandomWait = false;
	}
	
	@Override
	public boolean activate() {
		return Variables.activateRandomWait;
	}

}
