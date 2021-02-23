package com.ncs.noti.member.DAO;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ncs.noti.member.VO.LocVO;
import com.ncs.noti.member.VO.LoginVO;
import com.ncs.noti.member.VO.MemberVO;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO{

	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public MemberVO idCheck(MemberVO vo) {
		System.out.println("===> MemberMapper idCheck 호출");
		return mybatis.selectOne("user.idCheck", vo);
	}

	@Override
	public int memberInsert(MemberVO vo) {
		System.out.println("===>  MemberMapper userInsert() 호출");
		return mybatis.insert("user.userInsert", vo);
	}

	@Override
	public MemberVO memberLogin(MemberVO vo) {
		System.out.println("===> MemberMapper idCheck 호출");
		return (MemberVO) mybatis.selectOne("user.idCheck", vo);
	}

	public List<LocVO> locSelect() {
		System.out.println("===> MemberMapper locSelect 호출");
		return mybatis.selectList("user.catselect");
	}
	
	public MemberVO checkIn(LoginVO vo) {
		System.out.println("==>로그인 시도합니다");
		return mybatis.selectOne("user.checkIn",vo);
	}
	
	public int memberUpdate(MemberVO vo) {
		System.out.println("회원정보 수정하겠슴당");
		return mybatis.update("user.userUpdate",vo);
	}
	public int mileageSelect(String vo) {
		System.out.println("마일리지 출력");
		return mybatis.selectOne("user.mileageSelect", vo);
	}

}
