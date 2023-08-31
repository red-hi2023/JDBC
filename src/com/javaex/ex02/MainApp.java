package com.javaex.ex02;

import java.util.List;

public class MainApp {
	// 필드 생성자 메소드-gs

	// 메소드-일반
	public static void main(String[] args) {
		int count =-1;
		
		AuthorDao authorDao = new AuthorDao();

		//count = authorDao.authorInsert("강풀", "무빙");
		//System.out.println(count + "등록");
		
		//count = authorDao.authorInsert("황일영", "학원강사");
		//System.out.println(count + "등록");
		

		//count =authorDao.authorDelete(11);
		//System.out.println(count + "삭제");
		
		
		List<AuthorVo> authorList = authorDao.authorSelect();
		System.out.println(authorList);
		
		/*
		for(int i=0; i<authorList.size(); i++) {
			System.out.println("---------------------------------------------------------------------------------------");
			System.out.println(authorList.get(i).toString());
		}
		*/

		
		authorDao.authorUpdate(6, "이문열2", "삼국지작가2");
		
		
		AuthorVo authorVo = authorDao.authorSelectOne(6);
		System.out.println(authorVo);
		
		
	}

}
