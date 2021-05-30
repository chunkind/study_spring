package com.aop.advice;

import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;

import com.aop.model.ReportService;
/*
 * 어드바이스 유형 ::
 * pojo
 * around 방식
 * aop 스키마 적용...<aop:config>
 * PointCut...Aspect-J식 ...execution()
 * Target의 find()류 메소드에 위빙
 */
public class ReportAspect {
  private ReportService reportService;

  public void setReportService(ReportService reportService) {
	System.out.println("::"+getClass().getName()+".setReportService() Call...");
	this.reportService = reportService;
  }
  //around 방식은 인자값에 따라
  public Object report(ProceedingJoinPoint pjp)throws Throwable{
	  //선행 메소드 딱히 필요없다...
	  Object retValue;
	  retValue=pjp.proceed(); //target의 find~() 메소드가 이때 호출됨...
	 //후행 메소드...
	  List list = (List)retValue;
	  if(!list.isEmpty()){ //find~() 메소드를 수행시킨 결과로 뭔가가 들어있었다면
		 Object[ ] params= pjp.getArgs(); //
		 reportService.saveReport(params[0].toString()); //		 
	  }	 
	  return retValue;
  }  
}




















