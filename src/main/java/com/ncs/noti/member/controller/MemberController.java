package com.ncs.noti.member.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ncs.noti.common.mailing.MailingService;
import com.ncs.noti.member.VO.LocVO;
import com.ncs.noti.member.VO.LoginVO;
import com.ncs.noti.member.VO.MemberVO;
import com.ncs.noti.member.service.MemberService;

@Controller
@EnableAsync
//@RequestMapping("/user/") // 이 컨트롤러는 user 폴더 밑에서 가져옴
public class MemberController {

	@RequestMapping("/user/userLogin.do")
	public void url(HttpServletRequest request, HttpSession session) {
//		로그인 넘어오기 직전의 페이지 주소를 세션에 저장함
		String prev = request.getHeader("referer");
		session.setAttribute("prevPage", prev);
		System.out.println("요청");
	}
	// 3. 매번 이런식으로 매핑만 하는 경우라면
//	@RequestMapping(value = "{url}.do")
//	public String url(@PathVariable String url) {
//		System.out.println("요청");
//		return "/user/" + url;
//	}

	// --------------------------------------------------------
	@Autowired 
	private MemberService memberService;
	// private LocService locservice;
	
	@Autowired //메일 발송을 위한 서비스단
	private MailingService mailingService;
	
	/*** 회원가입 */
	@RequestMapping("/user//userInsert.do")
	public ModelAndView userInsert(MemberVO memberVo) {
		int result = memberService.userInsert(memberVo);
		
		String message = "가입되지 않았습니다";
		if (result > 0) {
			message = memberVo.getUser_name() + "님, 가입을 축하드립니다.";
			//  회원 가입 성공시 이메일 발송
			mailingService.welcomeMail(memberVo);
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/userJoin_ok");
		mv.addObject("message", message);
		mv.addObject("result", result);
		return mv;
	}

	/** 로그인 */
	@RequestMapping("/user/login.do")
	public String login(LoginVO loginVO, HttpSession session) { // #4. 세션
		// #2. DB 연결되는지 확인 - 에러없이 페이지 전환

		MemberVO vo = memberService.checkIn(loginVO);
		String path = "redirect:/";
		
		if(session.getAttribute("prevPage")!=null) {
			String index = "/noti/";
			String url = (String)session.getAttribute("prevPage");
			int ind = url.indexOf(index);

			System.out.println("url = " + url);
			System.out.println("index = " + index);
			System.out.println("indexOf..url = " + ind);
			System.out.println("fixed url : "+ url.substring(ind + 6));
			path += url.substring(ind + 6);

		}
		// 세션의 login 에 할당된 값(memberVO)이 있다면 없애기
		if (session.getAttribute("login") != null) {
			session.removeAttribute("login");
			session.removeAttribute("loginTime");
//			session.removeAttribute("user_name");
		}

		if (vo != null) {
			// 로그인에 성공했다면 세션에 login 이라는 이름으로 VO 객체 저장
			Date date = new Date();
			session.setAttribute("login", vo);
			session.setAttribute("loginTime", date);
//			session.setAttribute("user_name", vo.getUser_name());
			
//			path = (String)session.getAttribute("prevPage");
			
//			return "user/login_ok";
			return path;

		} else {
			return "redirect:/user/userLogin";
		}
	}

	/** 로그아웃쓰 */
	@RequestMapping("/user/logOut.do")
	public String logout(HttpSession session) {
		// 세션 초기화.. 컨트롤러 단에서 할 것인지 연결된 view 단에서 할 것인지
		session.invalidate();
		return "redirect:/";
	}

	/*** 지역넣기 */
	@RequestMapping("/user/userJoin.do")
	public ModelAndView locInsert() {
		// List <LocVO> loc= locservice.locInsert();
		List<LocVO> loc = memberService.locSelect();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/userJoin");
		mv.addObject("result", loc);
		return mv;
	}

	/**
	 * 아이디 중복 체크
	 */
	@RequestMapping(value = "/user/idCheck.do", produces = "application/text; charset=utf8")
	// 화면에서 보낸 결과 한글 깨짐 해결 -> produces = "application/text; charset=utf8"
	@ResponseBody // --> 이것으로 비동기화 통신을을 함 ( 페이지전환되지 않도록)
	public String idCheck(MemberVO vo) // 인자로 사용자아이디(String)만 받아도 된다
	{

		// 컨트롤러에서는 디비 연동을 하지 않고 연결만 하기에 모델(Business Login) DAO을 호출

		MemberVO memberVo = memberService.idCheck_Login(vo);
		String result = "ID 사용가능합니다.";
		if (memberVo != null)
			result = "중복된 아이디입니다.";
		return result;
	}

	/**
	 * 회원 정보 및 수정
	 */
	/*
	 * @RequestMapping(value= "/userUpdate.do", method=RequestMethod.GET) public
	 * String Mypage()throws Exception{ return "user/Mypage"; }
	 * 
	 * @RequestMapping public String userUpdate(MemberVO vo,HttpSession session) {
	 * 
	 * memberService.userUpdate(vo);
	 * 
	 * session.invalidate();
	 * 
	 * return "redirect:/"; }
	 */

	@RequestMapping(value="/user/MyPage.do")
	public void myPage(Model model,HttpSession session) {
		MemberVO vo = null;
		vo = (MemberVO)session.getAttribute("login");
		String message="변경되지 않았습니다";
		if(vo != null)
		{
			int result = memberService.userUpdate(vo);
			message=vo.getUser_name()+"님,변경되었습니다.";
		}		
		System.out.print(message);
		List<LocVO> loc = memberService.locSelect();
		int mileage=memberService.mileageSelect(vo.getUser_id());
		model.addAttribute("message",message);
		model.addAttribute("result", loc);
		model.addAttribute("mileage", mileage);
		  
}

	@RequestMapping(value = "/user/userUpdate.do")
	public ModelAndView userUpdate(MemberVO vo, HttpSession session) {
		int result = memberService.userUpdate(vo);

		String message = "변경되지 않았습니다";
		if (result > 0)
			message = vo.getUser_name() + "님,변경되었습니다.";
		System.out.println(vo.getUser_id());
		System.out.print(message);

		List<LocVO> loc = memberService.locSelect();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/userUpdate");
		mv.addObject("message", message);
		mv.addObject("result", loc);
		return mv;

	}

}