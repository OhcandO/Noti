package com.ncs.noti.comment.service;

import java.util.List;

import com.ncs.noti.comment.VO.CommentVO;

public interface CommentService {

	public int insertComment(CommentVO vo);
	public int deleteComment(int comment_no);
	public int updateComment(CommentVO vo);
	public int replyComment(int parent_comment_no, CommentVO vo);
	
	// 게시글 번호를 입력하고 연결된 댓글들을 출력
	public List<CommentVO> getCommentList (int board_no);
	
	// 특정 게시글 번호로 객체 반환
	public CommentVO selectByNo(int comment_no);
	public String selectLastSequenceNumber(String maxSeqNum, String minSeqNum);
}
