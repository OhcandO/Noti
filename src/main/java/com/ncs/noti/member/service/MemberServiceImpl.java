package com.ncs.noti.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.noti.member.DAO.MemberDAOImpl;
import com.ncs.noti.member.VO.LocVO;
import com.ncs.noti.member.VO.LoginVO;
import com.ncs.noti.member.VO.MemberVO;


@Service("memberService")
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAOImpl memberDAO;
	
	
	/**
	  * 아이디 중복 체크하는 sql + 로그인 기능 sql
	  */
	  public MemberVO idCheck_Login( MemberVO vo)
	  {
		  return memberDAO.idCheck(vo);
	  }
	  
	  /**
	   * 찐찐 로그인 용
	   */
	  public MemberVO checkIn (LoginVO vo) {
		  return memberDAO.checkIn(vo);
	  }
	  
	  
	  /**
	   * 회원가입 sql
	   */
	   public int userInsert(MemberVO vo )
	   {
		  return memberDAO.memberInsert(vo);
	   }
	   
	   /**
	    * locSelect 불러오기
	    */
	
	   public List<LocVO> locSelect()
	   {
		   return memberDAO.locSelect();
	   }
	   @Override
		public int mileageSelect(String vo) {
			// TODO Auto-generated method stub
			return memberDAO.mileageSelect(vo);
		}
	@Override
	public int userUpdate(MemberVO vo) {
		// TODO Auto-generated method stub
		return memberDAO.memberUpdate(vo);
	}
}
