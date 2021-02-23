package com.ncs.noti.total.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ncs.noti.board.VO.BoardVO;
import com.ncs.noti.board.VO.infoBoardVO;
import com.ncs.noti.board.service.BoardService;
import com.ncs.noti.board.service.infoBoardService;
import com.ncs.noti.member.VO.MemberVO;
import com.ncs.noti.total.Service.SearchTextService;
import com.ncs.noti.total.VO.SearchTextVO;

//NOTI
@Controller
public class totalSearchController {
	@Autowired
	private BoardService boardService;
	@Autowired
	private infoBoardService infoboardService;
	@Autowired
	private SearchTextService searchtextService;

	@RequestMapping(value = "/getTotalSearch.do", produces = "application/text; charset=utf8", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView getTotalSearch(String searchText, HttpSession session) {
		System.out.println(searchText);
		
		// 로그인한 상태라면 검색기록에 회원 아이디도 추가함.. 테이블 상 default는 null 임.
		String text_user_id ="";
		if(session != null) {
			text_user_id=((MemberVO)session.getAttribute("login")).getUser_id();
		}
		
		SearchTextVO vo = new SearchTextVO();
		vo.setText(searchText);
		vo.setText_user_id(text_user_id);
		
		int re = searchtextService.inserttext(vo);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("getTotalSearch");
		List<infoBoardVO> info_board = infoboardService.getinfoBoardList(searchText);
		List<BoardVO> user_board = boardService.getBoardList(searchText);
		mv.addObject("searchText", searchText);
		mv.addObject("infoboardListSize", info_board.size());
		mv.addObject("boardListSize", user_board.size());
		mv.addObject("infoboardList", info_board);
		mv.addObject("boardList", user_board);
		return mv;
	}

	// 일-주-월간 인기검색어 
	@RequestMapping(value = "/getTopSearch")
	public void getTopSearchday(SearchTextVO vo, Model model) {
		model.addAttribute("getTopSearchday", searchtextService.getTopSearchday(vo));
		model.addAttribute("getTopSearchweek", searchtextService.getTopSearchweek(vo));
		model.addAttribute("getTopSearchmonth", searchtextService.getTopSearchmonth(vo));
	}

}
