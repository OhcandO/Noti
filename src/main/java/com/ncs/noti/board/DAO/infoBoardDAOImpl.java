package com.ncs.noti.board.DAO;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ncs.noti.board.VO.Criteria;
import com.ncs.noti.board.VO.infoBoardVO;
import com.ncs.noti.board.VO.likeInfoVO;
import com.ncs.noti.board.VO.likeUserVO;

@Repository("infoboardDAO") 
public class infoBoardDAOImpl implements infoBoardDAO{
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertinfoBoard(infoBoardVO vo) {
		System.out.println("===> Mybatis insertBoard() 호출");
		mybatis.insert("infoBoardDAO.insertInfoBoard", vo);
	}
	
	public infoBoardVO getinfoBoard(infoBoardVO vo) {
		System.out.println("===> Mybatis getBoard() 호출");
		return (infoBoardVO) mybatis.selectOne("infoBoardDAO.getinfoBoard", vo);
	}
	
	//게시물 리스트
	public List<infoBoardVO> getinfoBoardList() {
		System.out.println("===> Mybatis getBoardList() 호출");
		return mybatis.selectList("infoBoardDAO.getinfoBoardListAll");
	}
	
//	public List<infoBoardVO> getinfoBoardList(Criteria cri) {
//		System.out.println("===> Mybatis getBoardList() 호출");
//		return mybatis.selectList("infoBoardDAO.getinfoBoardList", cri);
//	}
	
	@Override
	public List<infoBoardVO> getinfoBoardList(Criteria cri) {
		// TODO Auto-generated method stub
		System.out.println("===> Mybatis getBoardList() 호출");
		return mybatis.selectList("infoBoardDAO.getinfoBoardList", cri);
	}

		//게시물 총 갯수
		public int listCount() throws Exception{
			return mybatis.selectOne("infoBoardDAO.listCount");
		}
		
	@Override
	public void infoboardCount(int info_board_no) {
		mybatis.update("infoBoardDAO.infoboardCount", info_board_no);
	}
		
	
	public List<infoBoardVO> getinfoBoardList(String vo) {
		System.out.println("===> Mybatis getBoardList() 서치값 호출");
		return mybatis.selectList("infoBoardDAO.getinfoBoardListText", vo);
	}
	
	//좋아요기능시작
		public void likeBoardInfo(likeInfoVO vo) {
			System.out.println("===> Mybatis likeBoard() 호출");
			mybatis.insert("infoBoardDAO.likeBoardInfo", vo);

		}
		
		public void likeBoardDelInfo(likeInfoVO vo) {
			System.out.println("===> Mybatis likeBoardDel() 호출");
			mybatis.delete("infoBoardDAO.likeBoardDelInfo", vo);
		}
		
		public void likeBoardUpInfo(likeInfoVO vo) {
			System.out.println("===> Mybatis likeBoardUp() 호출");
			mybatis.update("infoBoardDAO.likeBoardUpInfo", vo);
		}
		
		public int likeBoardCountInfo(likeInfoVO vo) {
			System.out.println("===> Mybatis likeBoardCount() 호출");
			return mybatis.selectOne("infoBoardDAO.likeBoardCountInfo", vo);
		}
		
		public List<likeInfoVO> likeInfoList(Criteria cri) throws Exception {
			System.out.println("===> Mybatis likeInfoList() 호출");
			return mybatis.selectList("BoardDAO.likeInfoList", cri);
		}
	//좋아요기능끝


}
