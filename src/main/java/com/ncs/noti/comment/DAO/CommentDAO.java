package com.ncs.noti.comment.DAO;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ncs.noti.comment.VO.CommentVO;

public interface CommentDAO {

	public int insertComment(CommentVO vo);
	public int deleteComment(int Comment_no);
	public int updateComment(CommentVO vo);
	
	public int getGroupId();
	
	//특정 댓글 번호를 입력하여 댓글객체 (VO)를 생성
	public CommentVO selectById(int Comment_no);
	
	// 게시글 번호를 입력하고 연결된 댓글들을 출력
	public List<CommentVO> getCommentList (int board_no);
	
	// 특정 게시글 번호에 몇 개의 댓글들이 있는지 표시
	public int getCountCommentByBNO(int board_no);
	
	// 대댓글 작성할 때 필요함...
	public String selectLastSequenceNumber(@Param("maxSeqNum")String maxSeqNum, @Param("minSeqNum")String minSeqNum);
	
}
