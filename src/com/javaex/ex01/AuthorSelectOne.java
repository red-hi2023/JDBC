package com.javaex.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorSelectOne {
	// 필드 생성자 //메소드 gs
	// 메소드 일반
	public static void main(String[] args) {

		List<AuthorVo> authorList = new ArrayList<AuthorVo>();
		
		
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

			// 3. SQL문 준비 / 바인딩 / 실행
			//SQL문 준비
			int no = 3;
			
			String query = "";
			query += " select  author_id, ";
			query += " 		   author_name, ";
			query += "         author_desc ";
			query += " from author ";
			query += " where author_id = ? ";
			//System.out.println(query);
			
			pstmt = conn.prepareStatement(query);
			
			//바인딩
			pstmt.setInt(1, no);
			
			//실행
			rs = pstmt.executeQuery();
			
			// 4.결과처리
			while(rs.next()) {
				int authorId = rs.getInt(1);
				String authorName = rs.getString(2);
				String authorDesc = rs.getString(3);
				
				AuthorVo authorVo = new AuthorVo();
				authorVo.setAuthorId(authorId);
				authorVo.setAuthorName(authorName);
				authorVo.setAuthorDesc(authorDesc);
				
				authorList.add(authorVo);
				
			}
			

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {

			// 5. 자원정리
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}

		}

		for(int i=0; i<authorList.size(); i++) {
			System.out.println("id:" + authorList.get(i).getAuthorId()
					         + " name:" + authorList.get(i).getAuthorName()
							 + " desc:" + authorList.get(i).getAuthorDesc()	);
		}
		
		
	}

}
