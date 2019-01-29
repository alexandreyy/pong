package br.org.eldorado.pongspring.models;

public class BallModel {
	private int positionX;
	private int positionY;
	private int statusX;
	private int statusY;
	private int radius;
	private int speed;
	public static final int MOVINGUP = 1;
	public static final int MOVINGDOWN = 2;
	public static final int MOVINGLEFT = 1;
	public static final int MOVINGRIGHT = 2;

	public BallModel(int radius, int positionX, int positionY, int statusX,
			int statusY, int speed) {
		this.radius = radius;
		this.positionX = positionX;
		this.positionY = positionY;
		this.statusX = statusX;
		this.statusY = statusY;
		this.statusY = statusY;
		this.speed = speed;
	}

	public int getPositionX() {
		return positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public int getStatusX() {
		return statusX;
	}

	public int getStatusY() {
		return statusY;
	}

	public int getRadius() {
		return radius;
	}

	public void move(PlayerModel player1, PlayerModel player2, CampModel camp) {
		if (positionX >= player1.getPositionX()
				&& positionX < player1.getPositionX() + player1.getWidth()
				&& positionY >= player1.getPositionY()
				&& positionY <= (player1.getPositionY() + player1.getHeight()))
			statusX = MOVINGRIGHT;

		if (positionX >= player2.getPositionX() - radius
				&& positionX < player2.getPositionX() + player2.getWidth()
				&& positionY >= player2.getPositionY()
				&& positionY <= (player2.getPositionY() + player2.getHeight()))
			statusX = MOVINGLEFT;

		if (statusX == MOVINGRIGHT) {
			positionX += speed;
			if (positionX >= (camp.getWidth() - radius - 6))
				statusX = MOVINGLEFT;
		} else {
			positionX -= speed;
			if (positionX <= 0)
				statusX = MOVINGRIGHT;
		}

		if (statusY == MOVINGDOWN) {
			positionY += speed;
			if (positionY >= (camp.getHeight() - radius) - 30)
				statusY = MOVINGUP;
		} else {
			positionY += -speed;
			if (positionY <= 0)
				statusY = MOVINGDOWN;
		}
	}
}
