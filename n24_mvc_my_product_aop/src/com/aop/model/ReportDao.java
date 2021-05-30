package com.aop.model;

import java.util.List;

public interface ReportDao {
	public void insertReport(String word) throws Exception;
	public int updateReport(String word) throws Exception;
	public List selectReport() throws Exception;
}
