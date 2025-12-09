package com.wipro.cms.Service;

import com.wipro.cms.entity.Enrollment;
import com.wipro.cms.util.CourseFullException;
import com.wipro.cms.util.EnrollmentException;
import com.wipro.cms.util.InvalidStudentException;

public class CollegeService {
    public
CollegeService(ArrayList<Student>,
ArrayList<Course>,
ArrayList<Enrollment>) {
        
    }

    public boolean validateStudent(String studentId) throws InvalidStudentException {

    }

    public boolean validateCourse(String courseId) throws EnrollmentException {

    }

    public boolean checkCourseCapacity(String courseId)
            throws CourseFullException {

    }

    public Enrollment enrollStudent(String studentId, String courseId, String semester)
            throws Exception {

    }

    public boolean dropEnrollment(String enrollmentId) throws EnrollmentException {

    }

    public double calculateFee(String courseId) {

    }

    public void printStudentEnrollments(String studentId) {

    }
}
