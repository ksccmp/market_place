package di1.test;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PrinterTest2 {
	// application.xml을 이용해서 SpringContext를 동작시키고 빈 생성 확인
	ApplicationContext ctx;
	private static Logger logger = LoggerFactory.getLogger(PrinterTest2.class);
	
	@Before
	public void setup() {
		ctx = new ClassPathXmlApplicationContext("application2.xml");
	}
	
	@Test
	public void testCtx() {
		assertThat(ctx, notNullValue());
		String beans[] = ctx.getBeanDefinitionNames();
		for(int i=0; i<beans.length; i++) {
			logger.trace(beans[i]);
		}
	}
}