package br.org.eldorado.pongspring.views;

import java.awt.Color;
import java.awt.Graphics;

import br.org.eldorado.pongspring.models.PlayerModel;

public class PlayerView implements ComponentView {

	private PlayerModel playerModel;

	public PlayerView (PlayerModel playerModel) {
		this.playerModel = playerModel;
	}

	public void draw(Graphics gc) {
		gc.setColor(Color.BLUE);
		gc.fillRect(playerModel.getPositionX(), playerModel.getPositionY(),
				playerModel.getWidth(), playerModel.getHeight());
	}
}
