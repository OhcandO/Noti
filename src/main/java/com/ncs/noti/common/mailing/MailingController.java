package com.ncs.noti.common.mailing;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ncs.noti.member.VO.MemberVO;

@Controller
@EnableAsync
@RequestMapping("/mail/")
public class MailingController {

	@Autowired
	private MailingService mailingService;
	
	//주간 노티 발송 서비스
	@RequestMapping("weekly.do")
	public String mailingWeeklyNoti (MemberVO vo, HttpSession session) {
		
		
		if (session!=null) {
			System.out.println("메일링 컨트롤러 컨너가는 중"+session.getAttribute("login"));
			vo = (MemberVO)session.getAttribute("login");
			
			mailingService.weeklyMail(vo);
			
		}else {return "redirect:/";}
		
		return "redirect:/";
	}
}
