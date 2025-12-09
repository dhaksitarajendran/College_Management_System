package com.wipro.cms.entity;

public class Student {
     private String studentId ;
     private String name;
     private String program  ;
     private int currentCredits;

    public Student(int currentCredits, String name, String program, String studentId) {
        this.currentCredits = currentCredits;
        this.name = name;
        this.program = program;
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getProgram() {
        return program;
    }

    public int getCurrentCredits() {
        return currentCredits;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public void setCurrentCredits(int currentCredits) {
        this.currentCredits = currentCredits;
    }

}
