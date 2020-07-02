package com.ssafy.board;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MyBatisUtil {
	private static Logger logger = LoggerFactory.getLogger(MyBatisUtil.class);
	
	// 빈이 생성되고 아직 사용되기 전 이 메서드를 호출했으면 좋겠다.
	@PostConstruct // 파라미터가 없는 메서드
	public void setup() {
		logger.trace("mybatis util is ready...");
	}
	
	@Autowired
	public MyBatisUtil(@Value("${url}") String url, 
							@Value("${driver}") String driver, 
							@Value("${username}") String user, 
							@Value("${password}") String pass) {
		logger.trace("url:{}, driver:{}, user:{}, pass:{}", url, driver, user, pass);
	}
}
