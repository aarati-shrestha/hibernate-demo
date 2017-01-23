package com.hibernate.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hibernate.test.domain.Employee;


@Transactional
@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Integer> {

}
