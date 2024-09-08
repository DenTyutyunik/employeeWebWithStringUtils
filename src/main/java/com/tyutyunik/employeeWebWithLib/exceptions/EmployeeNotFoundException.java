package com.tyutyunik.employeeWebWithLib.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Employee Not Found Exception")
public class EmployeeNotFoundException extends Exception {
    public EmployeeNotFoundException() {
        super("Employee Not Found Exception");
        System.out.println("[EXCEPTION] Employee not found");
    }
}
