package com.ncs.noti.comment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ncs.noti.comment.VO.CommentVO;
import com.ncs.noti.comment.service.CommentService;

@Controller
@RequestMapping("/comments/") // 이 컨트롤러는 요청 URL의 도입이 /comment일 때 요청 가르마 타줌
public class CommentController {
	@Autowired
	private CommentService commentService;

	/** 0. 특정 게시글 상세페이지에서 댓글 리스트 불러오기 */
	@RequestMapping(value = "getCommentList.do", method = { RequestMethod.GET })
	@ResponseBody
//	private List<CommentVO> getCommentList(@RequestParam("board_no") int board_no) {
//		System.out.println("댓글 리스트 불러오기 컨드롤러 거치는 중........");
//		return commentService.getCommentList(board_no);
//	}
	private ModelAndView getCommentList(@RequestParam("board_no") int board_no) {
		System.out.println("댓글 리스트 불러오기 컨드롤러 거치는 중........");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/comment/getComment");
		List<CommentVO> comments = commentService.getCommentList(board_no);
		
		mv.addObject("comments", comments);
		mv.addObject("NumberOfComments", comments.size());
		
		return mv;
	}
	

	/** 1. 새 댓글 작성 */
	@RequestMapping(value = "insertComment.do", method = { RequestMethod.POST })
	@ResponseBody
	public int insertComment(CommentVO vo) {
		return commentService.insertComment(vo);
	}

	/** 2. 댓글 수정 */
	@RequestMapping("updateComment")
	@ResponseBody
	private int updateComment(CommentVO vo) {
		System.out.println("댓글 업데이트 컨드롤러 거치는 중........");
		return commentService.updateComment(vo);
	}

	/** 3. 댓글 삭제 */
	@RequestMapping("deleteComment")
	@ResponseBody
	private int deleteComment(int comment_no) {
		System.out.println("댓글 삭........제 컨드롤러 거치는 중........");
		return commentService.deleteComment(comment_no);
	}

	/** 4. 대 댓글 작성 */
	@RequestMapping(value="replyComment", method = RequestMethod.GET)
	@ResponseBody
	private int replyComment(CommentVO vo, int parent_comment_no) {
		System.out.println("과연....대댓이 성공할 것인지.....");
		System.out.println("parent_comment_no"+parent_comment_no);
		
		return commentService.replyComment(parent_comment_no, vo);
	}
	
	/** 5. 댓글 추천 */

	/** 6. 댓글 신고 */

}
