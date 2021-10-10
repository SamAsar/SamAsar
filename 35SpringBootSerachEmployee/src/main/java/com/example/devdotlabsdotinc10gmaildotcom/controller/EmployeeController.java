package com.example.devdotlabsdotinc10gmaildotcom.controller;

import com.example.devdotlabsdotinc10gmaildotcom.model.Employee;
import com.example.devdotlabsdotinc10gmaildotcom.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @GetMapping("/")
  public String add(Model model){

      List<Employee> employee = employeeService.listAll();

      model.addAttribute("employee", new Employee());

      return "index";
  }

  @PostMapping("/search")
  public String searchEmployee(@ModelAttribute(name = "employeeData") Employee formData, Model model){

      Employee employee = employeeService.get(formData.getId());

      model.addAttribute("employee", employee);

      return "index";
  }

}
