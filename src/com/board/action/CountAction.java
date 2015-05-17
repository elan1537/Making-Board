/**
 * 
 */
package com.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.beans.Board;
import com.board.controller.CommandAction;
import com.board.dao.BoardDao;

/**
 *<pre>
 * com.board.action
 *		|_ CountAction
 * 1. 	개  요 	:
 * 2. 	작성일 	:  2015. 5. 16.
 * </pre>
 * @author 	: 	pengpark
 *  @version		: 	1.0
 *
 */
public class CountAction implements CommandAction{ 
	
	@Override
	public String requestPro(HttpServletRequest request, 
			HttpServletResponse response) throws Throwable {
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		Board article = BoardDao.getInstance().getArticle(idx);
		String regip = request.getRemoteAddr();
		
		if(!regip.equals(article.getRegip())) {
			int count = article.getCount();
			article.setCount(count++);
			BoardDao.getInstance().setArticleCount(article);
		}
		
		request.setAttribute("url", "content.do?idx="+idx);
		return "redirect2.jsp";
	}

}
