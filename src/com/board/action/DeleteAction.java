/**
 * 
 */
package com.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

import com.board.controller.*;

public class DeleteAction implements CommandAction{

	/* (non-Javadoc)
	 * @see com.board.controller.CommandAction#requestPro(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
	
		String idx = request.getParameter("idx");
		
		try {
			String driverName = "org.gjt.mm.mysql.Driver";
			String url = "jdbc:mysql://localhost:3306/Pengpark";
			
			Class.forName(driverName);
			Connection con = DriverManager.getConnection(url, "Pengpark", "miswneh8");
			System.out.println("데이터베이스 접속 성공");
			
			Statement stmt = con.createStatement();
			String sql = "delete from board where idx = " + idx;
			stmt.executeUpdate(sql);
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return "delete.jsp";
	}

}
