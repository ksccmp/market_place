package di2.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import di1.PrinterUser;

public class ComponentTest {
	private static Logger logger = LoggerFactory.getLogger(ComponentTest.class);
	ApplicationContext ctx;
	@Before
	public void setup() {
		ctx = new ClassPathXmlApplicationContext("application.xml");
	}
	
	@Test
	public void test() {
		String beans[] = ctx.getBeanDefinitionNames();
		for(String bean : beans) {
			logger.trace("bean: {}", bean); // 빈의 이름은 클래스 첫 글자 소문자, 연속해서 대문자는 그대로 출력
		}
	}
	
	// printerUser를 이용해 usePrinter() 해보자
	@Test
	public void outputtest() {
		PrinterUser user = ctx.getBean(PrinterUser.class);
		assertThat(user, is(notNullValue()));
		user.usePrint();
	}
}
