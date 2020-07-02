package zoo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Zoo {
	private static Logger logger = LoggerFactory.getLogger(Zoo.class);
	private String address;
	private Tiger tiger;
	private Lion lion;
	
	public Zoo(String address) {
		logger.trace("zoo 선택");
		this.address = address;
	}

	public Tiger getTiger() {
		return tiger;
	}

	public void setTiger(Tiger tiger) {
		this.tiger = tiger;
	}

	public Lion getLion() {
		return lion;
	}

	public void setLion(Lion lion) {
		this.lion = lion;
	}

	@Override
	public String toString() {
		return "Zoo [address=" + address + ", tiger=" + tiger + ", lion=" + lion + "]";
	}
}
