package zoo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Tiger implements Animal {
	private static Logger logger = LoggerFactory.getLogger(Tiger.class);
	private String name;
	
	@Autowired
	public Tiger(@Value("${tigerName}") String name) {
		logger.trace("Tiger 선택");
		this.name = name;
	}

	@Override
	public String toString() {
		return "Tiger [name=" + name + "]";
	}

	@Override
	public void scream(String msg) {
		System.out.println(name + "이 우는방법: "+ msg);
	}
}
