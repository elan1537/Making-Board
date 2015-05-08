/**
 * 
 */
package com.board.Controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *<pre>
 * com.board.Controller
 *		|_ ControllerAction
 * 1. 	개  요 	:
 * 2. 	작성일 	:  2015. 5. 8.
 * </pre>
 * @author 	: 	pengpark
 *  @version		: 	1.0
 *
 */
public class ControllerAction extends HttpServlet {
	private Map commandMap = new HashMap();
	public void init(ServletConfig config)	throws ServletException {
		loadProperties("com/board/properties/Command");
	}
	
	private void loadProperties(String path) {
		ResourceBundle rbHome = ResourceBundle.getBundle(path);
		
		Enumeration<String> actionEnumHome = rbHome.getKeys();
		
		while(actionEnumHome.hasMoreElements()) 
		{
			String command = actionEnumHome.nextElement();
			String className = rbHome.getString(command);
			
			try {
				Class commandClass = Class.forName(className);
				Object commandInstance = commandClass.newInstance();
				
				commandMap.put(commandClass,  commandInstance);
			} catch (ClassNotFoundException e) {
				continue;
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e ) {
				e.printStackTrace();
			}
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}
	
	private void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = null;
		
		CommandAction com = null;
		
		try {
			String command = request.getRequestURI();
			if (command.indexOf(request.getContextPath()) == 0) {
				command = command.substring(request.getContextPath().length());
			}
			
			com = (CommandAction) commandMap.get(command);
			if (com == null) {
				System.out.println("not found : " + command);
				return;
			}
			view = com.requestPro(request, response);
			if(view == null) {
				return;
			}
		} catch (Throwable e) {
			throw new ServletException(e);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}
}
