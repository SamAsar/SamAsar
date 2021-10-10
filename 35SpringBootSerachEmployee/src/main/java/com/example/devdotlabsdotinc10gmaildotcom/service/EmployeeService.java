package com.example.devdotlabsdotinc10gmaildotcom.service;

import com.example.devdotlabsdotinc10gmaildotcom.model.Employee;
import com.example.devdotlabsdotinc10gmaildotcom.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

 @Autowired
 private EmployeeRepository employeeRepository;


 public List<Employee> listAll() {

  return this.employeeRepository.findAll();
 }

 public Employee get(Long id) {

  return this.employeeRepository.getById(id);
 }
}
