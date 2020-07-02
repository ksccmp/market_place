package di1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PrinterUser {
	private static Logger logger = LoggerFactory.getLogger(PrinterUser.class);
	// 여기 저기서 재사용 될 녀석(Bean) --> singleton으로 만들어야 하지만 여기서 만들지는 않음
	private Printer printer; // 다른 빈을 할당 - 참조 ref
	private String name; // 스칼라값 - 값 value
	private int age; // 스칼라값
	
	public PrinterUser() {
		logger.trace("user: 기본생성자");
	}
	
	@Autowired // 자동으로 Printer 타입의 빈을 찾아서 연결
	public PrinterUser(@Qualifier(value="samsungPrinter") Printer printer) { // 연결할 빈의 아이디 지정, value는 빈의 이름 (생성자에는 지정 불가)
		logger.trace("user: {}", printer);
		this.printer = printer;
	}
	
	public PrinterUser(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	@Value(value="홍길동")
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	@Value(value="100")
	public void setAge(int age) {
		this.age = age;
	}

	public Printer getPrinter() {
		return this.printer;
	}
	
	@Autowired
	@Qualifier(value="samsungPrinter")
	public void setPrinter(Printer printer) {
		logger.trace("user: {}", printer);
		this.printer = printer;
	}
	
	public void usePrint() {
		printer.print("Hello");
	}
}
