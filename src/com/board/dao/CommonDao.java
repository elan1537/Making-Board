/**
 * 
 */
package com.board.dao;

import java.sql.*;

public class CommonDao {
	
	private final String driverName = "org.gjt.mm.mysql.Driver";
	private final String url = "jdbc:mysql://localhost:3306/Pengpark";
	private final String db_id = "Pengpark";
	private final String db_pw = "miswneh8";
	
	//접속에 필요한 변수 선언
	
	private Connection con = null;
	private Statement stmt = null;
	
	public Statement openConnection() {
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(url, db_id, db_pw);
			stmt = con.createStatement();
		} catch (Exception e) {
			System.err.println("데이터베이스 접속 문제");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return stmt;
	}
	
	public void closeConnection() {
		try {
			if(!con.isClosed())
				con.close();
		} catch (SQLException e ) {
			e.printStackTrace();
		}
	}
}
