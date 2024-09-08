package com.tyutyunik.employeeWebWithLib.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Employee Storage Is Full Exception")
public class EmployeeStorageIsFullException extends Exception {
    public EmployeeStorageIsFullException() {
        super("Employee Storage Is Full Exception");
        System.out.println("[EXCEPTION] Employee storage is full");
    }
}
