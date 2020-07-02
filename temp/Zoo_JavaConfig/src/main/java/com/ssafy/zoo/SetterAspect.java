package com.ssafy.zoo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect // 여기는 하나 이상의 pointcut과 advice가 있다!
public class SetterAspect {
	
	// advice 종류(pointcut: 대상 설정)
	@Before("execution(void set*(..))") // void를 리턴하고 set으로 시작하는 메서드, 파라미터는 무관
	public void logging(JoinPoint jp) { // 횡단 관심사 (advice)
		System.out.println("속성 변경 중..." + jp.getSignature());
	}
}
