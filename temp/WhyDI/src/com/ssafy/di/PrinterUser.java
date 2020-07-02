package com.ssafy.di;

public class PrinterUser {
	// HP --> Samsung으로 바뀐다면?
	// 참조하는 객체의 변경에 따라 내가 바뀌는 것을 의존한다라고 하고
	// 이떄 HPPrinter를 의존성이라고 한다.
	// 우리의 목적은 의존성 줄이기...
	public PrinterUser(String type) {
		hp = PrinterFactory.getPrinter(type);
	}
	
	Printer hp = null;
	public void use() {
		hp.print("Hello");
	}
	
	public static void main(String[] args) {
		PrinterUser user = new PrinterUser("samsung");
		user.use();
	}
}
