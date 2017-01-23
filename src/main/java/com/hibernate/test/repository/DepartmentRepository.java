package com.hibernate.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hibernate.test.domain.Department;

@Transactional
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
