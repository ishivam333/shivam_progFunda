package com.gradedproject.q1;

public class driverClass {
public static void main(String[] args) {
	hrDepartment hr=new hrDepartment();
	adminDepartment admin=new adminDepartment();
	techDepartment tech=new techDepartment();
	System.out.println(admin.departmentName());
	System.out.println(admin.getTodaysWork());
	System.out.println(admin.getWorkDeadline());
	System.out.println(admin.isTodayAHoliday()); 
	System.out.println();
	System.out.println(hr.departmentName());
	System.out.println(hr.doActivity());
	System.out.println(hr.getTodaysWork());
	System.out.println(hr.getWorkDeadline());
	System.out.println(hr.isTodayAHoliday()); 
	System.out.println();
	System.out.println(tech.departmentName());
	System.out.println(tech.getTodaysWork());
	System.out.println(tech.getWorkDeadline());
	System.out.println(tech.getTechStackInformation());
	System.out.println(tech.isTodayAHoliday());
	 
	

}
}
