package com.zmz.puzzle;

/*
 * 数据库连接
 */
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class JavaDB {
	private static Connection connDB() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("加载数据库驱动成功");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/loginframe?user=root&password=123456&useSSL=true&useUnicode=true&characterEncoding=UTF8";
		try {
			conn = DriverManager.getConnection(url);
						
			System.out.println("加载数据库成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return conn;
	}

	/*
	 * 查询此用户是否存在 按用户名和密码查询
	 */
	public void queryByName(String name, char[] password) {
		String pwd = String.valueOf(password);
		String sql = "select * from loginstaff where name = '" + name + "' and password = '" + pwd + "' ";
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = connDB();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			//一个ResultSet的指针默认是指向第一行之前的
			if (!rs.next())
				JOptionPane.showMessageDialog(null, "此用户不存在或密码错误!", "error", JOptionPane.ERROR_MESSAGE);
			else {
				JOptionPane.showMessageDialog(null, "游戏开始！", "欢迎", JOptionPane.YES_OPTION);
				new GameStart();
				
			}
		} catch (SQLException e) {
			System.out.print("Exception" + e.getMessage());
		}
	}

}
