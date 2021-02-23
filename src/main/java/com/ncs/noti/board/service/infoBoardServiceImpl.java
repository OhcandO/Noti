package com.ncs.noti.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.noti.board.DAO.infoBoardDAOImpl;
import com.ncs.noti.board.VO.BoardVO;
import com.ncs.noti.board.VO.Criteria;
import com.ncs.noti.board.VO.infoBoardVO;
import com.ncs.noti.board.VO.likeInfoVO;
import com.ncs.noti.board.VO.likeUserVO;

@Service("infoBoardService")
public class infoBoardServiceImpl implements infoBoardService  {
	@Autowired
	private infoBoardDAOImpl infoboardDAO;
	
	
	public List<infoBoardVO> getinfoBoardList() {
		return infoboardDAO.getinfoBoardList();
	}
	@Override
	public List<infoBoardVO> getinfoBoardList(Criteria cri) throws Exception {
		return infoboardDAO.getinfoBoardList(cri);
	}
	
	@Override
	public int listCount() throws Exception{
		return infoboardDAO.listCount();
	}
	
	public infoBoardVO getinfoBoard(infoBoardVO vo) {
		infoboardDAO.infoboardCount(vo.getInfo_board_no());
		return infoboardDAO.getinfoBoard(vo);
	}
	
	@Override
	public void insertinfoBoard(infoBoardVO vo) {
		// TODO Auto-generated method stub
		infoboardDAO.insertinfoBoard(vo);
	}
	public List<infoBoardVO> getinfoBoardList(String vo) {
		return infoboardDAO.getinfoBoardList(vo);
	}
	//좋아요시작
		public void likeBoardInfo(likeInfoVO vo) {
			infoboardDAO.likeBoardInfo(vo);
			infoboardDAO.likeBoardUpInfo(vo);
		}
		
		public void likeBoardDelInfo(likeInfoVO vo) {
			infoboardDAO.likeBoardDelInfo(vo);
			infoboardDAO.likeBoardUpInfo(vo);
		}
		
		public int likeBoardCountInfo(likeInfoVO vo) {
			return infoboardDAO.likeBoardCountInfo(vo);
		}
		
		public List<likeInfoVO> likeInfoList(Criteria cri) throws Exception {
			return infoboardDAO.likeInfoList(cri);
		}
		//좋아요끝
}
