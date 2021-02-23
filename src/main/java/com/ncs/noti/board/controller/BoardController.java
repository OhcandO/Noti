package com.ncs.noti.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ncs.noti.board.VO.BoardVO;
import com.ncs.noti.board.VO.Criteria;
import com.ncs.noti.board.VO.PageMaker;
import com.ncs.noti.board.VO.infoBoardVO;
import com.ncs.noti.board.VO.likeInfoVO;
import com.ncs.noti.board.VO.likeUserVO;
import com.ncs.noti.board.service.BoardService;
import com.ncs.noti.board.service.infoBoardService;
import com.ncs.noti.member.VO.MemberVO;

//NOTI
@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

	@Autowired
	private infoBoardService infoboardService;

	@RequestMapping("/{step}.do")
	public String viewPage(@PathVariable String step) {
		return step;
	}

	// 글 목록 검색
	@RequestMapping(value = "/getBoardList", method = RequestMethod.GET)
	public String getBoardList(Model model, Criteria cri) throws Exception {

		model.addAttribute("getBoardList", boardService.getBoardList(cri));

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(boardService.listCount());

		model.addAttribute("pageMaker", pageMaker);

		return "/getBoardList";
	}

	// 해당 아이디가 작성한 글 보기
	@RequestMapping("/getUserIdBoard.do")
	public void getUserIdBoard(BoardVO vo, Model model) {
		model.addAttribute("userIdBoard", boardService.getUserIdBoard(vo));
		// return "views/getUserIdBoard.jsp";
	}

	/*
	 * // 좋아요 누른 게시글
	 * 
	 * @RequestMapping(value="/likeUserList", method=RequestMethod.GET) public
	 * String getLikeUserList(Criteria cri, Model model) throws Exception {
	 * 
	 * model.addAttribute("likeUserList", boardService.likeUserList(cri));
	 * 
	 * PageMaker pageMaker = new PageMaker(); pageMaker.setCri(cri);
	 * pageMaker.setTotalCount(boardService.listCount());
	 * 
	 * model.addAttribute("pageMaker", pageMaker); // ViewResolver를 지정하지 않으면 아래처럼
	 * 페이지명 지정 return "/likeBoardList"; // View 이름 리턴 }
	 */
	
	// 회원이 좋아요 누른 게시글(자유게시판)
	   @RequestMapping(value="/likeUserList", method=RequestMethod.GET)
	   public String getLikeUserList(Criteria cri, Model model,HttpSession session) throws Exception {
	      //System.out.println(vo.getUser_id());
	      String userid = ((MemberVO)session.getAttribute("login")).getUser_id();
	      cri.setUser_id(userid);
	      System.out.println(cri.getUser_id());
	      
	      model.addAttribute("likeUserList", boardService.likeUserList(cri));
	      PageMaker pageMaker = new PageMaker();
	      pageMaker.setCri(cri);
	      pageMaker.setTotalCount(boardService.listCount());
	      
	      model.addAttribute("pageMaker", pageMaker);
	      // ViewResolver를 지정하지 않으면 아래처럼 페이지명 지정
	      return "/likeBoardList"; // View 이름 리턴
	   }

	////// 정보 목록 검색
	@RequestMapping(value = "/getinfoBoardList", method = RequestMethod.GET)
	public String getinfoBoardList(Criteria cri, Model model) throws Exception {

		model.addAttribute("getinfoBoardList", infoboardService.getinfoBoardList(cri));

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(infoboardService.listCount());

		model.addAttribute("pageMaker", pageMaker);

		return "/getinfoBoardList";
	}

	// 글 등록
	@RequestMapping(value = "/saveBoard.do")
	public String insertBoard(BoardVO vo) throws IOException {
		boardService.insertBoard(vo);
		return "redirect:/getBoardList.do";
	}

	// 관심있는 게시물 등록
	@RequestMapping(value = "/likeBoard.do")
	public void likeBoard(@ModelAttribute("board") likeUserVO vo) throws IOException {
		boardService.likeBoard(vo);
	}

	// 글 수정
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {
		boardService.updateBoard(vo);
		return "redirect:/getBoardList.do";
	}

	// 글 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		boardService.deleteBoard(vo);
		return "redirect:/getBoardList.do";
	}

	// 글 상세 조회
	@RequestMapping("/getBoard.do")
	public void getBoard(@RequestParam("user_board_no") int boardno, BoardVO vo, Model model, HttpSession session) {
		// Model 정보 저장
		model.addAttribute("board", boardService.getBoard(vo));
		
		if (session.getAttribute("login")!=null) {
			likeUserVO lvo = new likeUserVO(); 
			lvo.setUser_board_no(boardno);
			String userid = ((MemberVO)session.getAttribute("login")).getUser_id();
			lvo.setUser_id(userid);
			int likeCount = boardService.likeBoardCount(lvo); 
			
			model.addAttribute("heart", likeCount);
		}
	}

	// 글 수정
	@RequestMapping("/forUpdateBoard.do")
	public void forUpdateBoard(BoardVO vo, Model model) {
		model.addAttribute("board", boardService.forUpdateBoard(vo)); // Model 정보 저장
	}

