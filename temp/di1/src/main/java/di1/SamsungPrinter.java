package di1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SamsungPrinter implements Printer {
	private static Logger logger = LoggerFactory.getLogger(SamsungPrinter.class);
	// 여기 저기서 재사용 될 녀석(Bean) --> singleton으로 만들어야 하지만 여기서 만들지는 않음
	
	public SamsungPrinter() {
		logger.trace("samsung create..");
	}
	
	@Override
	public void print(String msg) {
		System.out.println("Samsung: " + msg);
	}
}
