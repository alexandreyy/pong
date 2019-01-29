package br.org.eldorado.pongspring.controllers;

import br.org.eldorado.pongspring.models.BallModel;
import br.org.eldorado.pongspring.models.CampModel;
import br.org.eldorado.pongspring.models.PlayerModel;
import br.org.eldorado.pongspring.models.GameModel;
import br.org.eldorado.pongspring.views.BallView;
import br.org.eldorado.pongspring.views.GamePanelView;
import br.org.eldorado.pongspring.views.PlayerView;
import br.org.eldorado.pongspring.views.GameFrameView;
import br.org.eldorado.pongspring.views.ScoreView;

public class GameController implements Runnable {
	// Models
	private PlayerModel player1;
	private PlayerModel player2;
	private BallModel ball;
	private CampModel camp;
	private GameModel game;

	// Views
	private PlayerView playerView1;
	private PlayerView playerView2;
	private BallView ballView;
	private ScoreView scoreView1;
	private ScoreView scoreView2;
	private GamePanelView gamePanel;
	private GameFrameView gameFrame;

	// Controllers
	private KeyboardController keyboardController;

	public GameController() {
		int widthPlayer = 15;
		int heightPlayer = 40;
		int speedPlayer = 10;

		camp = new CampModel(640, 480);
		player1 = new PlayerModel("Player 1", 15, camp.getHeight() / 2
				- heightPlayer / 2, widthPlayer, heightPlayer, speedPlayer);
		player2 = new PlayerModel("Player 2", camp.getWidth() - widthPlayer
				- 21, camp.getHeight() / 2 - heightPlayer / 2, widthPlayer,
				heightPlayer, speedPlayer);
		ball = new BallModel(8, camp.getWidth() / 2, camp.getHeight() / 2,
				BallModel.MOVINGRIGHT, BallModel.MOVINGDOWN, 8);
		game = new GameModel(player1, player2, 1);

		playerView1 = new PlayerView(player1);
		playerView2 = new PlayerView(player2);
		ballView = new BallView(ball);
		scoreView1 = new ScoreView(player1, 10, 20);
		scoreView2 = new ScoreView(player2, 10, 40);
		gamePanel = new GamePanelView(playerView1, playerView2, ballView,
				scoreView1, scoreView2);

		keyboardController = new KeyboardController(player1, player2);

		gameFrame = new GameFrameView("Pong Spring", 300, 200, camp.getWidth(),
				camp.getHeight(), gamePanel, keyboardController);

		executeThread();
	}

	public void executeThread() {
		Thread thread;
		thread = new Thread(this);
		thread.start();
	}

	public void run() {

		while (true) {
			if (! game.isOver()) {

				ball.move(player1, player2, camp);
				player1.updatePosition(camp);
				player2.updatePosition(camp);

				if (ball.getPositionX() >= (camp.getWidth() - ball.getRadius() - 6))
					player1.incrementScore();

				if (ball.getPositionX() == 0)
					player2.incrementScore();
			}
		
			gamePanel.redraw();
			sleep();
		}
	}

	public void sleep() {
		try {
			Thread.sleep(50);
		} catch (InterruptedException ex) {
			System.out.println(ex);
		}
	}

	public static void main(String[] args) {
		new GameController();
	}
}
