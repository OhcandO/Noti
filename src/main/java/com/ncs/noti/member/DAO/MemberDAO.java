package com.ncs.noti.member.DAO;

import com.ncs.noti.member.VO.MemberVO;

public interface MemberDAO {
	/**
	 * id 중복체트 기능 구현
	 */	
	MemberVO  idCheck( MemberVO vo );
	
	/**
	 * 회원가입기능 구현
	 */
	int memberInsert(MemberVO vo);
	
	/**
	 * 로그인 확인 기능 구현
	 */
	MemberVO memberLogin(MemberVO vo);
	/**
	 * 회원정보 및 수정
	 */
	int memberUpdate(MemberVO vo);
	
}
