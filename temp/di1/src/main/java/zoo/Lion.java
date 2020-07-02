package zoo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lion implements Animal {
	private static Logger logger = LoggerFactory.getLogger(Lion.class);
	private String name;
	
	public Lion(String name) {
		logger.trace("lion 선택");
		this.name = name;
	} 
	
	@Override
	public String toString() {
		return "Lion [name=" + name + "]";
	}
	
	@Override
	public void scream(String msg) {
		System.out.println(name + "이 우는방법: "+ msg);
	}
}
