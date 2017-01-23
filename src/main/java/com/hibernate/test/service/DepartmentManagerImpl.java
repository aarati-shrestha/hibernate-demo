package com.hibernate.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernate.test.api.DepartmentManager;
import com.hibernate.test.domain.Department;
import com.hibernate.test.repository.DepartmentRepository;

@Service
public class DepartmentManagerImpl implements DepartmentManager {
	
	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Department addNew(Department t) {
		// TODO Auto-generated method stub
		return this.departmentRepository.save(t);
	}

	@Override
	public void addAll(List<Department> list) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Department update(Department t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Department t) {
		this.departmentRepository.delete(t);
	}

	@Override
	public void removeBy(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Department find(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> findWithPaging(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long countRecord() {
		// TODO Auto-generated method stub
		return null;
	}

}
