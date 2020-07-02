package com.ssafy.board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
	private static Logger logger = LoggerFactory.getLogger(BoardService.class);
	
	BoardRepository repo;
	
	@Autowired // 필드에 할당하는 것은 가급적 지양하자. (디버깅 불가)
	public BoardService(BoardRepository repo) {
		this.repo = repo;
	}
	
	public void join() {
		logger.trace("service join");
		repo.insert();
	}
}
