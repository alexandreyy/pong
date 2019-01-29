package br.org.eldorado.pongspring.views;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrameView extends JFrame {

	static final long serialVersionUID = 1L;

	public GameFrameView(String title, int positionX, int positionY,
			int width, int height, JPanel campView,
			KeyAdapter keyboardController) {
		super();

		this.setResizable(false);
		this.setBounds(new Rectangle(positionX, positionY, width, height));
		this.setMinimumSize(new Dimension(width, height));
		this.setMaximumSize(new Dimension(width, height));
		this.setTitle(title);
		this.addKeyListener(keyboardController);
		this.setContentPane(campView);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
