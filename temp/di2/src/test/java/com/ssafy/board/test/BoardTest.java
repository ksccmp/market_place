package com.ssafy.board.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.ssafy.board.BoardService;

@RunWith(SpringRunner.class) // 단위테스트에서 @Autowired 사용 가능
@ContextConfiguration("/boardApplication.xml")
public class BoardTest {
	private static Logger logger = LoggerFactory.getLogger(BoardTest.class);

	@Autowired
	BoardService service;
	/*
	 * ApplicationContext ctx;
	 * 
	 * @Before public void setup() { ctx = new
	 * ClassPathXmlApplicationContext("boardApplication.xml"); }
	 */
	@Test
	public void test() {
		/*
		 * MyBatisUtil util = ctx.getBean(MyBatisUtil.class); BoardService service =
		 * ctx.getBean(BoardService.class);
		 */
		service.join();
	}

}

// 주석처리된 곳 => contextconfiguration의 설정으로 필요 x