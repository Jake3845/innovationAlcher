package innovationAlcher;


import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.powerbot.core.event.listeners.PaintListener;
import org.powerbot.core.script.ActiveScript;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.core.script.job.state.Tree;
import org.powerbot.game.api.Manifest;
import org.powerbot.game.api.util.Random;

import innovationAlcher.container.Paint;
import innovationAlcher.container.Variables;
import innovationAlcher.gui.Gui;
import innovationAlcher.jobs.HighAlchemy;
import innovationAlcher.jobs.LowAlchemy;
import innovationAlcher.jobs.antiban.CheckMagicXP;
import innovationAlcher.jobs.antiban.RandomWait;
import innovationAlcher.jobs.antiban.RotateScreen;

@Manifest(authors = { "Justin" }, name = "InnovationAlcher", description = "The simple task of alching has never been so Perfect: 3 Antibans, flawless alching, and a clean, descriptive paint.", website = "http://www.powerbot.org/community/")
public class InnovationAlcher extends ActiveScript implements PaintListener {

	private final List<Node> jobsCollection = Collections.synchronizedList(new ArrayList<Node>());
	private Tree jobContainer = null;

	public final void provide(final Node... jobs) {
		for (final Node job : jobs) {
			jobsCollection.add(job);
		}
		jobContainer = new Tree(jobsCollection.toArray(new Node[jobsCollection.size()]));
	}

	@Override
	public void onStart() {
		Gui.main(null);
		provide(new LowAlchemy());
		provide(new HighAlchemy());
		provide(new RotateScreen());
		provide(new CheckMagicXP());
		provide(new RandomWait());
		
	}
	
	@Override
	public void onStop() {
		System.out.println("Total alches: " + Variables.totalAlches + "; total XP gain: " + Variables.totalXpGain + "; Time: " + Variables.RUNTIME.toElapsedString() + "!");
	}

	@Override
	public int loop() {
		if (jobContainer != null) {
			final Node job = jobContainer.state();
			if (job != null) {
				jobContainer.set(job);
				getContainer().submit(job);
				job.join();
			}
		}
		return Random.nextInt(10, 50);
	}

	@Override
	public void onRepaint(Graphics render) {
		Paint.drawPaint(render);
	}

}
