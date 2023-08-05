package com.hr.together.member.model.service;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hr.together.member.model.dao.MemberDao;
import com.hr.together.member.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService {

	private Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	private MemberDao memberDao;
	private SqlSession sqlSession;

	
	@Override
	public Member selectMemberViewByLogin(Member member) throws Exception {
		return memberDao.selectMemberViewByLogin(sqlSession, member);
	}
}
