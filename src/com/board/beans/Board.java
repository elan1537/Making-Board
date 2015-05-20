/**
 * 
 */
package com.board.beans;

/**
 *<pre>
 * com.board.beans
 *		|_ Board
 * 1. 	개  요 	:
 * 2. 	작성일 	:  2015. 5. 8.
 * </pre>
 * @author 	: 	pengpark
 *  @version		: 	1.0
 *
 */
public class Board {
		private int idx;
		private String title;
		private String writer;
		private String regdate;
		private int count;
		private String content;
		private String regip;
		private String filename;
		
		public String getFilename() {
			return filename;
		}
		
		public void setFilename(String filename) {
			this.filename = filename;
		}
		
		/**
		 * @return the regip
		 */
		public String getRegip() {
			return regip;
		}
		/**
		 * @param regip the regip to set
		 */
		public void setRegip(String regip) {
			this.regip = regip;
		}
		/**
		 * @return the idx
		 */
		public int getIdx() {
			return idx;
		}
		/**
		 * @param idx the idx to set
		 */
		public void setIdx(int idx) {
			this.idx = idx;
		}
		/**
		 * @return the title
		 */
		public String getTitle() {
			return title;
		}
		/**
		 * @param title the title to set
		 */
		public void setTitle(String title) {
			this.title = title;
		}
		/**
		 * @return the writer
		 */
		public String getWriter() {
			return writer;
		}
		/**
		 * @param writer the writer to set
		 */
		public void setWriter(String writer) {
			this.writer = writer;
		}
		/**
		 * @return the regdate
		 */
		public String getRegdate() {
			return regdate;
		}
		/**
		 * @param regdate the regdate to set
		 */
		public void setRegdate(String regdate) {
			this.regdate = regdate;
		}
		/**
		 * @return the count
		 */
		public int getCount() {
			return count;
		}
		/**
		 * @param count the count to set
		 */
		public void setCount(int count) {
			this.count = count;
		}
		/**
		 * @return the content
		 */
		public String getContent() {
			return content;
		}
		/**
		 * @param content the content to set
		 */
		public void setContent(String content) {
			this.content = content;
		}

}
