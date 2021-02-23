package com.ncs.noti.board.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ncs.noti.board.VO.BoardVO;
import com.ncs.noti.board.VO.Criteria;
import com.ncs.noti.board.VO.likeUserVO;

@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO {
	@Autowired
	private SqlSessionTemplate mybatis;

	public void insertBoard(BoardVO vo) {
		System.out.println("===> Mybatis insertBoard() 호출");
		mybatis.insert("BoardDAO.insertBoard", vo);
	}
//좋아요기능시작
	public void likeBoard(likeUserVO vo) {
		System.out.println("===> Mybatis likeBoard() 호출");
		mybatis.insert("BoardDAO.likeBoard", vo);

	}
	
	public void likeBoardDel(likeUserVO vo) {
		System.out.println("===> Mybatis likeBoardDel() 호출");
		mybatis.delete("BoardDAO.likeBoardDel", vo);
	}
	
	public void likeBoardUp(likeUserVO vo) {
		System.out.println("===> Mybatis likeBoardUp() 호출");
		mybatis.update("BoardDAO.likeBoardUp", vo);
	}
	
	public int likeBoardCount(likeUserVO vo) {
		System.out.println("===> Mybatis likeBoardCount() 호출");
		return mybatis.selectOne("BoardDAO.likeBoardCount", vo);
	}
//좋아요기능끝
	public void updateBoard(BoardVO vo) {
		System.out.println("===> Mybatis updateBoard() 호출");
		mybatis.update("BoardDAO.updateBoard", vo);
	}

	public void deleteBoard(BoardVO vo) {
		System.out.println("===> Mybatis deleteBoard() 호출");
		mybatis.delete("BoardDAO.deleteBoard", vo);
	}

	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Mybatis getBoard() 호출");
		return (BoardVO) mybatis.selectOne("BoardDAO.getBoard", vo);
	}

	public BoardVO forUpdateBoard(BoardVO vo) {
		System.out.println("===> Mybatis forUpdateBoard() 호출");
		return (BoardVO) mybatis.selectOne("BoardDAO.forUpdateBoard", vo);
	}

	@Override
	public void boardCount(int user_board_no) {
		mybatis.update("BoardDAO.boardCount", user_board_no);
	}
	
	public List<BoardVO> getBoardList() {
		System.out.println("===> Mybatis getBoardList() 호출");
		return mybatis.selectList("BoardDAO.getBoardListAll");
	}

	public List<BoardVO> getBoardList(String vo) {
		System.out.println("===> Mybatis getBoardList() 호출");
		return mybatis.selectList("BoardDAO.getBoardListText", vo);
	}

	public List<likeUserVO> likeUserList(Criteria cri) throws Exception {
		System.out.println("===> Mybatis likeUserList() 호출");
		return mybatis.selectList("BoardDAO.likeUserList", cri);
	}

	// 게시판 목록
	public List<BoardVO> getBoardList(Criteria cri) throws Exception {
		System.out.println("===> Mybatis getBoardList() 호출");
		return mybatis.selectList("BoardDAO.getBoardList", cri);
	}

	// 게시물 총 갯수
	@Override
	public int listCount() throws Exception {
		return mybatis.selectOne("BoardDAO.listCount");
	}

	public List<BoardVO> getUserIdBoard(BoardVO vo) {
		System.out.println("===> Mybatis getUserIdBoard() 호출");
		return mybatis.selectList("BoardDAO.getUserIdBoard", vo);
	}
	
	public Map<String,Object> searchHeart(Map<String, Object> map) {
		System.out.println("하트검색!");
		return mybatis.selectOne("BoardDAO.searchHeart", map);
	}
	
}