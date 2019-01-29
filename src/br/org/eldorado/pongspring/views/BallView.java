package br.org.eldorado.pongspring.views;

import java.awt.Color;
import java.awt.Graphics;

import br.org.eldorado.pongspring.models.BallModel;

public class BallView implements ComponentView {

	private BallModel ballModel;

	public BallView(BallModel ballModel) {
		this.ballModel = ballModel;
	}

	public void draw(Graphics gc) {
		gc.setColor(Color.black);
		gc.fillOval(ballModel.getPositionX(), ballModel.getPositionY(), 8, 8);
	}
}
