package zoo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Zoo {
	private static Logger logger = LoggerFactory.getLogger(Zoo.class);
	private String address;
	private Tiger tiger;
	private Lion lion;
	
	@Autowired
	public Zoo(@Value("${zooTitle}") String address) {
		logger.trace("zoo 선택");
		this.address = address;
	}

	public Tiger getTiger() {
		return tiger;
	}

	@Autowired
	public void setTiger(Tiger tiger) {
		this.tiger = tiger;
	}

	public Lion getLion() {
		return lion;
	}

	@Autowired
	public void setLion(Lion lion) {
		this.lion = lion;
	}

	@Override
	public String toString() {
		return "Zoo [address=" + address + ", tiger=" + tiger + ", lion=" + lion + "]";
	}
}
