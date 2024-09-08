package com.tyutyunik.employeeWebWithLib.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Employee Name Is Not Correct Exception")
public class EmployeeNameIsNotCorrectException extends Exception {
    public EmployeeNameIsNotCorrectException() {
        super("Employee Name Is Not Correct Exception");
        System.out.println("[EXCEPTION] Employee name isn't correct");
    }
}