//////정보 목록 글 상세 조회
	@RequestMapping("/getinfoBoard.do")
	public void getinfoBoard(@RequestParam("info_board_no") int boardno, infoBoardVO vo, Model model, HttpSession session) {
		model.addAttribute("infoboard", infoboardService.getinfoBoard(vo)); // Model 정보 저장
		if(session.getAttribute("login")!=null) {
		      likeInfoVO lvo = new likeInfoVO(); 
		      lvo.setInfo_board_no(boardno);
		      String userid = ((MemberVO)session.getAttribute("login")).getUser_id();
		      lvo.setUser_id(userid);
		      
		      int likeCount = infoboardService.likeBoardCountInfo(lvo); 
		      
		      model.addAttribute("heartInfo", likeCount);
		      System.out.println(lvo.getInfo_board_no());
		      System.out.println(lvo.getUser_id());
		      }
	}

	@RequestMapping(value = "/")
	// 정보 목록 검색
	public String getminfoBoardList(Model model) {
		List<infoBoardVO> info_board = infoboardService.getinfoBoardList();
		List<BoardVO> user_board = boardService.getBoardList();
		model.addAttribute("infoboardListSize", info_board.size());
		model.addAttribute("boardListSize", user_board.size());
		model.addAttribute("minfoboardList", info_board);
		model.addAttribute("mboardList", user_board);
		// ViewResolver를 지정하지 않으면 아래처럼 페이지명 지정
		return "index"; // View 이름 리턴
	}
	@ResponseBody
	@RequestMapping(value = "/heart", method = RequestMethod.POST, produces = "application/json")
	public int heart(HttpServletRequest httpRequest) throws Exception {
		
		
		 int heart = Integer.parseInt(httpRequest.getParameter("heart")); 
		 int user_board_no = Integer.parseInt(httpRequest.getParameter("user_board_no"));
		 String user_id = httpRequest.getParameter("user_id");
		 System.out.println(user_id);
		 likeUserVO vo = new likeUserVO();
		 vo.setUser_board_no(user_board_no); 
		 vo.setUser_id(user_id);

		 if (heart >= 1) { 
			 boardService.likeBoardDel(vo); 
			 heart -= 1;
		 
		 } else { 
			 boardService.likeBoard(vo); 
			 heart += 1;
		 
		 }
		 System.out.println(heart);
		 return heart;
	}
	// 회원이 좋아요 누른 게시글(정보게시판)
	   @RequestMapping(value="/likeInfoList", method=RequestMethod.GET)
	   public String getLikeInfoList(Criteria cri, Model model,HttpSession session) throws Exception {
	      //System.out.println(vo.getUser_id());
	      String userid = ((MemberVO)session.getAttribute("login")).getUser_id();
	      cri.setUser_id(userid);
	      System.out.println(cri.getUser_id());
	      
	      model.addAttribute("likeInfoList", infoboardService.likeInfoList(cri));
	      PageMaker pageMaker = new PageMaker();
	      pageMaker.setCri(cri);
	      pageMaker.setTotalCount(infoboardService.listCount());
	      
	      model.addAttribute("pageMaker", pageMaker);
	      // ViewResolver를 지정하지 않으면 아래처럼 페이지명 지정
	      return "/likeBoardInfoList"; // View 이름 리턴
	   }

	// 관심있는 게시물 등록(정보)
		@RequestMapping(value = "/likeBoardInfo.do")
		public void likeBoardInfo(@ModelAttribute("boardInfo") likeInfoVO vo) throws IOException {
			infoboardService.likeBoardInfo(vo);
		}
@ResponseBody
	@RequestMapping(value = "/heartInfo", method = RequestMethod.POST, produces = "application/json")
	public int heartInfo(HttpServletRequest httpRequest) throws Exception {
		
		
		 int heart = Integer.parseInt(httpRequest.getParameter("heart")); 
		 int info_board_no = Integer.parseInt(httpRequest.getParameter("info_board_no"));
		 String user_id = httpRequest.getParameter("user_id");
		 System.out.println(user_id);
		 likeInfoVO vo = new likeInfoVO();
		 vo.setInfo_board_no(info_board_no); 
		 vo.setUser_id(user_id);

		 if (heart >= 1) { 
			 infoboardService.likeBoardDelInfo(vo); 
			 heart -= 1;
		 
		 } else { 
			 infoboardService.likeBoardInfo(vo); 
			 heart += 1;
		 
		 }
		 System.out.println(heart);
		 return heart;
	}


}
