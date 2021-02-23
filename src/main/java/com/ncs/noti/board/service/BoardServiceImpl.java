package com.ncs.noti.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.noti.board.DAO.BoardDAOImpl;
import com.ncs.noti.board.VO.BoardVO;
import com.ncs.noti.board.VO.Criteria;
import com.ncs.noti.board.VO.likeUserVO;


@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDAOImpl boardDAO;

	public void insertBoard(BoardVO vo) {

		boardDAO.insertBoard(vo);
	}
	//좋아요시작
	public void likeBoard(likeUserVO vo) {
		boardDAO.likeBoard(vo);
		boardDAO.likeBoardUp(vo);
	}
	
	public void likeBoardDel(likeUserVO vo) {
		boardDAO.likeBoardDel(vo);
		boardDAO.likeBoardUp(vo);
	}
	
	public int likeBoardCount(likeUserVO vo) {
		return boardDAO.likeBoardCount(vo);
	}
	
	
	//좋아요끝
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}
	

	public BoardVO getBoard(BoardVO vo) {
		boardDAO.boardCount(vo.getUser_board_no());
		return boardDAO.getBoard(vo);
	}
	
	public BoardVO forUpdateBoard(BoardVO vo) {
		return boardDAO.forUpdateBoard(vo);
	}

	public List<BoardVO> getBoardList() {
		return boardDAO.getBoardList();
	}
	public List<BoardVO> getBoardList(String vo) {
		return boardDAO.getBoardList(vo);
	}
	
	public List<likeUserVO> likeUserList(Criteria cri) throws Exception {
		return boardDAO.likeUserList(cri);
	}

	@Override
	public List<BoardVO> getBoardList(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.getBoardList(cri);
	}

	@Override
	public int listCount() throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.listCount();
	}
	
	public List<BoardVO> getUserIdBoard(BoardVO vo){
		return boardDAO.getUserIdBoard(vo);
	}
	
	public Map<String,Object> searchHeart(Map<String, Object> map) {
		return boardDAO.searchHeart(map);
	}
	
}