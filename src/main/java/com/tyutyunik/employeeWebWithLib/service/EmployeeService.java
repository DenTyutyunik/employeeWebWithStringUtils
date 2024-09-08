package com.tyutyunik.employeeWebWithLib.service;

import com.tyutyunik.employeeWebWithLib.model.Employee;

import java.util.List;

public interface EmployeeService {
    String standardAnswer();

    List<Employee> getData();

    Employee addEmployee(String firstName, String lastName) throws Exception;

    Employee removeEmployee(String firstName, String lastName) throws Exception;

    Employee findEmployee(String firstName, String lastName) throws Exception;
}
