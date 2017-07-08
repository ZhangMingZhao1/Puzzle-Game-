package com.zmz.puzzle;

import java.awt.*;

import javax.swing.*;

public class GameButton extends JButton {
	private int index;
	private int id;
	private Color background = Color.GRAY;
	private Color foreground = Color.WHITE;
	private Font font = new Font("Consolas", Font.PLAIN, 40);

	public GameButton() {
		// TODO Auto-generated constructor stub
		setForeground(foreground);
		setBackground(background);
		setFont(font);
	}

	void setId(int i) {
		id = i;
	}

	int getId() {
		return id;
	}

	void setIndex(int i) {
		index = i;
	}

	int getIndex() {
		return index;
	}

	public void setIcon(String path) {
		ImageIcon icon = new ImageIcon(path);
		Image temp = icon.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT);
		icon = new ImageIcon(temp);
		this.setIcon(icon);
	}
}
