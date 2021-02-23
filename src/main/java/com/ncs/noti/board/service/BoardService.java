package com.ncs.noti.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ncs.noti.board.VO.BoardVO;
import com.ncs.noti.board.VO.Criteria;
import com.ncs.noti.board.VO.likeUserVO;

public interface BoardService {
	// CRUD 기능의 메소드 구현
	// 글 등록
	void insertBoard(BoardVO vo);

	// 글 수정
	void updateBoard(BoardVO vo);

	// 글 삭제
	void deleteBoard(BoardVO vo);

	// 글 상세 조회
	BoardVO getBoard(BoardVO vo);

	// 글 조회수 증가
	BoardVO forUpdateBoard(BoardVO vo);

	// 관심 게시글 등록 -좋아요시작
	void likeBoard(likeUserVO vo);
	
	void likeBoardDel(likeUserVO vo);
	
	int likeBoardCount(likeUserVO vo);
	//좋아요끝

	// 글 목록 조회
	List<BoardVO> getBoardList(Criteria cri) throws Exception;

	public int listCount() throws Exception;

	// 글 목록 조회
	List<BoardVO> getBoardList();

	List<BoardVO> getBoardList(String vo);

	List<likeUserVO> likeUserList(Criteria cri) throws Exception;
	
	public List<BoardVO> getUserIdBoard(BoardVO vo);
	
	public Map<String,Object> searchHeart(Map<String, Object> commandMap);
	

}
