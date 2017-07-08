package com.zmz.puzzle;

import java.awt.*;
import java.util.Random;

import javax.swing.*;

public class GameFrame extends JFrame {
	public static int[] a = new int[16];
	public static GameButton[] buttons = new GameButton[16];

	public GameFrame() {
		// TODO Auto-generated constructor stub
		setSize(500, 500);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(4, 4));

		GameListener listener = new GameListener();
		for (int i = 0; i < 16; i++) {
			buttons[i] = new GameButton();
			buttons[i].setIndex(i);
			buttons[i].addActionListener(listener);
//			buttons[i].setSize(125, 125);
			add(buttons[i]);
		}
		setRandom();
		validate();
	}
	
	public void setIcon2() {
		for (int i = 0; i < 16; i++) {
			String path = "res\\" + a[i] + ".png";
			buttons[i].setIcon(path);
		}
	}
	
	public static void setRandom() {
		Random random = new Random();
		boolean flag[] = new boolean[16];
		for (int i = 0; i < 16; i++) {
			int tmp = random.nextInt(16);
			while (flag[tmp])
				tmp = random.nextInt(16);
			flag[tmp] = true;
			a[i] = tmp;
		}
		if (!solution()) {
			int tmp = a[0];
			a[0] = a[1];
			a[1] = tmp;
			 System.out.println("solved");
		}
		for (int i = 0; i < 16; i++) {
			String path = "res\\" + a[i] + ".png";
//			buttons[i].setIcon(path);
			buttons[i].setId(a[i]);
		}
	}

	static boolean solution() {
		int num = 0;
		for (int i = 0; i < 16; i++) {
			for (int j = i + 1; j < 16 && a[i] != 0; j++)
				if (a[i] > a[j])
					num++;
			if (a[i] == 0)
				num += i / 4 + i % 4;
		}
		return num % 2 == 1;
	}

}
