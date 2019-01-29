package br.org.eldorado.pongspring.models;

public class GameModel {
	private int gameOverScore;
	private PlayerModel player1;
	private PlayerModel player2;

	public GameModel(PlayerModel player1, PlayerModel player2,
			int gameOverScore) {
		this.gameOverScore = gameOverScore;
		this.player1 = player1;
		this.player2 = player2;
	}

	public boolean isOver() {
		if (player1.getScore() == gameOverScore) {
			player1.setWinner();
			return true;
		} else if (player2.getScore() == gameOverScore) {
			player2.setWinner();
			return true;
		} else {
			return false;
		}
	}
}
