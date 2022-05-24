package com.project.trip.member.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.trip.buy.vo.BookViewVO;
import com.project.trip.member.vo.MemberVO;
import com.project.trip.member.vo.TempMemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public void join(MemberVO memberVO) {
		sqlSession.insert("memberMapper.join", memberVO);
	}

	@Override
	public MemberVO login(MemberVO memberVO) {
		return sqlSession.selectOne("memberMapper.login", memberVO);
	}

	@Override
	public String selectId(MemberVO memberVO) {
		return sqlSession.selectOne("memberMapper.selectId", memberVO);
	}
	
	@Override
	public MemberVO selectTell(MemberVO memberVO) {
		return sqlSession.selectOne("memberMapper.selectTell", memberVO);
	}

	@Override
	public TempMemberVO tempLogin(TempMemberVO tempMemberVO) {
		return sqlSession.selectOne("memberMapper.tempLogin", tempMemberVO);
	}

	@Override
	public MemberVO findId(MemberVO memberVO) {
		return sqlSession.selectOne("memberMapper.findId", memberVO);
	}

	@Override
	public List<String> selectName(MemberVO memberVO) {
		return sqlSession.selectList("memberMapper.selectName", memberVO);
	}

	@Override
	public MemberVO findPw(MemberVO memberVO) {
		return sqlSession.selectOne("memberMapper.findPw", memberVO);
	}

	@Override
	public void changePw(MemberVO memberVO) {
		sqlSession.update("memberMapper.changePw", memberVO);
	}

	@Override
	public void changeMemberInfo(MemberVO memberVO) {
		sqlSession.update("memberMapper.changeMemberInfo", memberVO);
	}

	@Override
	public void deactivateMember(MemberVO memberVO) {
		sqlSession.update("memberMapper.deactivateMember", memberVO);
	}

	@Override
	public MemberVO findDeactivateMember(MemberVO memberVO) {
		return sqlSession.selectOne("memberMapper.findDeactivateMember", memberVO);
	}

	@Override
	public MemberVO selectMemberInfo(MemberVO memberVO) {
		return sqlSession.selectOne("memberMapper.selectMemberInfo", memberVO);
	}

	@Override
	public List<BookViewVO> selectBookList(String memId) {
		return sqlSession.selectList("memberMapper.selectBookList", memId);
	}

	@Override
	public TempMemberVO selectTempMember(TempMemberVO tempMemberVO) {
		return sqlSession.selectOne("memberMapper.selectTempMember", tempMemberVO);
	}

	@Override
	public int findTempMember(TempMemberVO tempMemberVO) {
		return sqlSession.selectOne("memberMapper.findTempMember", tempMemberVO);
	}

	
}
