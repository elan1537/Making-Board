package com.board.db.sqlconfig;

import java.io.Reader;
import com.ibatis.common.resources.*;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

/**
 * 
 */

/**
 *<pre>
 * 
 *		|_ IBatisDBConnector
 * 1. 	개  요 	:
 * 2. 	작성일 	:  2015. 5. 9.
 * </pre>
 * @author 	: 	pengpark
 *  @version		: 	1.0
 *
 */
public final class IBatisDBConnector {
	private static SqlMapClient mySQLMap;
	
	static
	{
		try
		{ // 접속 설정 파일 로드
			String resource = "com/board/db/sqlconfig/SqlMapConfig.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			mySQLMap = SqlMapClientBuilder.buildSqlMapClient(reader);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static SqlMapClient getSqlMapInstance()
	{
		// 인스턴스 반환 메서드
		return mySQLMap;
	}

}
