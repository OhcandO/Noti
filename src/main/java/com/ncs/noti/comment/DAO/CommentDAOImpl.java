package com.ncs.noti.comment.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ncs.noti.comment.VO.CommentVO;

@Repository("CommentDAO")
public class CommentDAOImpl implements CommentDAO{

	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public int getGroupId() {
		//TODO '그룹아이디' 얻어오는 메서드
		return mybatis.selectOne("CommentDAO.getGroupId");
	}
	
//	----------------------------------------------------
	
	@Override
	public int insertComment(CommentVO vo) {
		System.out.println("~-~-~댓글 입력 / insertComment -~-~");
		return mybatis.insert("CommentDAO.insertComment", vo);
	}

	@Override
	public int deleteComment(int Comment_no) {
		return mybatis.delete("CommentDAO.deleteComment", Comment_no);
	}

	@Override
	public int updateComment(CommentVO vo) {
		return mybatis.update("CommentDAO.updateComment", vo);
	}

	@Override
	public CommentVO selectById(int Comment_no) {
		// TODO 부모 댓글의 PK로 댓글의 정보객체 담아오기
		return mybatis.selectOne("CommentDAO.selectById", Comment_no);
	}
	
	@Override
	public List<CommentVO> getCommentList(int board_no) {
		return mybatis.selectList("CommentDAO.getCommentList", board_no);
	}


	@Override
	public int getCountCommentByBNO(int board_no) {
		// TODO 게시물 일련번호에 몇 개의 댓글이 있는지 확인하는 방법
		return 0;
	}

	@Override
	public String selectLastSequenceNumber (String maxSeqNum, String minSeqNum) {
		// TODO Auto-generated method stub
		Map<String,String> map = new HashMap<String, String>();
		map.put("big", maxSeqNum);
		map.put("small", minSeqNum);
		System.out.println("=======매퍼로 넘어가기 직전==========");
		return mybatis.selectOne("CommentDAO.selectLastSequenceNumber", map);
	}

	
}
