package com.ncs.noti.total.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.noti.board.VO.infoBoardVO;
import com.ncs.noti.board.service.infoBoardService;
import com.ncs.noti.total.DAO.SearchTextDAOImpl;
import com.ncs.noti.total.VO.SearchTextVO;

@Service("searchtextService")
public class SearchTestServiceImpl implements SearchTextService  {

	@Autowired
	private SearchTextDAOImpl SearchTextDAO;
	
	public int inserttext(SearchTextVO vo) {
		return SearchTextDAO.inserttext(vo);	
	
	}
	
	public List<SearchTextVO> getTopSearchday(SearchTextVO vo) {
		return SearchTextDAO.getTopSearchday(vo);
	}
	
	public List<SearchTextVO> getTopSearchweek(SearchTextVO vo) {
		return SearchTextDAO.getTopSearchweek(vo);
	}
	
	public List<SearchTextVO> getTopSearchmonth(SearchTextVO vo) {
		return SearchTextDAO.getTopSearchmonth(vo);
	}

//	@Override
//	public void inserttext(String searchText) {
//		// TODO Auto-generated method stub
//		SearchTextDAO.inserttext(searchText);
//		
//	}
}
