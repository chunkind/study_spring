package kosta.aop;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
/*
 * Log 파일에 족적을 남기는 어드바이스.. Around 방식
 */
@Aspect
public class LoggingAdvice {
	BufferedWriter bw;
	@Around("execution(public * kosta.product..*.*(..))")
	public Object arround(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.currentTimeMillis();
		String methodName = pjp.getSignature().getName();
		DateFormat f = DateFormat.getInstance();
		logging("[" + methodName + "] 메소드 호출 : " + f.format(new Date(start)) + "시작됨..");
		
		Object obj = pjp.proceed();	//이때 target이 호출..
		
		long end = System.currentTimeMillis();
		logging("[" + methodName + "] 메소드 호출 : " + f.format(new Date(start)) + "종료됨..");
		logging("[" + methodName + "] 메소드 실행소요시간 : " + (end-start)/1000 + "종료됨..");
		
		return obj;
	}
	//log4J 파일의 느낌이 나도록 로직을 별도록 만들어 보자..
	private void logging(String message) {
		try{
			bw = new BufferedWriter(new FileWriter("src/kosta/test/main/LogginAdvice.txt",true));
			bw.flush();
			bw.write(message);
			bw.newLine();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
