/**
 * 
 */
package com.board.Controller;

import javax.servlet.http.*;

/**
 *<pre>
 * com.board.Controller
 *		|_ CommandAction
 * 1. 	개  요 	:
 * 2. 	작성일 	:  2015. 5. 8.
 * </pre>
 * @author 	: 	pengpark
 *  @version		: 	1.0
 *
 */

// 요청 파라미터로 명령어를 전달하는 방식의 슈퍼 인터페이스

public interface CommandAction {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable;
}