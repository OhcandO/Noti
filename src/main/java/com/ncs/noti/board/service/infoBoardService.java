package com.ncs.noti.board.service;

import java.util.List;

import com.ncs.noti.board.VO.BoardVO;
import com.ncs.noti.board.VO.Criteria;
import com.ncs.noti.board.VO.infoBoardVO;
import com.ncs.noti.board.VO.likeInfoVO;
import com.ncs.noti.board.VO.likeUserVO;

public interface infoBoardService {
	// 크롤링 디비 입력
	void insertinfoBoard(infoBoardVO vo);
	
	// 글 목록 조회
	public List<infoBoardVO> getinfoBoardList();
	
	public List<infoBoardVO> getinfoBoardList(Criteria cri) throws Exception;
	
	//글 총 갯수
	public int listCount() throws Exception;
	
	// 글 상세 조회
	public infoBoardVO getinfoBoard(infoBoardVO vo);
	
	// 정보 리스트 검색
	public List<infoBoardVO> getinfoBoardList(String vo);
	
	// 관심 게시글 등록 -좋아요시작
		void likeBoardInfo(likeInfoVO vo);
		
		void likeBoardDelInfo(likeInfoVO vo);
		
		int likeBoardCountInfo(likeInfoVO lvo);
		
		List<likeInfoVO> likeInfoList(Criteria cri) throws Exception;
		//좋아요끝
}
