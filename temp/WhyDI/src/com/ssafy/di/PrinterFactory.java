package com.ssafy.di;

public class PrinterFactory {
	// factory method design pattern => 의존성을 없애는 방법
	public static Printer getPrinter(String type) {
		if(type.equals("hp")) {
			return new HPPrinter();
		} else {
			return new SamsungPrinter();
		}
	}
}
