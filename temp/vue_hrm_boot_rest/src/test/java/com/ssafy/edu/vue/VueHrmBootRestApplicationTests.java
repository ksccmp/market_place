package com.ssafy.edu.vue;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class) // runwith 대체
@SpringBootTest // contextconfiguration 대체
class VueHrmBootRestApplicationTests {
	@Autowired
	SqlSession session;

	@Test
	void testSession() {
		assertThat(session).isNotNull();
	}

}
