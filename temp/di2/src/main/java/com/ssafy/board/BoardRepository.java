package com.ssafy.board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardRepository {
	private static Logger logger = LoggerFactory.getLogger(BoardRepository.class);
	
	MyBatisUtil util;
	
	@Autowired
	public BoardRepository(MyBatisUtil util) {
		this.util = util;
	}
	
	public void insert() {
		logger.trace("repository insert");
	}
}
