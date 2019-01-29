package br.org.eldorado.pongspring.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import br.org.eldorado.pongspring.models.PlayerModel;

public class ScoreView implements ComponentView {

	private PlayerModel player;
	private int positionX;
	private int positionY;
	private Font font;

	public ScoreView(PlayerModel player, int positionX, int positionY) {
		this.player = player;
		this.positionX = positionX;
		this.positionY = positionY;
		this.font = new Font("Dialog", Font.PLAIN, 16);
	}

	public void draw(Graphics gc) {
		gc.setColor(Color.black);
		gc.setFont(font);

		if (player.isWinner()) {
			gc.drawString(player.getName() + ": " + player.getScore() + " - Venceu! ",
					positionX, positionY);
		} else {
			gc.drawString(player.getName() + ": " + player.getScore(),
					positionX, positionY);
		}
	}
}
