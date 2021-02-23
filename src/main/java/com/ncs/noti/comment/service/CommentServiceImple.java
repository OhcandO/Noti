package com.ncs.noti.comment.service;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.noti.comment.DAO.CommentDAOImpl;
import com.ncs.noti.comment.VO.CommentVO;

@Service("CommentService")
public class CommentServiceImple implements CommentService{

	@Autowired
	private CommentDAOImpl commentDAO;
	
	@Override
	public int insertComment(CommentVO vo) {
		// 그룹번호 지정
		int groupId = commentDAO.getGroupId();
		vo.setComment_groupid(groupId);
		System.out.println("==============댓글을 작성하는 서비스 호출");
		// 순서번호(sequence_no) 지정...3수준
		DecimalFormat dformat = new DecimalFormat("0000000000");
		vo.setComment_seq(dformat.format(groupId) + "999999");
		
		return commentDAO.insertComment(vo);
	}

	@Override
	public int deleteComment(int Comment_no) {
		// 
		System.out.println("댓글 삭제 서비스 호출");
		return commentDAO.deleteComment(Comment_no);
	}

	@Override
	public int updateComment(CommentVO vo) {
		// TODO 업데이트 할 때 원래 comment_no(PK) 정보를 가지고 수정된 부분만 달라지도록 유의
		return commentDAO.updateComment(vo);
	}

/**--------[시]-----------대댓글 서비스 부분-----------[작]-------------*/
	@Override
	public int replyComment(int parent_comment_no, CommentVO vo){
		// 부모 댓글의 객체 가져옴
		CommentVO parent = commentDAO.selectById(parent_comment_no);
		
		// 부모 댓글의 레벨을 반환
		checkParent(parent, parent_comment_no);
		
		// 대댓글에 순서번호 작성
		String maxSeqNum = parent.getComment_seq();
		String minSeqNum = getSearchMinSeqNum( parent );
		
		System.out.println("maxSeqNum = "+maxSeqNum);
		System.out.println("minSeqNum = "+minSeqNum);
		
		String lastChildSeq =null;
		lastChildSeq = commentDAO.selectLastSequenceNumber( maxSeqNum, minSeqNum );
		
		System.out.println("lastChildSeq = "+ lastChildSeq);
		
		String sequenceNumber = getSequenceNumber( parent,lastChildSeq);
		
		
		vo.setComment_groupid(parent.getComment_groupid()); // 부모의 그룹번호와 동일하게 지정
		vo.setComment_seq(sequenceNumber);	 // 위에서 구한 답변글의 순서번호 지정
//		vo.setPostingDate( (new Date()).toString());	 // 등록일
		
		return commentDAO.insertComment(vo);
		
	}

	/*
	 * 부모글이 존재하는지 부모글이 마지막 3단계인지 확인하는 함수
	 */
	private void checkParent( CommentVO parent, int parent_no ) 
	{
		if( parent == null ) {
			System.out.println("부모글이 존재하지 않음 : " + parent_no );
			return;
		}
		int parentLevel = parent.getLevel();
		if( parentLevel == 3 ) {
			System.out.println("3단계 마지막 레벨 글에는 답변을 달 수 없습니다.");
			return;
		}
	}
	
	private String getSearchMinSeqNum( CommentVO parent )
	{
		String parentSeqNum = parent.getComment_seq();
		DecimalFormat dFormat = new DecimalFormat("0000000000000000");
		long parentSeqLongValue = Long.parseLong(parentSeqNum);
		long searchMinLongValue = 0;
		
		switch( parent.getLevel())
		{
		case 0 : searchMinLongValue = parentSeqLongValue / 1000000L * 1000000L; break;
		case 1 : searchMinLongValue = parentSeqLongValue / 10000L * 10000L; break;
		case 2 : searchMinLongValue = parentSeqLongValue / 100L * 100L; break;
		}
		return dFormat.format(searchMinLongValue);
	}
	
	
	private String getSequenceNumber( CommentVO parent, String lastChildSeq ) 
	{
		long parentSeqLong	= Long.parseLong( parent.getComment_seq());
		int  parentLevel	= parent.getLevel();
		
		long decUnit = 0;
		if		( parentLevel == 0 ){	decUnit = 10000L;	}
		else if	( parentLevel == 1 ){	decUnit = 100L;		}
		else if ( parentLevel == 2 ){	decUnit = 1L;		}
		
		String sequenceNumber = null;
		
		DecimalFormat dFormat = new DecimalFormat("0000000000000000");
		if( lastChildSeq == null ){			// 답변글이 없다면
			sequenceNumber = dFormat.format(parentSeqLong-decUnit);
		} else {							// 답변글이 있다면, 마지막 답변글인지 확인
			String orderOfLastChildSeq = null;
			if( parentLevel == 0 ){
				orderOfLastChildSeq = lastChildSeq.substring(10,12);
				sequenceNumber = lastChildSeq.substring(0, 12) + "9999";
			}else if( parentLevel == 1 ){
				orderOfLastChildSeq = lastChildSeq.substring(12,14);
				sequenceNumber = lastChildSeq.substring(0, 14) + "99";				
			}else if( parentLevel == 2 ){
				orderOfLastChildSeq = lastChildSeq.substring(14,16);
				sequenceNumber = lastChildSeq;			
			}
			
			if( orderOfLastChildSeq.equals("00")){
				System.out.println("마지막 자식 글이 이미 존재합니다.");
				return sequenceNumber;
			}
			
			long seq = Long.parseLong(sequenceNumber) - decUnit;
			sequenceNumber = dFormat.format(seq);
			
			return sequenceNumber; 
		}
		return sequenceNumber;
		
	}
	
/**--------[끝]-----------대댓글 서비스 부분-----------[끝]-------------*/
	
	
	@Override
	public List<CommentVO> getCommentList(int board_no) {
		// TODO 참고! 댓글 페이징을 위해서는 4_boardclass / ListMessageService.java 참조할 것
		return commentDAO.getCommentList(board_no);
	}

	@Override
	public CommentVO selectByNo(int comment_no) {
		// 부모 댓글의 정보들을 알아내기위해 작성
		return commentDAO.selectById(comment_no);
	}

	@Override
	public String selectLastSequenceNumber(String maxSeqNum, String minSeqNum) {
		// 대댓글 시퀀스 넘버 작성하기 위해 쿼리
		return commentDAO.selectLastSequenceNumber(maxSeqNum, minSeqNum);
	}

	
}
