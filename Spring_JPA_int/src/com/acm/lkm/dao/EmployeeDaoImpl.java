package com.acm.lkm.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.acm.lkm.bean.EmployeeBean;
import com.acm.lkm.entity.EmployeeEntity;

@Repository
public class EmployeeDaoImpl  implements EmployeeDao{
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Override
	public Integer addEmployee(EmployeeBean employeeBean) {
		
		Integer empId = 0;
		EntityManager entityManager = null;
		
		EmployeeEntity employeeEntityBean = convertBeanToEntity(employeeBean);
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(employeeEntityBean);
		entityManager.getTransaction().commit();
		empId = employeeEntityBean.getEmpId();
		
		return empId;

	}

	private EmployeeEntity convertBeanToEntity(EmployeeBean employeeBean) {
		EmployeeEntity employeeEntity1 = new EmployeeEntity();
		BeanUtils.copyProperties(employeeBean,employeeEntity1);
		return employeeEntity1;
	}

}
