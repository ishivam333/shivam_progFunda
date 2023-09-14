package com.gl.bean;

import java.io.Serializable;

public class EmployeeDetail  implements Serializable {
	 String employeeId ;
	 String employeeName;
	 String employeePhone ;
	 String employeeAddress;
	 int EmployeeSalary ; 	
	 public EmployeeDetail(String employeeId, String employeeName, String employeePhone, String employeeAddress,
			int employeeSalary) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeePhone = employeePhone;
		this.employeeAddress = employeeAddress;
		EmployeeSalary = employeeSalary;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeePhone() {
		return employeePhone;
	}
	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}
	public String getEmployeeAddress() {
		return employeeAddress;
	}
	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}
	public int getEmployeeSalary() {
		return EmployeeSalary;
	}
	public void setEmployeeSalary(int employeeSalary) {
		EmployeeSalary = employeeSalary;
	}
	@Override
	public String toString() {
		return "EmployeeDetail [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeePhone="
				+ employeePhone + ", employeeAddress=" + employeeAddress + ", EmployeeSalary=" + EmployeeSalary + "]";
	}
	public EmployeeDetail() {
		super();
		
	}
	
	
	
	
	

}
