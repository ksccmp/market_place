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

import zoo.Zoo;

public class ZooTest {
	private static Logger logger = LoggerFactory.getLogger(ZooTest.class);
	ApplicationContext ctx;
	
	@Before
	public void setup() {
		ctx = new ClassPathXmlApplicationContext("zooapplication.xml");
	}

	@Test
	public void test() {
		Zoo zoo = ctx.getBean(Zoo.class);
		assertThat(zoo, is(notNullValue()));
		logger.trace("zoo: {}", zoo);
		
		String beans[] = ctx.getBeanDefinitionNames();
		for(String bean : beans) {
			System.out.println(bean);
		}
	}
}
