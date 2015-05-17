/**
 * 
 */
package com.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.beans.Board;
import com.board.controller.CommandAction;
import com.board.dao.*;

public class InsertAction  implements CommandAction {

	/* (non-Javadoc)
	 * @see com.board.controller.CommandAction#requestPro(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		
		request.setCharacterEncoding("euc-kr");
		int count = 0;
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");

		String content = request.getParameter("content");
		String regip = request.getRemoteAddr();

		if(title == "" || title == null) System.out.println("title이 null입니다.");
		if(writer == "" || writer == null) System.out.println("writer가 null입니다.	");
//		else if(!Pattern.matches("^[a-zA-Z0-9]+@[a-zA-Z0-9]+$", writer)) out.println("이메일 형식이 아닙니다.");
		
		Board article = new Board();
		
		article.setRegip(regip);
		article.setTitle(title);
		article.setWriter(writer);
		article.setContent(content);
		article.setCount(count);
		BoardDao.getInstance().insertArticle(article);
		
		
//		try {
//			String url = "jdbc:mysql://localhost:3306/Pengpark"; // 사용하려는 데이터베이스명
//			String id = "Pengpark";
//			String pw = "miswneh8";
//			
//			Class.forName("org.gjt.mm.mysql.Driver");
//			Connection conn = DriverManager.getConnection(url, id, pw);
//			System.out.println("제대로 연결되었습니다.");	
//			
//			Statement stmt = conn.createStatement();
//			
//			String sql = "INSERT INTO Pengpark.board" + 
//				"(title, writer, regdate, count, content)"  + 
//				"VALUES('"+title+"', '"+writer+"', now(), '1', '"+content+"')";
//			stmt.executeUpdate(sql);
//			conn.close();
//			
//		} catch(Exception e) {
//			System.out.println("데이터베이스 접속 실패");
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
		return "insert.jsp";
	}

}
