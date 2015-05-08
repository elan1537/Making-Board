/**
 * 
 */
package com.board.dao;

import java.sql.*;
import java.util.ArrayList;

import com.board.beans.Board;

public class BoardDao extends CommonDao {
	public static BoardDao getInstance() {
		BoardDao _instance = new BoardDao();
		return _instance;
	}
	
	public ArrayList<Board> getArticleList() throws SQLException {
		ResultSet rs = null;
		String sql = "select * from board order by idx asc";
		rs = openConnection().executeQuery(sql);
		
		ArrayList<Board>	articleList = new ArrayList<Board>();
		while(rs.next()) {
			Board article = new Board();
			
			article.setIdx(rs.getInt("idx"));
			article.setTitle(rs.getString("title"));
			article.setWriter(rs.getString("writer"));
			article.setRegdate(rs.getString("regdate"));
			
			articleList.add(article);
		}
		closeConnection();
		return articleList;
	}

}
