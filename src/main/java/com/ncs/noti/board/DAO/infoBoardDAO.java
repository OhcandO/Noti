package com.ncs.noti.board.DAO;

import java.util.List;

import com.ncs.noti.board.VO.Criteria;
import com.ncs.noti.board.VO.infoBoardVO;
import com.ncs.noti.board.VO.likeInfoVO;
import com.ncs.noti.board.VO.likeUserVO;

public interface infoBoardDAO {
	public void insertinfoBoard(infoBoardVO vo);
	
	public List<infoBoardVO> getinfoBoardList() ;
	//게시물 리스트
	public List<infoBoardVO> getinfoBoardList(String vo) ;
	
	public List<infoBoardVO> getinfoBoardList(Criteria cri) throws Exception;
	//게시물 총 갯수
	public int listCount() throws Exception;
	
	public infoBoardVO getinfoBoard(infoBoardVO vo) ;
	
	
	public void infoboardCount(int info_board_no);
	
	//좋아요기능시작
		public void likeBoardInfo(likeInfoVO vo);
		
		public void likeBoardDelInfo(likeInfoVO vo);
		
		public void likeBoardUpInfo(likeInfoVO vo);
		
		public int likeBoardCountInfo(likeInfoVO vo);
		
		public List<likeInfoVO> likeInfoList(Criteria cri) throws Exception;
		//좋아요기능끝
	
}
