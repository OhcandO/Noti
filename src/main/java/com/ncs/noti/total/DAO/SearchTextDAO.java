package com.ncs.noti.total.DAO;

import java.util.List;

import com.ncs.noti.total.VO.SearchTextVO;

public interface SearchTextDAO {
	public int inserttext(SearchTextVO vo);
	
	public List<SearchTextVO> getTopSearchday(SearchTextVO vo) ;
	
	public List<SearchTextVO> getTopSearchweek(SearchTextVO vo) ;
	
	public List<SearchTextVO> getTopSearchmonth(SearchTextVO vo);
	
	//public void inserttext(String searchText);
}
