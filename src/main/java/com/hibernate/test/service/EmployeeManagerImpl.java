package com.hibernate.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernate.test.api.EmployeeManager;
import com.hibernate.test.domain.Employee;
import com.hibernate.test.repository.EmployeeRepository;

@Service
public class EmployeeManagerImpl implements EmployeeManager {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee addNew(Employee t) {
		// TODO Auto-generated method stub
		return this.employeeRepository.save(t);
	}

	@Override
	public void addAll(List<Employee> list) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee update(Employee t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Employee t) {
		this.employeeRepository.delete(t);
		
	}

	@Override
	public void removeBy(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee find(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> findWithPaging(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long countRecord() {
		// TODO Auto-generated method stub
		return null;
	}
}
