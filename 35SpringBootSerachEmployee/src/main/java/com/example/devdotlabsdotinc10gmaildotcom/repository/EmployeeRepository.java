package com.example.devdotlabsdotinc10gmaildotcom.repository;

import com.example.devdotlabsdotinc10gmaildotcom.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
