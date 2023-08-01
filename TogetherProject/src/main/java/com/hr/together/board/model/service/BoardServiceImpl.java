package com.hr.together.board.model.service;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hr.together.board.model.dao.BoardDao;

@Service
public class BoardServiceImpl implements BoardService {

	private Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	private BoardDao boardDao;
	private SqlSession sqlSession;

}
