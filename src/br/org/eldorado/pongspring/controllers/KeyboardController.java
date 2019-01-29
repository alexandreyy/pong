package br.org.eldorado.pongspring.controllers;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import br.org.eldorado.pongspring.models.PlayerModel;

public class KeyboardController extends KeyAdapter {

	private PlayerModel player1;
	private PlayerModel player2;

	public KeyboardController(PlayerModel player1, PlayerModel player2) {
		this.player1 = player1;
		this.player2 = player2;
	}

	public void keyPressed(KeyEvent evt) {
		switch (evt.getKeyCode()) {

		case KeyEvent.VK_W:
			player1.setMovementDirection(PlayerModel.MOVINGUP);
			break;
		case KeyEvent.VK_S:
			player1.setMovementDirection(PlayerModel.MOVINGDOWN);
			break;
		case KeyEvent.VK_UP:
			player2.setMovementDirection(PlayerModel.MOVINGUP);
			break;
		case KeyEvent.VK_DOWN:
			player2.setMovementDirection(PlayerModel.MOVINGDOWN);
			break;
		}
	}

	public void keyReleased(KeyEvent evt) {
		switch (evt.getKeyCode()) {
		case KeyEvent.VK_W:
		case KeyEvent.VK_S:
			player1.stop();
			break;

		case KeyEvent.VK_UP:
		case KeyEvent.VK_DOWN:
			player2.stop();
			break;
		}
	}

}