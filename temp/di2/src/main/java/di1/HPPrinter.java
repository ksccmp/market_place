package di1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class HPPrinter implements Printer {
	private static Logger logger = LoggerFactory.getLogger(HPPrinter.class);
	// 여기 저기서 재사용 될 녀석(Bean) --> singleton으로 만들어야 하지만 여기서 만들지는 않음
	
	public HPPrinter() {
		logger.trace("hp create..");
	}
	
	@Override
	public void print(String msg) {
		System.out.println("HP: " + msg);
	}
}