package com.ncs.noti.total.DAO;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ncs.noti.board.VO.infoBoardVO;
import com.ncs.noti.total.VO.SearchTextVO;

@Repository("searchtextDAO") 
public class SearchTextDAOImpl implements SearchTextDAO{
	
	@Autowired
	public SqlSessionTemplate mybatis;
	
	
	public int inserttext(SearchTextVO vo) {
		System.out.println("===> Mybatis inserttext() 호출");
		return mybatis.insert("SearchTextDAO.inserttext", vo);
	}
	
	public List<SearchTextVO> getTopSearchday(SearchTextVO vo) {
		System.out.println("===> Mybatis getTopSearchday() 호출");
		return mybatis.selectList("SearchTextDAO.dayList", vo);
	}
	
	public List<SearchTextVO> getTopSearchweek(SearchTextVO vo) {
		System.out.println("===> Mybatis getTopSearchweek() 호출");
		return mybatis.selectList("SearchTextDAO.weekList", vo);
	}
	
	public List<SearchTextVO> getTopSearchmonth(SearchTextVO vo) {
		System.out.println("===> Mybatis getTopSearchmonth() 호출");
		return mybatis.selectList("SearchTextDAO.monthList", vo);
	}

	

//	@Override
//	public void inserttext(String searchText) {
//		System.out.println("===> Mybatis inserttext() 호출");
//		mybatis.insert("searchtextDAO.inserttext", searchText);
//	}

}
