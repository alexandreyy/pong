package br.org.eldorado.pongspring.views;

import java.awt.BorderLayout;
import java.awt.Graphics;
import javax.swing.JPanel;

public class GamePanelView extends JPanel {
	private static final long serialVersionUID = 1L;
	private PlayerView playerView1;
	private PlayerView playerView2;
	private BallView ballView;
	private ScoreView scoreView1;
	private ScoreView scoreView2;

	public GamePanelView(PlayerView playerView1, PlayerView playerView2,
			BallView ballView, ScoreView scoreView1, ScoreView scoreView2) {
		super();
		this.setLayout(new BorderLayout());
		this.playerView1 = playerView1;
		this.playerView2 = playerView2;
		this.ballView = ballView;
		this.scoreView1 = scoreView1;
		this.scoreView2 = scoreView2;
	}

	public void paintComponent(Graphics gc) {
		setOpaque(false);
		super.paintComponent(gc);

		playerView1.draw(gc);
		playerView2.draw(gc);
		ballView.draw(gc);
		scoreView1.draw(gc);
		scoreView2.draw(gc);
	}

	public void redraw() {
		repaint();
	}
}