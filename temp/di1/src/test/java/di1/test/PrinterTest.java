package di1.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import di1.Printer;
import di1.PrinterUser;

public class PrinterTest {
	private static Logger logger = LoggerFactory.getLogger(PrinterTest.class);
	ApplicationContext ctx;
	@Before
	public void setup() {
		// 컨테이너 생성
		ctx = new ClassPathXmlApplicationContext("application.xml");
	}

	@Test
	public void testCtx() {
		assertThat(ctx, is(notNullValue()));
		String beans[] = ctx.getBeanDefinitionNames();
		for(String bean: beans) {
			logger.trace("bean: {}", bean);
		}
	}
	
	@Test
	public void useBean() {
		// Printer printer = ctx.getBean(Printer.class); -> 실패 // 빈을 찾을 때 타입 기반으로 찾는군!!
		// Printer printer = ctx.getBean("hp", Printer.class);
		Object obj = ctx.getBean("hp"); // 이름 기반으로 빈 검색 후 사용
		Printer printer = (Printer)obj;
		logger.trace("printer: {}", printer);
		
		Printer printer2 = ctx.getBean("hp", Printer.class);
		assertThat(printer, is(printer2)); // 싱글턴패턴 확인
		
		// PrinterUser빈과 ss빈을 가져와보세요.
		PrinterUser user = ctx.getBean(PrinterUser.class);
		Printer printer3 = ctx.getBean("ss", Printer.class);
		
		// PrinterUser가 가진 printer는 ss와 같을까요?
		assertThat(user.getPrinter(), is(printer3)); // 싱글턴패턴 확인
	}
}
