package com.acm.lkm.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acm.lkm.bean.EmployeeBean;
import com.acm.lkm.service.EmployeeService;

public class UITester {

	public static void main(String[] args) {
		
		EmployeeService  employeeService = null;
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/acm/lkm/resources/cst-main-config.xml");
		employeeService = applicationContext.getBean("employeeServiceImpl", EmployeeService.class);
		
		addEmployee(employeeService);
		

	}

	private static void addEmployee(EmployeeService employeeImpl) {
		// TODO Auto-generated method stub
		
		EmployeeBean bean = new EmployeeBean();
		bean.setEmpId(121);
		bean.setEmpName("sam");
		bean.setSalary(1234.5);
		
		int id = employeeImpl.addEmployee(bean);
		
		System.out.println("Employee Registred successfully "+id);
	}

}
