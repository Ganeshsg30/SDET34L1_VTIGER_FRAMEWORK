package com.vtiger.practice;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.sdet34l1.genericlibrary.JavaUtility;

public class GetDateTest 
{
	public static void main(String[] args) 
	{
		JavaUtility javaUtil = new JavaUtility();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_sss");
		String date1=sdf.format(date);
		javaUtil.printStatement(date1);
	}
}
