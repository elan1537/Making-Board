/**
 * 
 */
package com.board.action;

import java.sql.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.controller.CommandAction;
import com.board.dao.*;

public class ContentAction  implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		
		String idx = request.getParameter("idx");	
		try {
			String driverName = "org.gjt.mm.mysql.Driver";
			String url = "jdbc:mysql://localhost:3306/Pengpark";
			ResultSet rs = null;
			
			Class.forName(driverName);
			Connection con = DriverManager.getConnection(url, "Pengpark", "miswneh8");
			System.out.println("데이터베이스 접속 성공");
			
			Statement stmt = con.createStatement();
			String sql = "select * from board where idx = " + idx;
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				request.setAttribute("idx", rs.getString("idx"));
				request.setAttribute("writer", rs.getString("writer"));
				request.setAttribute("regdate", rs.getString("regdate"));
				request.setAttribute("count", rs.getString("count"));
				request.setAttribute("title", rs.getString("title"));
				request.setAttribute("content", rs.getString("content"));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return "content.jsp";
	}

}
