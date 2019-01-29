package br.org.eldorado.pongspring.models;

public class PlayerModel {
	private int positionX;
	private int positionY;
	private int score;
	private int status;
	private String name;
	private int width;
	private int height;
	private int speed;
	private boolean winner;
	public static final int STOPPED = 0;
	public static final int MOVINGUP = 1;
	public static final int MOVINGDOWN = 2;

	public PlayerModel(String name, int positionX, int positionY, int width,
			int height, int speed) {
		this.positionX = positionX;
		this.positionY = positionY;
		this.width = width;
		this.height = height;
		this.name = name;
		this.score = 0;
		this.speed = speed;
		this.status = STOPPED;
		this.winner = false;
	}

	public void incrementScore() {
		this.score += 1;
	}

	public int getWidth() {
		return width;
	}

	public boolean isWinner() {
		return this.winner;
	}

	public void setWinner() {
		this.winner = true;
	}
	
	public int getHeight() {
		return height;
	}

	public int getPositionX() {
		return positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	public void setMovementDirection(int direction) {
		this.status = direction;
	}

	public void stop() {
		this.status = STOPPED;
	}

	public void updatePosition(CampModel camp) {
		if (status == MOVINGDOWN
				&& positionY <= (camp.getHeight() - height - speed - 30))
			positionY += speed;
		if (status == MOVINGUP && positionY >= speed)
			positionY += -speed;
	}
}
