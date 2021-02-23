package com.ncs.noti.total.Service;

import java.util.List;

import com.ncs.noti.board.VO.infoBoardVO;
import com.ncs.noti.total.VO.SearchTextVO;

public interface SearchTextService {
	int inserttext(SearchTextVO vo);

	public List<SearchTextVO> getTopSearchday(SearchTextVO vo);
	
	public List<SearchTextVO> getTopSearchweek(SearchTextVO vo);
	
	public List<SearchTextVO> getTopSearchmonth(SearchTextVO vo);
}
