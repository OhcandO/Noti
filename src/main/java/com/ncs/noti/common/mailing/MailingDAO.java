package com.ncs.noti.common.mailing;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("MailingDAO")
public class MailingDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	/*
	List popular_textL = new ArrayList();
	
	List popular_contentL = new ArrayList();
	
	List user_search_resultL = new ArrayList();
	
	*/
	
	// 주간 인기 검색어 들어갈 자리
	public List<MailingVO> getPopular_textL (){
		System.out.println("-=-=-=-=-=-=메일링 다오-=-=-=-=-=-=--=");
		return mybatis.selectList("MailingDAO.getPopularTextL");
	}
	
	
	// 주간 인기 게시물 들어갈 자리
	public List<MailingVO> getPopularContentL(){
		return mybatis.selectList("MailingDAO.getPopularContentL");
	}
	
	// 주간 회원의 상위 3개 검색어에 대한 DB 검색 결과
	public List<MailingVO> getUserSearchResultL(String user_id){
		return mybatis.selectList("MailingDAO.getUserSearchResultL", user_id);
	}
	
	
	
}
