package com.zmz.puzzle;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.zip.CheckedInputStream;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.*;

public class Login2 extends JFrame {

	private JPanel contentPane;
	private static JTextField t_name;
	private static JPasswordField t_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login2 lframe = new Login2();
					lframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login2() {
		
		setTitle("WelCome to my Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 404);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPlayername = new JLabel("Player_Name");
		lblPlayername.setBounds(79, 75, 107, 41);
		contentPane.add(lblPlayername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(79, 143, 94, 31);
		contentPane.add(lblPassword);
		
		t_name = new JTextField();
		t_name.setBounds(212, 83, 199, 24);
		contentPane.add(t_name);
		t_name.setColumns(10);
		
		t_password = new JPasswordField();
		t_password.setBounds(212, 146, 198, 24);
		contentPane.add(t_password);
		t_password.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check();
			}
		});
		btnLogin.setBounds(106, 254, 107, 31);
		contentPane.add(btnLogin);
		
		JButton btnNewButton = new JButton("Cancle");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setBounds(318, 254, 113, 31);
		contentPane.add(btnNewButton);
	}
	 public static void check()
	 {
	  if(t_name.getText().equals(""))
	   JOptionPane.showMessageDialog(null, "请输入用户名!", "error",JOptionPane.ERROR_MESSAGE);
	  else if(t_password.getPassword().equals(""))
	   JOptionPane.showMessageDialog(null, "请输入密码!", "error",JOptionPane.ERROR_MESSAGE);
	  else
	   new JavaDB().queryByName(t_name.getText(),t_password.getPassword());
	 }
}
