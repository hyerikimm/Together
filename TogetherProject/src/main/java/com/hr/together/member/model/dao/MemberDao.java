package com.hr.together.member.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.hr.together.member.model.vo.Member;

@Repository
public class MemberDao {

	private Logger logger = LoggerFactory.getLogger(MemberDao.class);

	public Member selectMemberViewByLogin(SqlSession sqlSession, Member member) {
		return sqlSession.selectOne("memberMapper.selectMemberViewByLogin", member);
	}
	
}
