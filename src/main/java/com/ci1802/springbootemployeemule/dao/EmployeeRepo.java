package com.ci1802.springbootemployeemule.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ci1802.springbootemployeemule.model.entity.Employee;
import com.ci1802.springbootemployeemule.model.enumclass.HrStatus;



public interface EmployeeRepo extends JpaRepository<Employee, String>,JpaSpecificationExecutor<Employee>{
	/** Declare JPA query methods based on extending JpaRepository which has Standard CRUD functionality repositories. 
	 * This Repository has queries on the underlying datastore
	 * @see https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods
	 */
	Page<Employee> findByHrStatus(HrStatus hrstatus,Pageable pageable);
}
