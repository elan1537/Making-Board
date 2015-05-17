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
		_instance.SetDB();
		return _instance;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Board> getArticleList(int page) throws SQLException {
		ArrayList<Board> articleList = null;
		articleList = (ArrayList<Board>)GetDB().queryForList("getArticleList", null, page, 10);
		return articleList;
//		return (ArrayList<Board>)GetDB().queryForList("getArticleList", null, page, 10);
	}
	
	public Board getArticle(int idx) throws SQLException {
		Board article = null;
		article = (Board)GetDB().queryForObject("getArticle", idx);
		return article;
	}
	
	public void insertArticle(Board article) throws SQLException {
		GetDB().insert("insertArticle", article);
	}
	
	public void deleteArticle(int idx) throws SQLException {
		GetDB().delete("deleteArticle", idx);
	}
	
	public void setArticleCount(Board article) throws SQLException {
		GetDB().update("setArticleCount", article);
	}
}