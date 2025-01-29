package com.acm.lkm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acm.lkm.bean.EmployeeBean;
import com.acm.lkm.dao.EmployeeDao;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeDao employeeDao;

	@Override
	public Integer addEmployee(EmployeeBean employeeBean) {

		return employeeDao.addEmployee(employeeBean);
	}

}
