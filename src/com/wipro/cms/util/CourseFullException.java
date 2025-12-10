package com.wipro.cms.util;

public class CourseFullException extends Exception {

    @Override
    public String toString() {
        return "CourseFullException Occurred: The course has reached its maximum capacity.";
     
    }
    
}
