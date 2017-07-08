package com.zmz.puzzle;

import java.awt.event.*;

import javax.swing.JOptionPane;

public class GameListener implements ActionListener {
	private int[] dir = { -4, -1, 1, 4 };

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		GameButton button = (GameButton) e.getSource();
		int now = button.getIndex();
		int next;
		for (int i = 0; i < 4; i++) {
			next = now + dir[i];
			if (next < 0 || next > 15 || now % 4 == 3 && next % 4 == 0 || now % 4 == 0 && next % 4 == 3
					|| GameFrame.buttons[next].getId() != 15)
				continue;
			GameFrame.buttons[next].setIcon(button.getIcon());
			GameFrame.buttons[next].setId(button.getId());
			button.setIcon("res\\15.png");
			button.setId(15);
			boolean win = true;
			for (int j = 0; j < 15; j++) {
				if (GameFrame.buttons[j].getId() != j) {
					win = false;
					break;
				}
//				System.out.print(GameFrame.buttons[j].getId());
			}
//			System.out.println();
			if (win) {
				JOptionPane.showMessageDialog(GameStart.frame, "You win!");
				GameFrame.setRandom();
			}
		}
	}

}
