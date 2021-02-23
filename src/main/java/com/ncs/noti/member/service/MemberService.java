package com.ncs.noti.member.service;

import java.util.List;

import com.ncs.noti.member.VO.LocVO;
import com.ncs.noti.member.VO.LoginVO;
import com.ncs.noti.member.VO.MemberVO;

public interface MemberService {
	public MemberVO idCheck_Login( MemberVO vo);
	public int userInsert(MemberVO vo );
	public List<LocVO> locSelect();
	public MemberVO checkIn (LoginVO vo);
	public int userUpdate(MemberVO vo);
	public int mileageSelect(String vo);
}
