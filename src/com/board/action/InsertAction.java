/**
 * 
 */
package com.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.beans.Board;
import com.board.controller.CommandAction;
import com.board.dao.*;
import com.oreilly.servlet.*;
import com.oreilly.servlet.multipart.*;
public class InsertAction  implements CommandAction {

	/* (non-Javadoc)
	 * @see com.board.controller.CommandAction#requestPro(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		
		request.setCharacterEncoding("euc-kr");
		MultipartRequest multi = null;
		int sizeLimit = 10 * 1024 * 1024;
		String savePath = request.getSession().getServletContext().getRealPath("/upload");    
		try {
			multi=new MultipartRequest(request, savePath, sizeLimit, "euc-kr", new DefaultFileRenamePolicy());
		} catch(Exception e) {
			e.printStackTrace();
		}
	
		int count = 0;
		String filename = multi.getFilesystemName("filename");
		String title = multi.getParameter("title");
		String writer = multi.getParameter("writer");
		String content = multi.getParameter("content");
		String regip = request.getRemoteAddr();
		

		if(title == "" || title == null) System.out.println("title이 null입니다.");
		if(writer == "" || writer == null) System.out.println("writer가 null입니다.	");

		
		Board article = new Board();
		
		article.setFilename(filename);
		article.setRegip(regip);
		article.setTitle(title);
		article.setWriter(writer);
		article.setContent(content);
		article.setCount(count);
		BoardDao.getInstance().insertArticle(article);
		
		
		return "insert.jsp";
	}

}
