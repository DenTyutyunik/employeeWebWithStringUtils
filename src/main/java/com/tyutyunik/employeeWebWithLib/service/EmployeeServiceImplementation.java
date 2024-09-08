package com.tyutyunik.employeeWebWithLib.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import com.tyutyunik.employeeWebWithLib.model.Employee;
import com.tyutyunik.employeeWebWithLib.exceptions.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImplementation implements EmployeeService {
    private static final int EMPLOYEES_MAX = 10;
    private List<Employee> employees = new ArrayList<>();

    @Override
    public String standardAnswer() {
        return "Добро пожаловать в менеджер сотрудников";
    }

    @Override
    public List<Employee> getData() {
        System.out.println("getData");
        return employees;
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) throws Exception {
        if (employees.size() >= EMPLOYEES_MAX) {
            throw new EmployeeStorageIsFullException();
        }
        if (!(validateName(firstName)) || !(validateName(lastName))) {
            throw new EmployeeNameIsNotCorrectException();
        }
        Employee employee = new Employee(improveName(firstName), improveName(lastName));
        if (employeeExists(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        System.out.println("Employee added\n");
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) throws Exception {
        Employee employee = new Employee(firstName, lastName);
        for (int i = 0; i < employees.size(); i++) {
            if (firstName.equals(employees.get(i).getFirstName()) && lastName.equals(employees.get(i).getLastName())) {
                System.out.println("Employee removed\n");
                employees.remove(i);
                return employee;
            }
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) throws Exception {
        Employee employee = new Employee(firstName, lastName);
        for (int i = 0; i < employees.size(); i++) {
            if (firstName.equals(employees.get(i).getFirstName()) && lastName.equals(employees.get(i).getLastName())) {
                System.out.println("Employee found\n");
                return employee;
            }
        }
        throw new EmployeeNotFoundException();
    }

    private boolean employeeExists(Employee employee) throws Exception {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).isEquals(employee)) {
                System.out.println("Employee exists");
                return true;
            }
        }
        System.out.println("Employee doesn't exist");
        return false;
    }

    private boolean validateName(String name) {
        return StringUtils.isAlpha(name);
    }

    private String improveName(String name) {
        return StringUtils.capitalize(name);
    }
}
