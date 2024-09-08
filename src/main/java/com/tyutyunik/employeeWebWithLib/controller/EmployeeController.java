package com.tyutyunik.employeeWebWithLib.controller;

import org.springframework.web.bind.annotation.*;
import com.tyutyunik.employeeWebWithLib.exceptions.BadRequestException;
import com.tyutyunik.employeeWebWithLib.model.Employee;
import com.tyutyunik.employeeWebWithLib.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public static void checkArguments(String arg1, String arg2) throws Exception {
        if (arg1 == null || arg2 == null) {
            throw new BadRequestException();
        }
    }

    @GetMapping("")
    public String standardAnswer() {
        return employeeService.standardAnswer();
    }

    @GetMapping("/get/all")
    public List<Employee> getData() {
        return employeeService.getData();
    }

    @GetMapping("/add")
    public Employee add(@RequestParam(required = false) String firstName,
                        @RequestParam(required = false) String lastName) throws Exception {
        checkArguments(firstName, lastName);
        return employeeService.addEmployee(firstName, lastName);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam(required = false) String firstName,
                           @RequestParam(required = false) String lastName) throws Exception {
        checkArguments(firstName, lastName);
        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam(required = false) String firstName,
                         @RequestParam(required = false) String lastName) throws Exception {
        checkArguments(firstName, lastName);
        return employeeService.findEmployee(firstName, lastName);
    }
}
