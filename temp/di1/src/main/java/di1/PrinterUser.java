package di1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrinterUser {
	private static Logger logger = LoggerFactory.getLogger(PrinterUser.class);
	// 여기 저기서 재사용 될 녀석(Bean) --> singleton으로 만들어야 하지만 여기서 만들지는 않음
	private Printer printer; // 다른 빈을 할당 - 참조 ref
	private String name; // 스칼라값 - 값 value
	private int age; // 스칼라값
	
	public PrinterUser() {
		logger.trace("user: 기본생성자");
	}
	
	public PrinterUser(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Printer getPrinter() {
		return this.printer;
	}
	
	public PrinterUser(Printer printer) {
		logger.trace("user: {}", printer);
		this.printer = printer;
	}
	
	public void setPrinter(Printer printer) {
		logger.trace("user: {}", printer);
		this.printer = printer;
	}
	
	public void usePrint() {
		printer.print("Hello");
	}
}
