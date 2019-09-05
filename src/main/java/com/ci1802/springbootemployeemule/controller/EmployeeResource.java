package com.ci1802.springbootemployeemule.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ci1802.springbootemployeemule.dao.EmployeeRepo;
import com.ci1802.springbootemployeemule.model.entity.Employee;
import com.ci1802.springbootemployeemule.model.enumclass.HrStatus;
import com.ci1802.springbootemployeemule.searchapi.SearchFieldExtractor;
import com.ci1802.springbootemployeemule.searchapi.SpecificationComb;

@RestController
public class EmployeeResource {

	/**
	 * Matching Employeerepo implementations and inject its methods
	 * 
	 * @see https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/annotation/Autowired.html
	 */
	@Autowired
	EmployeeRepo employeerepo;

	@GetMapping(value = "/employees")
	public Page<Employee> getEmployee(Pageable pageable) {
		return (Page<Employee>) employeerepo.findAll(pageable);
	}

	@GetMapping(value = "/employees/{id}")
	public ResponseEntity<Object> findEmployee(@PathVariable String id) {

		Optional<Employee> employee = employeerepo.findById(id);
		if (employee.isPresent()) {
			return new ResponseEntity<Object>(employee, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(value = "/employees/active")
	public Page<Employee> findAllActiveEmployee(Pageable pageable) {
		return (Page<Employee>) employeerepo.findByHrStatus(HrStatus.ACTIVE, pageable);
	}

	@GetMapping(value = "/employees/search")
	public Page<Employee> findAllActiveEmployee(Pageable pageable, SearchFieldExtractor<Employee> searchFieldExtractor) {
		SpecificationComb speccomb = new SpecificationComb();
		return (Page<Employee>) employeerepo.findAll(speccomb.combSpecification(searchFieldExtractor), pageable);
	}

/*	@PostMapping(value = "/employees")
	public ResponseEntity<Object> insertEmployee(@RequestBody Employee employee) {
		Employee employeesaved = employeerepo.save(employee);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(employeesaved.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable String id) {
		employeerepo.deleteById(id);
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee, @PathVariable String id) {
		Optional<Employee> employeeOptional = employeerepo.findById(id);
		if (!employeeOptional.isPresent())
			return ResponseEntity.notFound().build();
		employee.setId(id);
		employeerepo.save(employee);
		return ResponseEntity.noContent().build();
	}*/
}
