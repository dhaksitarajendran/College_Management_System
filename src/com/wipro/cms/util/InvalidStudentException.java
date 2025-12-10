package com.wipro.cms.util;

public class InvalidStudentException extends Exception {
    @Override
    public String toString() {
       return "InvalidStudentException Occurred: The student ID provided is invalid.";
    }
}
