package com.ncs.noti.board.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ncs.noti.board.VO.BoardVO;
import com.ncs.noti.board.VO.Criteria;
import com.ncs.noti.board.VO.likeUserVO;

public interface BoardDAO {
	public void insertBoard(BoardVO vo);

	//좋아요기능시작
	public void likeBoard(likeUserVO vo);
	
	public void likeBoardDel(likeUserVO vo);
	
	public void likeBoardUp(likeUserVO vo);
	
	public int likeBoardCount(likeUserVO vo);
	//좋아요기능끝
	public void updateBoard(BoardVO vo);

	public void deleteBoard(BoardVO vo);

	public BoardVO getBoard(BoardVO vo);

	public BoardVO forUpdateBoard(BoardVO vo);

	public void boardCount(int user_board_no);


	public List<BoardVO> getBoardList();
	
	public List<BoardVO> getBoardList(Criteria cri) throws Exception;

	public List<BoardVO> getBoardList(String vo);

	public List<likeUserVO> likeUserList(Criteria cri) throws Exception;

	// 게시물 총 갯수
	public int listCount() throws Exception;

	public List<BoardVO> getUserIdBoard(BoardVO vo);

	public Map<String,Object> searchHeart(Map<String, Object> map);

}
