package com.aop.model;

import java.util.List;

public class ReportServiceImpl implements ReportService{
	private ReportDao reportDao;
	
	public void setReportDao(ReportDao reportDao) {
		System.out.println("::"+getClass().getName()+".setReportDao() Call....");
		this.reportDao = reportDao;
	}
	@Override
	public void saveReport(String word) throws Exception {
		/*
		 * update한 결과가 0이라면...word가 없는 경우가 된다
		 * 그럴땐 insertReport가 호출되도록 한다..
		 */
		
		if(reportDao.updateReport(word)==0) 
		   reportDao.insertReport(word);		
	}
	@Override
	public List selectReport() throws Exception {
		return reportDao.selectReport();
	}
}














